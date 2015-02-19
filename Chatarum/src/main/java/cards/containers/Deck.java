package cards.containers;

import cards.Card;
import cards.minions.Militia;
import cards.Minion;
import game.logic.Champion;
import graphics.Assets;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 * Deck constists of 0-30 cards and a Champion. Player composes his deck in the 
 * menu before the game starts and the Deck object will then be transfered into 
 * the game. The Deck object's role in the game is to be a container of cards 
 * where the player picks 1 from per turn to his hand.
 * 
 * @author Eero Kuurne
 */

public class Deck {

    private ArrayList<Card> cards;
    private final int maxSize;
    private final int maxSingle;
    private Champion champion;
    private int faction;

    public Deck(int faction) {
        this.cards = new ArrayList<Card>();
        this.maxSize = 20;
        this.maxSingle = 5;
        this.faction = faction;
        this.champion = new Champion();
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

    public int getFaction() {
        return faction;
    }

    public Champion getChampion() {
        return champion;
    }

    /**
     * Method for adding card to deck.
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
     * Method for taking card from deck.

     * @return Random card from deck.
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
    
    public void render(Graphics g, int player) {
        int x = 75; 
        int y;
        if (player == 1) {
            y = 565;
        } else {
            y = 317;
        }

        if (faction == 1) { // Faction brotherhood
            g.drawImage(Assets.brotherhoodBack, x, y, null);
            g.drawImage(Assets.brotherhoodBack, x + 3, y - 3, null);
            g.drawImage(Assets.brotherhoodBack, x + 6, y - 6, null);
        } else if (faction == 2) { // Faction cult
            g.drawImage(Assets.cultBack, x, y, null);
            g.drawImage(Assets.cultBack, x + 3, y - 3, null);
            g.drawImage(Assets.cultBack, x + 6, y - 6, null);
        }
        
        
        // If cards.size > 20 
        
        // else if cards.size > 10 show 5 cards
        
        // else if cards.size > 3 show 3 cards
        
        // else if cards.size == 2, show 2 cards
        
        // else if cards.size == 1, show 1 card

        
    }
}