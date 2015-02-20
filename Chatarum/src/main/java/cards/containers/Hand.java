package cards.containers;

import cards.Card;
import graphics.Assets;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Class for the player's hand. Gets cards from Deck, which can then be played.
 * Renders the cards to the screen face up on player's turn, face down otherwise.
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
     * Method for adding card to hand.
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
     * Method for taking card from hand.
     *
     * @param slot Which card will be taken from the hand.
     *
     * @return The card taken.
     */
    public Card takeCard(int slot) {
        if (cards.isEmpty()) {
            return null;
        }
        Card card = cards.get(slot);
        cards.remove(slot);
        return card;
    }

    /**
     * Render the cards in the hand.
     *
     * (REFACTOR!)
     * 
     * @param g Graphics g for rendering.
     * @param player 1 for player at bottom, 2 for top.
     * @param faction 1 for brotherhood, 2 for cult ...
     * @param turn Current turn.
     *
     */
    public void render(Graphics g, int player, int faction, int turn) {
        int y;
        if (player == 1) {
            y = 1080 - 40 - Assets.smallHeight;
        } else {
            y = 40;
        }
        
        if ((player == 1 && turn % 2 == 1) || (player == 2 && turn % 2 == 0)) {
            for (int i = 0; i < cards.size(); i++) {
                cards.get(i).render(g);
            }
        } else if (faction == 1) {
            for (int i = 0; i < cards.size(); i++) {
                g.drawImage(Assets.brotherhoodBack, 1920 - 583 - i * 128, y, null);
            }
        } else if (faction == 2) {
            for (int i = 0; i < cards.size(); i++) {
                g.drawImage(Assets.cultBack, 1920 - 583 - i * 128, y, null);
            }
        }

    }

    /**
     * Updates the card positions in hand. Will be called whenever anything
     * changes on the screen.
     * 
     * @param player 1 for player at bottom, 2 for top.
     */
    public void cardPositions(int player) {
        if (player == 1) {
            for (int i = 0; i < cards.size(); i++) {
                cards.get(i).setX(1920 - 583 - i * 128);
                cards.get(i).setY(1080 - 40 - Assets.smallHeight);
            }
        } else if (player == 2) {
            for (int i = 0; i < cards.size(); i++) {
                cards.get(i).setX(1920 - 583 - i * 128);
                cards.get(i).setY(40);
            }
        }

    }
}
