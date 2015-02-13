
package cards.containers;

import cards.Card;
import java.util.ArrayList;

/**
 * Class for the player's hand. Gets cards from Deck, which can then be
 * played.
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
}