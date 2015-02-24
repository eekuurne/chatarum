package cards;

import game.logic.LogicHandler;
import game.ui.Locations;

/**
 *
 * @author Eero Kuurne
 */
public abstract class Minion extends Card {

    private int damage;
    private int health;
    private boolean turnLeft; // Can the minion attack on this turn.
    private boolean ranged; // Can the minion attack without taking damage.
    private boolean guardian; // Does the minion protect adjacent minions.
    private int production; // Amount of resource production for workers

    public Minion(String name, int cost, int damage, int health, 
            boolean turnLeft, boolean ranged, boolean guardian, int production) {
        super(name, cost);
        this.damage = damage;
        this.health = health;
        this.turnLeft = turnLeft;
        this.ranged = ranged;
        this.guardian = guardian;
        this.production = production;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public boolean getTurnleft() {
        return turnLeft;
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

    public void setTurnLeft(boolean turnLeft) {
        this.turnLeft = turnLeft;
    }

    
    /**
     * Changes the minion's health when attacked or healed. Negative amount
     * when taking damage, positive for heal.
     *
     * @param amount The amount of health changed.
     */
    public void changeHealth(int amount) {
        this.health += amount;
    }

    @Override
    public void clickInHand(LogicHandler handler, int slot) {
        handler.clearChosen();
        handler.setChosenCard(this);
        handler.setChosenHandSlot(slot);
        if (handler.getTurn() % 2 != 0) {
            setLocation(getX(), Locations.player1HandY - 25);
        } else {
            setLocation(getX(), Locations.player2HandY + 25);
        }
    }
    
}
