package cards;

import graphics.Entity;
import java.awt.image.BufferedImage;

/**
 * Class for the basic behaviour of all the minions. Every single minion extends
 * this class.
 *
 * @author Eero Kuurne
 */
public abstract class Minion extends Entity implements Card {

    private String name;
    private int damage;
    private int health;
    private int faction;
    private int cost;
    private boolean mounted; // Can the minion attack on the turn it is played
    private boolean ranged; // Can the minion attack without taking damage
    private boolean guardian; // Does the minion protect adjacent minions
    private int production; // Amount of resource production for workers
    private BufferedImage zoomedPic; // Zoomed picture of the card.

    public Minion(int damage, int health, int faction, String name, int cost, 
            boolean mounted, boolean ranged, boolean guardian, int production,
            BufferedImage zoomedPic) {
        super(-1, -1); // -1 means it's not on the screen yet (= it's in the deck)
        this.damage = damage;
        this.health = health;
        this.faction = faction;
        this.name = name;
        this.cost = cost;
        this.mounted = mounted;
        this.ranged = ranged;
        this.guardian = guardian;
        this.production = production;
        this.zoomedPic = zoomedPic;
    }

    public int getDamage() {
        return damage;
    }

    public int getFaction() {
        return faction;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public boolean getMounted() {
        return mounted;
    }

    public boolean getRanged() {
        return ranged;
    }
    
    public boolean getGuardian() {
        return guardian;
    }
    
    public int getProduction() {
        return production;
    }

    @Override
    public BufferedImage getZoomedPic() {
        return zoomedPic;
    }
    
    /**
     * Method for taking damage.
     *
     * @param amount The damage done to the minion.
     *
     * @return The health remaining.
     */
    public int takeDamage(int amount) {
        health -= amount;
        return health;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }
    
    /**
     * (Implemented soon)
     * 
     * Defines what happens when the minion is placed on the table. If the
     * method isn't overrided in the minion's own class, it will place the
     * minion on the slot chosen by player.
     */
    @Override
    public void playCard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
