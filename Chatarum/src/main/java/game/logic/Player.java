package game.logic;

import cards.containers.Table;
import cards.containers.Deck;
import cards.containers.Hand;
import game.AI.AI;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Contains the deck, hand and table of a player. Keeps track of the player's
 * influence and resources. Every game has 2 players.
 *
 * Player number 1 is at bottom, 2 is at top. Bottom player always starts.
 *
 * @author Eero Kuurne
 */
public class Player {

    private int playerNumber;

    private Deck deck;
    private Hand hand;
    private Table table;

    private int maxInfluence;
    private int remainingInfluence;
    private int maxResources; // Current max. resources.
    private int maxTurnResources; // Max. resources of the turn without workers.
    private int remainingResources; // Remaining resources of the turn.
    
    private AI AI;

    public Player(Deck deck, int number) {
        this.playerNumber = number;
        this.deck = deck;
        this.hand = new Hand();
        this.table = new Table();
        this.maxInfluence = 20;
        this.remainingInfluence = 20; // Starting influence defined here.
        this.maxResources = 0;
        this.maxTurnResources = 0;
        this.remainingResources = 0;
        this.AI = null;
    }

    /**
     * Changes the influence of the player based on parameter amount. Negative
     * values for losing influence.
     *
     * @param amount The amount of influence to change.
     *
     */
    public void changeRemainingInfluence(int amount) {
        remainingInfluence += amount;
        if (remainingInfluence >= maxInfluence) {
            remainingInfluence = maxInfluence;
        } else if (remainingInfluence <= 0) {
            remainingInfluence = 0;
        }
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
        } else if (maxResources <= 0) {
            maxResources = 0;
        }
    }

    /**
     * Changes the maximum possible resources without workers on this turn.
     *
     * @param amount The amount of resources to change.
     */
    public void changeMaxTurnResources(int amount) {
        maxTurnResources += amount;
        if (maxTurnResources >= 80) {
            maxTurnResources = 80;
        } else if (maxTurnResources <= 0) {
            maxTurnResources = 0;
        }
    }

    /**
     * Changes remaining resources.
     *
     * @param amount The amount of resources to change.
     */
    public void changeRemainingResources(int amount) {
        remainingResources += amount;
        if (remainingResources >= maxResources) {
            remainingResources = maxResources;
        } else if (remainingResources <= 0) {
            remainingResources = 0;
        }
    }

    /**
     * Paints the player's deck, hand and table.
     *
     *
     * @param g Graphics drawing tool.
     * @param player 1 for player at bottom, 2 for top.
     * @param turn Current turn.
     * @param betweenTurns State between endturn and startturn.
     */
    public void paintComponent(Graphics g, int player, int turn, boolean betweenTurns) {
        deck.paintComponent(g, player);
        hand.paintComponent(g, player, turn, betweenTurns);
        table.paintComponent(g);

        paintInfluence(g, player);
        paintResources(g, player);
    }

    /**
     * Paints the influence text and bar based on maximum and remaining
     * influence.
     *
     * @param g Graphics painting tool.
     * @param player The player whose influence is being painted.
     *
     */
    public void paintInfluence(Graphics g, int player) {
        int textY = Locations.player1InfluenceTextY;
        int barY = Locations.player1InfluenceBarY;
        if (player == 2) {
            textY = Locations.player2InfluenceTextY;
            barY = Locations.player2InfluenceBarY;
        }

        Font font = new Font("Serif", Font.BOLD, Assets.statTextFont); // Segoe Script?
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("INFLUENCE: " + remainingInfluence + "/" + maxInfluence, Locations.statX, textY);

        g.drawImage(Assets.statBar, Locations.statX, barY, null);
        g.setColor(Color.RED);

        double barWidth = ((double) remainingInfluence / maxInfluence)
                * (Assets.statBar.getWidth() - Assets.scale * 2.6);
        g.fillRect(Locations.statX + 1, barY + 1, (int) barWidth,
                (int) (Assets.statBar.getHeight() - Assets.scale * 2.6));
    }

    /**
     * Paints the resources text and bar based on maximum and remaining
     * resources.
     *
     * @param g Graphics painting tool.
     * @param player The player whose resources is being painted.
     *
     */
    public void paintResources(Graphics g, int player) {
        int textY = Locations.player1ResourceTextY;
        int barY = Locations.player1ResourceBarY;
        if (player == 2) {
            textY = Locations.player2ResourceTextY;
            barY = Locations.player2ResourceBarY;
        }

        Font font = new Font("Serif", Font.BOLD, Assets.statTextFont); // Segoe Script?
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("RESOURCES: " + remainingResources + "/" + maxResources, Locations.statX, textY);

        g.drawImage(Assets.statBar, Locations.statX, barY, null);
        g.setColor(Color.DARK_GRAY);
        double barWidth = ((double) remainingResources / (double) maxResources)
                * (Assets.statBar.getWidth() - Assets.scale * 2.6);
        g.fillRect(Locations.statX + 1, barY + 1, (int) barWidth,
                (int) (Assets.statBar.getHeight() - Assets.scale * 2.6));
    }

    public int getPlayerNumber() {
        return playerNumber;
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

    public int getRemainingInfluence() {
        return remainingInfluence;
    }

    public int getMaxResources() {
        return maxResources;
    }

    public int getRemainingResources() {
        return remainingResources;
    }

    public int getMaxTurnResources() {
        return maxTurnResources;
    }

    public int getMaxInfluence() {
        return maxInfluence;
    }

    public void setRemainingResources(int remainingResources) {
        this.remainingResources = remainingResources;
    }

    public void setMaxResources(int maxResources) {
        this.maxResources = maxResources;
    }

    public void setAI(AI AI) {
        this.AI = AI;
    }

    public AI getAI() {
        return AI;
    }
    
    
}
