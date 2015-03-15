package game.logic;

import cards.Card;
import cards.Minion;
import cards.OffensiveAOE;
import cards.containers.Deck;
import cards.minions.Archer;
import cards.minions.Swordman;
import game.assets.Assets;
import game.ui.Locations;
import game.ui.UserInterface;
import java.util.ArrayList;

/**
 *
 * @author Eero Kuurne
 */
public class LogicHandler {

    private UserInterface ui;

    private boolean betweenTurns;

    private int turn;
    private Player player1;
    private Player player2;

    private Minion chosenHandMinion;
    private int chosenHandMinionSlot;

    private OffensiveAOE chosenHandOffensiveAOE;
    private int chosenHandOffensiveAOESlot;

    private Minion chosenTableCard;
    private int chosenTableSlot;

    public LogicHandler(UserInterface ui) {
        this.turn = 1;
        this.chosenHandMinion = null;
        this.chosenHandMinionSlot = -1;
        this.ui = ui;
        this.betweenTurns = false;

        init();
    }

    public void init() {
        DeckBuilder deckBuilder = new DeckBuilder();

        Deck deck1 = deckBuilder.getDeck1();
        Deck deck2 = deckBuilder.getDeck2();

        this.player1 = new Player(deck1, 1);
        this.player2 = new Player(deck2, 2);

        updateResources(player1);
        player2.changeMaxTurnResources(15); // Player 2 gets 5 more for turn 1 because he didn't start.

        for (int i = 1; i < 7; i++) {
            player1.getHand().addCard(player1.getDeck().takeCard());
            player2.getHand().addCard(player2.getDeck().takeCard());
        }

        player1.getHand().cardPositions(1);
        player2.getHand().cardPositions(2);

        ui.repaint();
    }

    /**
     * What happens when the player clicks "End turn" button.
     *
     */
    public void changeTurn() {
        if (!betweenTurns) {
            endTurn();
        } else {
            startTurn();
        }
        clearChosen();
        updateCardPositions();
        ui.repaint();
    }

    public void endTurn() {
        Player endingPlayer;
        Player startingPlayer;
        if (turn % 2 == 0) {
            endingPlayer = player2;
            startingPlayer = player1;
        } else {
            endingPlayer = player1;
            startingPlayer = player2;
        }
        influenceChange(startingPlayer, endingPlayer);
        betweenTurns = true;
    }

    public void startTurn() {
        turn++;
        Player startingPlayer;
        if (turn % 2 != 0) {
            startingPlayer = player1;
        } else {
            startingPlayer = player2;
        }
        drawCard(startingPlayer);
        updateResources(startingPlayer);
        setMinionTurnLeftsTrue(startingPlayer);
        betweenTurns = false;
    }

    // Split to smaller methods.
    public void clearChosen() {
        if (chosenHandMinion != null) {
            Minion chosenH = chosenHandMinion;
            if (turn % 2 != 0) {
                chosenH.setLocation(chosenH.getX(), Locations.player1HandY);
            } else {
                chosenH.setLocation(chosenH.getX(), Locations.player2HandY);
            }
            chosenHandMinion = null;
            chosenHandMinionSlot = -1;
        }
        if (chosenTableCard != null) {
            Minion chosenT = chosenTableCard;
            if (turn % 2 != 0) {
                chosenT.setLocation(chosenT.getX(), Locations.player1TableY);
            } else {
                chosenT.setLocation(chosenT.getX(), Locations.player2TableY);
            }
            chosenTableCard = null;
            chosenTableSlot = -1;
        }
        if (chosenHandOffensiveAOE != null) {
            OffensiveAOE offensiveAOE = chosenHandOffensiveAOE;
            if (turn % 2 != 0) {
                offensiveAOE.setLocation(offensiveAOE.getX(), Locations.player1HandY);
            } else {
                offensiveAOE.setLocation(offensiveAOE.getX(), Locations.player2HandY);
            }
            chosenHandOffensiveAOE = null;
            chosenHandOffensiveAOESlot = -1;
        }
    }

    public void updateCardPositions() {
        // Update hands.
        player1.getHand().cardPositions(1);
        player2.getHand().cardPositions(2);

        // Update tables.
        player1.getTable().cardPositions(1);
        player2.getTable().cardPositions(2);
    }

    public void drawCard(Player player) {
        player.getHand().addCard(player.getDeck().takeCard());
    }

    public void updateResources(Player player) {
        if (turn != 2) { // Fixes the player 2 starting resources.
            player.changeMaxTurnResources(10);
        }

        player.setMaxResources(player.getMaxTurnResources());
        for (int i = 0; i < 8; i++) {
            if (player.getTable().getMinions()[i] != null) {
                player.changeMaxResources(player.getTable().getMinions()[i].getProduction());
            }
        }

        player.setRemainingResources(player.getMaxResources());
    }

    public void clickHandSlot(int slot, Player player) {
        Card card = player.getHand().getCards().get(slot);
        if (card.getCost() <= player.getRemainingResources()) {
            card.clickInHand(this, slot);
        } else {
            clearChosen();
            /*player.getHand().getCards().get(slot).paintHover(ui.getGraphics());
            ui.repaint();*/
        }
    }

    public void placeChosenMinionToTable(int slot, Player playerA, Player playerB) {
        if (playerA.getTable().getMinions()[slot] == null) {
            playerA.getTable().insertMinion(chosenHandMinion, slot);
            playerA.getHand().takeCard(chosenHandMinionSlot);
            playerA.changeRemainingResources(-chosenHandMinion.getCost());
            chosenHandMinion.enterTable(playerA, playerB, slot);
            clearChosen();
            updateCardPositions();
        }
        clearChosen();
    }

    // Split to smaller methods.
    public void minionAttack(int attackingSlot, int defendingSlot,
            Player attackingPlayer, Player defendingPlayer) {

        Minion attacker = attackingPlayer.getTable().getMinions()[attackingSlot];
        Minion defender = defendingPlayer.getTable().getMinions()[defendingSlot];

        // If there are adjacent guardians, guide the attack to them. If both
        // sides are guardians, attack left one.
        ArrayList<Integer> guardianSlots = checkGuardians(defendingPlayer);
        if (guardianSlots.contains(defendingSlot - 1)) {
            defendingSlot--;
            defender = defendingPlayer.getTable().getMinions()[defendingSlot];
        } else if (guardianSlots.contains(defendingSlot + 1)) {
            defendingSlot++;
            defender = defendingPlayer.getTable().getMinions()[defendingSlot];
        }
        // Attacker uses his turn.
        attacker.setTurnLeft(false);

        // Defender takes damage.
        if (attacker.getDeadly()) {
            defender.changeHealth(-defender.getHealth());
        } else {
            defender.changeHealth(-attacker.getDamage());
        }

        // If attacker isn't ranged, he takes damage too.
        if (!attacker.getRanged()) {
            if (defender.getDeadly()) {
                attacker.changeHealth(-attacker.getHealth());
            } else {
                attacker.changeHealth(-defender.getDamage());
            }
        }

        // Remove dead minions.
        if (defender.getHealth() <= 0) {
            defendingPlayer.getTable().getMinions()[defendingSlot].die();
            defendingPlayer.getTable().removeMinion(defendingSlot);
        }
        if (attacker.getHealth() <= 0) {
            attackingPlayer.getTable().getMinions()[attackingSlot].die();
            attackingPlayer.getTable().removeMinion(attackingSlot);
        }

        updateCardPositions();
        ui.repaint();
    }

    private void influenceChange(Player startingPlayer, Player endingPlayer) {
        int influenceLost = 0;
        for (int i = 0; i < 8; i++) {
            if (endingPlayer.getTable().getMinions()[i] != null
                    && endingPlayer.getTable().getMinions()[i].getTurnleft()) {
                influenceLost += endingPlayer.getTable().getMinions()[i].getDamage();
                endingPlayer.getTable().getMinions()[i].setTurnLeft(false);
            }
        }
        startingPlayer.changeRemainingInfluence(-influenceLost);
    }

    public void setMinionTurnLeftsTrue(Player startingPlayer) {
        for (int i = 0; i < 8; i++) {
            if (startingPlayer.getTable().getMinions()[i] != null
                    && startingPlayer.getTable().getMinions()[i].getProduction() == 0) {
                startingPlayer.getTable().getMinions()[i].setTurnLeft(true);
            }
        }
    }

    /**
     * Checks the slots of guardians in param player's table. Can be used to
     * guide attacks or repaint guardian icons.
     *
     * @param player Which player's table is checked.
     * @return ArrayList of the guardian slots.
     */
    public ArrayList<Integer> checkGuardians(Player player) {
        ArrayList<Integer> guardians = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (player.getTable().getMinions()[i] != null
                    && player.getTable().getMinions()[i].getGuardian()) {
                guardians.add(i);
            }
        }
        return guardians;
    }

    public Player[] checkPlayerTurn() {
        Player[] players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        if (turn % 2 == 0) {
            players[0] = player2;
            players[1] = player1;
        }
        return players;
    }

    public void playerATableClicked(int x, int y, Player playerA, Player playerB) {
        for (int i = 0; i < 8; i++) {

            if (x >= Locations.tableSlotX[i] && x <= Locations.tableX[i] + Assets.tableSlotWidth
                    && chosenHandMinion != null && playerA.getTable().getMinions()[i] == null) {
                placeChosenMinionToTable(i, playerA, playerB);
                return;
            } else if (playerA.getTable().getMinions()[i] != null && x >= playerA.getTable().getMinions()[i].getX()
                    && x <= playerA.getTable().getMinions()[i].getX() + Assets.smallWidth) {
                playerA.getTable().getMinions()[i].clickInTable(this, i);
                return;
            }
        }
        clearChosen();
    }

    public void playerBTableClicked(int x, int y, Player playerA, Player playerB) {
        for (int i = 0; i < 8; i++) {
            if (chosenTableCard != null && playerB.getTable().getMinions()[i] != null
                    && x >= Locations.tableSlotX[i] && x <= Locations.tableSlotX[i] + Assets.tableSlotWidth) {
                minionAttack(chosenTableSlot, i, playerA, playerB);
                clearChosen();
                return;
            }
        }
        clearChosen();
    }

    public void playerAHandClicked(int x, int y, Player player) {
        for (int i = 0; i < player.getHand().getRemaining(); i++) {
            if (x >= player.getHand().getCards().get(i).getX()
                    && x <= player.getHand().getCards().get(i).getX() + Assets.smallWidth) {
                clickHandSlot(i, player);
                return;
            }
        }
        clearChosen();
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Minion getChosenHandMinion() {
        return chosenHandMinion;
    }

    public void setChosenHandMinion(Minion chosenCard) {
        this.chosenHandMinion = chosenCard;
    }

    public int getChosenHandMinionSlot() {
        return chosenHandMinionSlot;
    }

    public Minion getChosenTableCard() {
        return chosenTableCard;
    }

    public int getChosenTableSlot() {
        return chosenTableSlot;
    }

    public void setChosenHandMinionSlot(int chosenHandSlot) {
        this.chosenHandMinionSlot = chosenHandSlot;
    }

    public void setChosenTableCard(Minion chosenTableCard) {
        this.chosenTableCard = chosenTableCard;
    }

    public void setChosenTableSlot(int chosenTableSlot) {
        this.chosenTableSlot = chosenTableSlot;
    }

    public boolean getBetweenTurns() {
        return betweenTurns;
    }

    public void setBetweenTurns(boolean betweenTurns) {
        this.betweenTurns = betweenTurns;
    }

    public OffensiveAOE getChosenHandOffensiveAOE() {
        return chosenHandOffensiveAOE;
    }

    public void setChosenHandOffensiveAOE(OffensiveAOE chosenHandAOE) {
        this.chosenHandOffensiveAOE = chosenHandAOE;
    }

    public int getChosenHandOffensiveAOESlot() {
        return chosenHandOffensiveAOESlot;
    }

    public void setChosenHandOffensiveAOESlot(int chosenHandAOESlot) {
        this.chosenHandOffensiveAOESlot = chosenHandAOESlot;
    }

    public UserInterface getUi() {
        return ui;
    }

    public void playerAHandHover(int x, int y, Player player) {
        if (chosenHandMinion == null && chosenHandOffensiveAOE == null) {
            for (int i = 0; i < player.getHand().getRemaining(); i++) {
                if (x >= player.getHand().getCards().get(i).getX()
                        && x <= player.getHand().getCards().get(i).getX() + Assets.smallWidth) {
                    player.getHand().getCards().get(i).paintHover(ui.getGraphics());
                    return;
                }
            }
        }
        ui.repaint();
    }

    public void playerBTableHover(int mx, int my, Player playerA, Player playerB) {
    }

    public void playerATableHover(int mx, int my, Player playerA, Player playerB) {
    }

    public void changeTurnHover() {
    }

}
