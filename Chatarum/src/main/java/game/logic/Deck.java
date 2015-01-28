package game.logic;

import cards.Card;
import java.util.ArrayList;
import java.util.Random;

/* 
 Deck constists of 0-30 cards. Player composes his deck in the menu before the 
 game starts and the Deck object will then be transfered into the game. The
 Deck object's role in the game is to give its player 1 card per turn until
 it's empty.
 */

public class Deck {

    private ArrayList<Card> cards;
    private final int maxSize;
    private final int maxSingle;

    public Deck() {
        this.cards = new ArrayList<Card>();
        this.maxSize = 30;
        this.maxSingle = 5;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getMaxSingle() {
        return maxSingle;
    }

    public boolean addCard(Card card1) {
        // If the deck is full, don't add, return false.
        if (cards.size() >= maxSize) {
            return false;
        }
        // If there are too many of the same card, don't add, return false.
        int sameCards = 0;
        for (Card card2 : cards) { // 
            if (card1.getName().equals(card2.getName())) {
                sameCards++;
            }
            if (sameCards >= maxSingle) {
                return false;
            }
        }
        cards.add(card1);
        return true;
    }

    public Card takeCard() {
        Random rand = new Random();
        int slot = rand.nextInt(cards.size());

        Card card = cards.get(slot);
        cards.remove(slot);

        return card;
    }

}
