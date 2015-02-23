package game.logic;

import cards.Card;
import cards.containers.Deck;
import cards.minions.Archer;
import cards.minions.Swordman;
import game.ui.Locations;

/**
 *
 * @author Eero Kuurne
 */
public class LogicHandler {

    private int turn;
    
    private Card chosenCard;
    
    private Player player1;
    private Player player2;

    public LogicHandler() {
        this.turn = 1;
        this.chosenCard = null;

        init();
    }
    
    public void init() {
        DeckBuilder deckBuilder = new DeckBuilder();
        
        Deck deck1 = deckBuilder.getDeck1();
        Deck deck2 = deckBuilder.getDeck2();

        this.player1 = new Player(deck1);
        this.player2 = new Player(deck2);

        
        for (int i = 1; i < 6; i++) {
            player1.getHand().addCard(player1.getDeck().takeCard());
            player2.getHand().addCard(player2.getDeck().takeCard());
        }
        player2.getHand().addCard(player2.getDeck().takeCard());

        player1.getHand().cardPositions(1);
        player2.getHand().cardPositions(2);
    }

    /**
     * What happens when the player clicks "End turn" button.
     * 
     */
    public void changeTurn() {
        turn++;
        
        for (int i = 0; i < 8; i++) {
            
        }
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

    public Card getChosenCard() {
        return chosenCard;
    }

    public void setChosenCard(Card chosenCard) {
        this.chosenCard = chosenCard;
    }

    public void clearChosen() {
        if (chosenCard != null) {
            Card chosen = chosenCard;
            if (turn % 2 != 0) {
                chosen.setLocation(chosen.getX(), Locations.player1HandY);
            } else {
                chosen.setLocation(chosen.getX(), Locations.player2HandY);
            }
            chosenCard = null;
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
}
