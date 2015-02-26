package cards.containers;

import cards.Card;
import cards.minions.Militia;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 * Deck is the container for player's cards before they are drawn to his hand.
 * The variable "maxSize" defines the maximum amount of cards in a deck and the
 * variable "maxSingle" defines the maximum amount of single card in a deck.
 * 
 * The deck object contains methods for adding card, drawing card and rendering
 * the deck to the screen based on remaining cards.
 * 
 * @author Eero Kuurne
 */

public class Deck {

    private ArrayList<Card> cards;
    private final int maxSize;
    private final int maxSingle;

    public Deck() {
        this.cards = new ArrayList<Card>();
        this.maxSize = 30;
        this.maxSingle = 6;
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

    public int getRemaining() {
        return cards.size();
    }

    /**
     * Method for adding a card to the deck.
     *
     * @param card1 The card added to the deck.
     *
     * @return Was the deck full or was there too many of the same card.
     */
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

    /**
     * Method for taking a card from the deck.
     * 
     * @return A random card from the deck.
     */
    public Card takeCard() {
        // If the deck is empty, take militia card.
        if (cards.isEmpty()) {
            return new Militia();
        }
        // Else pick random card from the deck.
        Random rand = new Random();
        int slot = rand.nextInt(cards.size());

        Card card = cards.get(slot);
        cards.remove(slot);

        return card;
    }
    
    /**
     * Method for rendering the remaining deck at the left side of table.
     * 
     * (Will be changed to render based on remaining cards)
     * 
     * @param g Graphics tool
     * @param player 1 for player at bottom, 2 for top.
     */
    public void paintComponent(Graphics g, int player) {
        int x = Locations.deckX; 
        int y;
        if (player == 1) {
            y = Locations.player1DeckY;
        } else {
            y = Locations.player2DeckY;
        }
        
        int d = Locations.deckCardDelta;

        // Draws cardbacks on top of each based on cards remaining.
        if (cards.size() >= 1) {
            g.drawImage(Assets.neutralCardBack, x, y, null);
        }
        if (cards.size() >= 2) {
            g.drawImage(Assets.neutralCardBack, x + d, y - d, null);
        }
        if (cards.size() >= 5) {
            g.drawImage(Assets.neutralCardBack, x + 2 * d, y - 2 * d, null);
        }
        if (cards.size() >= 10) {
            g.drawImage(Assets.neutralCardBack, x + 3 * d, y - 3 * d, null);
        }
        if (cards.size() >= 20) {
            g.drawImage(Assets.neutralCardBack, x + 4 * d, y - 4 * d, null);
        }
    }
}