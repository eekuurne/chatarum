package cards.containers;

import cards.Card;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Class for the player's hand. Gets cards from Deck, which can then be played.
 * Renders the cards to the screen face up on player's turn, face down
 * otherwise.
 *
 * @author Eero Kuurne
 */
public class Hand {

    private ArrayList<Card> cards;
    private final int maxSize;

    public Hand() {
        this.cards = new ArrayList<Card>();
        this.maxSize = 10;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getRemaining() {
        return cards.size();
    }

    /**
     * Adds a card to the hand.
     *
     * @param card The card added to the hand.
     *
     * @return Was the hand full.
     */
    public boolean addCard(Card card) {
        // If the hand is full, don't add, return false.
        if (cards.size() >= maxSize) {
            return false;
        }
        cards.add(card);
        return true;
    }

    /**
     * Takes a card from the hand.
     *
     * @param slot The slot of the card.
     *
     * @return The card or null if the slot is empty.
     */
    public Card takeCard(int slot) {
        if (cards.isEmpty()) {
            return null;
        }
        Card card = cards.remove(slot);
        return card;
    }

    /**
     * Paints the cards in the hand.
     *
     * @param g Graphics g for rendering.
     * @param player 1 for player at bottom, 2 for top.
     * @param turn Current turn.
     *
     */
    public void paintComponent(Graphics g, int player, int turn, boolean betweenTurns) {
        int y;
        if (player == 1) {
            y = Locations.player1HandY;
        } else {
            y = Locations.player2HandY;
        }

        if (((player == 1 && turn % 2 == 1) || (player == 2 && turn % 2 == 0))
                && !betweenTurns) {
            for (int i = 0; i < cards.size(); i++) {
                cards.get(i).paintComponent(g);
            }
        } else {
            for (int i = 0; i < cards.size(); i++) {
                g.drawImage(Assets.neutralCardBack, Locations.handX[i], y, null);
            }
        }
    }

    /**
     * Updates the card positions in hand. Will be called whenever anything
     * changes on the hand.
     *
     * @param player 1 for player at bottom, 2 for top.
     */
    public void cardPositions(int player) {
        int y = Locations.player1HandY;
        if (player == 2) {
            y = Locations.player2HandY;
        }

        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).setLocation(Locations.handX[i], y);
        }
    }
}
