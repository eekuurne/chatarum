package game.logic;

import cards.containers.Table;
import cards.containers.Deck;
import cards.containers.Hand;
import java.awt.Graphics;

/**
 * Contains the deck, hand and table of a player. Every game has 2 
 * players.
 * 
 * Player number 1 is at bottom, 2 is at top. Bottom player always starts.
 * 
 * @author Eero Kuurne
 */
public class Player {

    private Deck deck;
    private Hand hand;
    private Table table;
    
    private int health;

    public Player(Deck deck) {
        this.deck = deck;
        this.hand = new Hand();
        this.table = new Table();
        this.health = 30;
    }

    public Deck getDeck() {
        return deck;
    }

    public Hand getHand() {
        return hand;
    }

    public Table getTable() {
        return table;
    }
    
    public int getHealth() {
        return health;
    }

    /**
     * Changes the health of the player based on parameter amount. Negative
     * values for taking damage.
     *
     * @param amount The amount of health to change.
     *
     * @return Did the player's health go under zero.
     */
    public boolean changeHealth(int amount) {
        health += amount;
        if (health <= 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Paints the player's deck, hand and table.
     *
     * 
     * @param g Graphics drawing tool.
     * @param player 1 for player at bottom, 2 for top.
     * @param turn Current turn.
     */
    public void paintComponent(Graphics g, int player, int turn) {
        deck.paintComponent(g, player);
        hand.paintComponent(g, player, turn);
        table.paintComponent(g);
    }
    
    public void paintHealth(Graphics g, int player, int turn) {
        
    }
}