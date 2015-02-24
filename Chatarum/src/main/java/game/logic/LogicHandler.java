package game.logic;

import cards.Card;
import cards.Minion;
import cards.containers.Deck;
import cards.minions.Archer;
import cards.minions.Swordman;
import game.ui.Locations;
import game.ui.UserInterface;

/**
 *
 * @author Eero Kuurne
 */
public class LogicHandler {

    private int turn;

    private Minion chosenCard;
    private int chosenHandSlot;

    private Player player1;
    private Player player2;

    private UserInterface ui;

    public LogicHandler(UserInterface ui) {
        this.turn = 1;
        this.chosenCard = null;
        this.chosenHandSlot = -1;
        this.ui = ui;

        init();
    }

    public void init() {
        DeckBuilder deckBuilder = new DeckBuilder();

        Deck deck1 = deckBuilder.getDeck1();
        Deck deck2 = deckBuilder.getDeck2();

        this.player1 = new Player(deck1);
        this.player2 = new Player(deck2);

        updateResources(player1);
        player2.changeMaxResources(15); // Player 2 gets 5 more for turn 1 because he didn't start.

        for (int i = 1; i < 6; i++) {
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
        turn++;

        Player endingPlayer;
        Player startingPlayer;
        if (turn % 2 != 0) {
            endingPlayer = player2;
            startingPlayer = player1;
        } else {
            endingPlayer = player1;
            startingPlayer = player2;
        }

        
        
        influenceChange(startingPlayer, endingPlayer);
        
        drawCard(startingPlayer);
        updateResources(startingPlayer);
        setMinionTurnLeftsTrue(startingPlayer);

        clearChosen();

        updateCardPositions();
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

    public Minion getChosenCard() {
        return chosenCard;
    }

    public void setChosenCard(Minion chosenCard) {
        this.chosenCard = chosenCard;
    }

    public int getChosenHandSlot() {
        return chosenHandSlot;
    }

    public void setChosenHandSlot(int chosenHandSlot) {
        this.chosenHandSlot = chosenHandSlot;
    }

    public void clearChosen() {
        if (chosenCard != null) {
            Minion chosen = chosenCard;
            if (turn % 2 != 0) {
                chosen.setLocation(chosen.getX(), Locations.player1HandY);
            } else {
                chosen.setLocation(chosen.getX(), Locations.player2HandY);
            }
            chosenCard = null;
            chosenHandSlot = -1;
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
            player.changeMaxResources(10);
        }

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
        }
    }

    public void placeChosenMinionToTable(int slot, Player player) {
        if (player.getTable().getMinions()[slot] == null) {
            player.getTable().insertMinion(chosenCard, slot);
            player.getHand().takeCard(chosenHandSlot);
            player.changeRemainingResources(-chosenCard.getCost());
            clearChosen();
            updateCardPositions();
        }
        clearChosen();
    }

    private void influenceChange(Player startingPlayer, Player endingPlayer) {
        int influenceLost = 0;
        for (int i = 0; i < 8; i++) {
            if (endingPlayer.getTable().getMinions()[i] != null 
                    && endingPlayer.getTable().getMinions()[i].getTurnleft()) {
                influenceLost += endingPlayer.getTable().getMinions()[i].getDamage();
            }
        }
        startingPlayer.changeRemainingInfluence(-influenceLost);
    }

    private void setMinionTurnLeftsTrue(Player startingPlayer) {
        for (int i = 0; i < 8; i++) {
            if (startingPlayer.getTable().getMinions()[i] != null) {
                startingPlayer.getTable().getMinions()[i].setTurnLeft(true);
            }
        }
    }
}
