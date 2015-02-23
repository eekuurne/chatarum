package game.logic;

import cards.containers.Table;
import cards.containers.Deck;
import cards.containers.Hand;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Contains the deck, hand and table of a player. Every game has 2 players.
 *
 * Player number 1 is at bottom, 2 is at top. Bottom player always starts.
 *
 * @author Eero Kuurne
 */
public class Player {

    private Deck deck;
    private Hand hand;
    private Table table;

    private int influence;
    private int maxResources; // Max. resources of the turn.
    private int remainingResources; // Remaining resources of the turn.

    public Player(Deck deck) {
        this.deck = deck;
        this.hand = new Hand();
        this.table = new Table();
        this.influence = 30; // Starting influence defined here.
        this.maxResources = 0;
        this.remainingResources = 0;
    }

    /**
     * Changes the influence of the player based on parameter amount. Negative
     * values for losing influence.
     *
     * @param amount The amount of influence to change.
     *
     * @return Did the player's influence go under zero.
     */
    public boolean changeInfluence(int amount) {
        influence += amount;
        if (influence <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Changes the resources of the player based on parameter amount. Max.
     * resources is defined here.
     *
     * @param amount The amount of resources to change.
     */
    public void changeMaxResources(int amount) {
        maxResources += amount;
        if (maxResources >= 100) {
            maxResources = 100;
        }
    }

    public void changeRemainingResources(int amount) {
        remainingResources += amount;
        if (remainingResources >= maxResources) {
            remainingResources = maxResources;
        } else if (remainingResources <= 0) {
            remainingResources = 0;
        }
    }
    
    public void setRemainingResources(int remainingResources) {
        this.remainingResources = remainingResources;
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

        paintInfluence(g, player);
        paintResources(g, player);
    }

    public void paintInfluence(Graphics g, int player) {
        int textY = Locations.player1InfluenceTextY;
        int barY = Locations.player1InfluenceBarY;
        if (player == 2) {
            textY = Locations.player2InfluenceTextY;
            barY = Locations.player2InfluenceBarY;
        }
        
        Font font = new Font("Serif", Font.BOLD, 20); // Segoe Script?
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("INFLUENCE: " + influence + "/30", Locations.statX, textY);
        
        g.drawImage(Assets.statBar, Locations.statX, barY, null);
        g.setColor(Color.RED);
        fillBar(g, Locations.statX + 1, barY + 1);
    }

    public void paintResources(Graphics g, int player) {
        int textY = Locations.player1ResourceTextY;
        int barY = Locations.player1ResourceBarY;
        if (player == 2) {
            textY = Locations.player2ResourceTextY;
            barY = Locations.player2ResourceBarY;
        }
        
        Font font = new Font("Serif", Font.BOLD, 20); // Segoe Script?
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("RESOURCES: " + remainingResources + "/" + maxResources, Locations.statX, textY);
        
        g.drawImage(Assets.statBar, Locations.statX, barY, null);
        g.setColor(Color.DARK_GRAY);
        fillBar(g, Locations.statX + 1, barY + 1);
    }
    
    public void fillBar(Graphics g, int x, int y) {
        int barWidth = (remainingResources / maxResources) * 197;
        g.fillRect(x, y, barWidth, 17);
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

    public int getInfluence() {
        return influence;
    }

    public int getMaxResources() {
        return maxResources;
    }

    public int getRemainingResources() {
        return remainingResources;
    }
}
