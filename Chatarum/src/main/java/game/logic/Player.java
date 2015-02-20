package game.logic;

import cards.containers.Table;
import cards.containers.Deck;
import cards.containers.Hand;
import graphics.Assets;
import java.awt.Graphics;

/**
 * Contains the deck, hand, table and champion of a player. Every game has 2 
 * players, who can either be controlled by a player or AI.
 * 
 * Player number 1 is at bottom, 2 is at top. Bottom player always starts.
 * 
 * @author Eero Kuurne
 */
public class Player {

    private Deck deck;
    private Hand hand;
    private Table table;
    private Champion champion;
    
    private int health;

    public Player(Deck deck) {
        this.deck = deck;
        this.hand = new Hand();
        this.table = new Table();
        this.champion = deck.getChampion();
        this.health = 30;
    }

    public Deck getDeck() {
        return deck;
    }

    public Hand getHand() {
        return hand;
    }

    public int getHealth() {
        return health;
    }

    public Table getTable() {
        return table;
    }
    
    /**
     * Gets the player's faction from player's deck.

     * @return Player's faction.
     */
    public int getFaction() {
        return deck.getFaction();
    }

    /**
     * Method for taking damage.
     *
     * @param amount The damage done to the player's hero.
     *
     * @return Did the player's health go under zero.
     */
    public boolean takeDamage(int amount) {
        health -= amount;
        if (health <= 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Renders the player's deck, hand, table and champion.
     *
     * 
     * @param g Graphics tool.
     * @param player 1 for player at bottom, 2 for top.
     * @param turn Current turn.
     */
    public void render(Graphics g, int player, int turn) {
        deck.render(g, player);
        hand.render(g, player, getFaction(), turn);
        // table.render();
        champion.render(g, player, getFaction());
    }
}
