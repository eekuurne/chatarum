package game.logic;

import cards.Card;
import cards.Minion;
import cards.OffensiveAOE;
import cards.containers.Deck;
import cards.minions.Archer;
import cards.minions.Swordman;
import game.AI.AI;
import game.AI.SimpleAI;
import game.assets.Assets;
import game.ui.Locations;
import game.ui.UserInterface;
import java.util.ArrayList;

/**
 * Handles the logic of the game.
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

    private int player1Wins;
    private int player2Wins;
    private boolean AITesting;

    public LogicHandler(UserInterface ui, AI player1AI, AI player2AI) {
        this.turn = 1;
        this.chosenHandMinion = null;
        this.chosenHandMinionSlot = -1;
        this.ui = ui;
        this.betweenTurns = false;

        this.player1Wins = 0;
        this.player2Wins = 0;
        this.AITesting = false;

        init(player1AI, player2AI);
    }

    /**
     * Builds decks, setups players and AIs, sets starting resources,picks
     * starting cards and repaints the UI at the start of the game.
     *
     * @param player1AI Player 1's AI
     * @param player2AI Player 2's AI
     */
    public void init(AI player1AI, AI player2AI) {
        DeckBuilder deckBuilder = new DeckBuilder();
        Deck deck1 = deckBuilder.getDeck1();
        Deck deck2 = deckBuilder.getDeck2();

        this.player1 = new Player(deck1, 1);
        this.player2 = new Player(deck2, 2);

        setupAI(player1AI, player2AI);

        updateResources(player1);
        player2.changeMaxTurnResources(15); // Player 2 gets 5 more for turn 1 because he didn't start.

        for (int i = 1; i < 8; i++) {
            player1.getHand().addCard(player1.getDeck().takeCard());
            player2.getHand().addCard(player2.getDeck().takeCard());
        }

        updateCardPositions();
        repaint();
    }

    /**
     * Setups the handlers and players for the AIs.
     *
     * @param player1AI Player 1's AI
     * @param player2AI Player 2's AI
     */
    public void setupAI(AI player1AI, AI player2AI) {
        if (player1AI != null) {
            this.player1.setAI(player1AI);
            this.player1.getAI().setHandler(this);
            this.player1.getAI().setPlayerA(player1);
            this.player1.getAI().setPlayerB(player2);
        }
        if (player2AI != null) {
            this.player2.setAI(player2AI);
            this.player2.getAI().setHandler(this);
            this.player2.getAI().setPlayerA(player2);
            this.player2.getAI().setPlayerB(player1);
        }
    }

    /**
     * What happens when the player clicks "End turn" button.
     */
    public void changeTurn() {
        if (!betweenTurns) {
            endTurn();
        } else {
            startTurn();
        }
        clearChosen();
        updateCardPositions();

        repaint();
    }

    /**
     * Ends the turn.
     *
     * @return 0 if game didn't end, 1 if player 1 wins, 2 if player 2 wins.
     */
    public int endTurn() {
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

        if (endGame() != 0) {
            return endGame();
        }

        if (!AITesting) {
            playAI(startingPlayer, endingPlayer);
        }

        return 0;
    }

    /**
     * Starts the turn.
     */
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

    /**
     * Ends the game if some player's health goes to 0.
     *
     * @return 0 if game didn't end, 1 if player 1 wins, 2 if player 2 wins.
     */
    private int endGame() {
        if (player1.getRemainingInfluence() <= 0 || (turn >= 100
                && player1.getRemainingInfluence() <= player2.getRemainingInfluence())) {
            //System.out.println("Player 2 wins!");
            return 2;
        } else if (player2.getRemainingInfluence() <= 0 || (turn >= 100
                && player2.getRemainingInfluence() < player1.getRemainingInfluence())) {
            //System.out.println("Player 1 wins!");
            return 1;
        }
        return 0;
    }

    /**
     * Plays a turn for AI.
     *
     * @param startingPlayer Player who is about to start turn.
     * @param endingPlayer Player who ended the last turn.
     */
    private void playAI(Player startingPlayer, Player endingPlayer) {
        if (startingPlayer.getAI() != null) {
            startTurn();

            startingPlayer.getAI().playTurn();

            endTurn();
            startTurn();
        }
    }

    /**
     * Clears the chosen card.
     *
     * (Refactor later)
     */
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

    /**
     * Updates the card positions on screen after something changes.
     */
    public void updateCardPositions() {
        // Update hands.
        player1.getHand().cardPositions(1);
        player2.getHand().cardPositions(2);

        // Update tables.
        player1.getTable().cardPositions(1);
        player2.getTable().cardPositions(2);
    }

    /**
     * Draws a card from the players deck and puts it in his hand.
     *
     * @param player The player who draws the card.
     */
    public void drawCard(Player player) {
        player.getHand().addCard(player.getDeck().takeCard());
    }

    /**
     * Updates resources of a player.
     *
     * @param player The player whose resources will be updated.
     */
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

    /**
     * What happens when player clicks a card in hand.
     *
     * @param slot The slot which is clicked.
     * @param player The player whose hand is clicked.
     */
    public void clickHandSlot(int slot, Player player) {
        Card card = player.getHand().getCards().get(slot);
        if (card.getCost() <= player.getRemainingResources()) {
            card.clickInHand(this, slot);
        } else {
            clearChosen();
        }
    }

    /**
     * Method for placing minion to table.
     *
     * @param slot The table slot where minion is placed.
     * @param playerA The player whose turn it is.
     * @param playerB The enemy player.
     */
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

    /**
     * Method for minion attacking.
     *
     * @param attackingSlot The table slot of the attacking minion.
     * @param defendingSlot The table slot of the defending minion.
     * @param attackingPlayer The attacking player.
     * @param defendingPlayer The defending player.
     */
    public void minionAttack(int attackingSlot, int defendingSlot,
            Player attackingPlayer, Player defendingPlayer) {

        Minion attacker = attackingPlayer.getTable().getMinions()[attackingSlot];
        Minion defender = defendingPlayer.getTable().getMinions()[defendingSlot];

        // Checks if the defending minion is guarded by guardian.
        if (guarded(defendingPlayer.getTable().getMinions(), defendingSlot)) {
            return;
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

        repaint();

    }

    /**
     * Changes influence of a player if at the end of turn there are minions in
     * table who didn't use their turns.
     *
     * @param startingPlayer The player who is starting turn.
     * @param endingPlayer The The player who is ending turn.
     */
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

    /**
     * At the start of a player's turn, gives turns to all of his minions in
     * table.
     *
     * @param startingPlayer The player who is starting turn.
     */
    public void setMinionTurnLeftsTrue(Player startingPlayer) {
        for (int i = 0; i < 8; i++) {
            if (startingPlayer.getTable().getMinions()[i] != null
                    && startingPlayer.getTable().getMinions()[i].getProduction() == 0) {
                startingPlayer.getTable().getMinions()[i].setTurnLeft(true);
            }
        }
    }

    /**
     * Checks the slots of guardians in param player's table. Isn't used anywhere
     * at the moment.
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

    /**
     * @return Array of 2 Players where 1. slot is the player whose turn it is.
     */
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

    /**
     * What happens when player clicks his own table.
     *
     * @param x Mouse x-coordinate.
     * @param y Mouse y-coordinate.
     * @param playerA Player whose turn it is.
     * @param playerB The enemy player.
     */
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

    /**
     * What happens when player clicks his the enemy table.
     *
     * @param x Mouse x-coordinate.
     * @param y Mouse y-coordinate.
     * @param playerA Player whose turn it is.
     * @param playerB The enemy player.
     */
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

    /**
     * What happens when player clicks his own hand.
     *
     * @param x Mouse x-coordinate.
     * @param y Mouse y-coordinate.
     * @param player Player whose turn it is.
     */
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

    /**
     * Paints the card bigger if mouse is hovering over it.
     * 
     * @param x Mouse x-coordinate.
     * @param y Mouse y-coordinate.
     * @param player Player who is controlling the mouse.
     */
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
        repaint();
    }

    public void playerBTableHover(int mx, int my, Player playerA, Player playerB) {
    }

    public void playerATableHover(int mx, int my, Player playerA, Player playerB) {
    }

    public void changeTurnHover() {
    }

    /**
     * Repaint-method which isn't called if AIs are playing against each other.
     */
    public void repaint() {
        if (!AITesting) {
            ui.repaint();
        }
    }

    /**
     * Checks is the minion in given table and slot guarded by guardian.
     *
     * @param minions Table where the minion is
     * @param slot Slot of the minion
     * @return Is the minion in given slot guarded by guardian.
     */
    public boolean guarded(Minion[] minions, int slot) {
        if (minions[slot] != null && !minions[slot].getGuardian()
                && ((slot != 0 && minions[slot - 1] != null && minions[slot - 1].getGuardian())
                || (slot != 7 && minions[slot + 1] != null && minions[slot + 1].getGuardian()))) {
            return true;
        }
        return false;
    }

    public void setAITesting(boolean AITesting) {
        this.AITesting = AITesting;
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
}
