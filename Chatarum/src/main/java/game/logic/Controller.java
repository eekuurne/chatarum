package game.logic;

import cards.Card;
import cards.containers.Deck;
import graphics.Assets;

/**
 * Temporary class to handle the gameplay. This could all probably be moved to
 * game state or game state could move things here... We'll see when mouse
 * controller is implemented.
 *
 * @author Eero Kuurne
 */
public class Controller {

    private boolean singleplayer;
    private Player player1;
    private Player player2;
    private DeckBuilder deckBuilder;

    public Controller(boolean singleplayer) {
        this.singleplayer = singleplayer;
        this.deckBuilder = new DeckBuilder();

        init();
    }

    /**
     * Creates players at the start of the match.
     *
     */
    public void init() {
        Deck deck1 = deckBuilder.getDeck1();
        Deck deck2 = deckBuilder.getDeck2();

        this.player1 = new Player(deck1);
        this.player2 = new Player(deck2);

        for (int i = 1; i < 6; i++) {
            player1.getHand().addCard(player1.getDeck().takeCard());
            player2.getHand().addCard(player2.getDeck().takeCard());
        }

        player1.getHand().cardPositions(1);
        player2.getHand().cardPositions(2);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
