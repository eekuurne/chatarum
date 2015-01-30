
package game.logic;

import cards.Card;
import java.util.ArrayList;

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
    
    public boolean addCard(Card card) {
        // If the hand is full, don't add, return false.
        if (cards.size() >= maxSize) {
            return false;
        }
        cards.add(card);
        return true;
    }
    
    public Card takeCard(int slot) {
        if (cards.isEmpty()) {
            return null;
        }
        Card card = cards.get(slot);
        cards.remove(slot);
        return card;
    }
}