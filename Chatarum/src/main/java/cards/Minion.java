package cards;

import cards.containers.Table;
import game.logic.LogicHandler;
import game.logic.Player;
import game.ui.Locations;

/**
 *
 * @author Eero Kuurne
 */
public abstract class Minion extends Card {

    private int damage;
    private int maxHealth;
    private int health;
    private boolean turnLeft; // Can the minion attack on this turn.
    private boolean ranged; // Can the minion attack without taking damage.
    private boolean guardian; // Does the minion protect adjacent minions.
    private int production; // Amount of resource production for workers.
    private boolean deadly; // Does the minion always kill its target.

    public Minion(String name, int cost, int damage, int health,
            boolean turnLeft, boolean ranged, boolean guardian, int production) {
        super(name, cost);
        this.damage = damage;
        this.maxHealth = health;
        this.health = health;
        this.turnLeft = turnLeft;
        this.ranged = ranged;
        this.guardian = guardian;
        this.production = production;
        this.deadly = false;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
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

    public void setDeadly(boolean deadly) {
        this.deadly = deadly;
    }

    public boolean getDeadly() {
        return deadly;
    }

    /**
     * Changes the minion's health when attacked or healed. Negative amount when
     * taking damage, positive for heal.
     *
     * @param amount The amount of health changed.
     */
    public void changeHealth(int amount) {
        this.health += amount;
    }

    @Override
    public void clickInHand(LogicHandler handler, int slot) {
        handler.clearChosen();
        handler.setChosenHandMinion(this);
        handler.setChosenHandMinionSlot(slot);
        if (handler.getTurn() % 2 != 0) {
            setLocation(getX(), Locations.player1HandY - Locations.chooseCardDelta);
        } else {
            setLocation(getX(), Locations.player2HandY + Locations.chooseCardDelta);
        }
    }

    /**
     * What happens when a minion is clicked in a table. Changes the location of the
     * minion and sets it chosen in the handler. This could be moved over to 
     * LogicHandler too.
     *
     * @param handler LogicHandler.
     * @param slot The minion's slot in table.
     */
    public void clickInTable(LogicHandler handler, int slot) {
        handler.clearChosen();
        if (this.turnLeft) {
            handler.setChosenTableCard(this);
            handler.setChosenTableSlot(slot);
            if (handler.getTurn() % 2 != 0) {
                setLocation(getX(), Locations.player1TableY - Locations.chooseCardDelta);
            } else {
                setLocation(getX(), Locations.player2TableY + Locations.chooseCardDelta);
            }
        }
    }
    
    /**
     * What happens when a minion enters the table. This method can be Overrided
     * to add special table entering effects to minion.
     * 
     * @param ownPlayer Player whose turn it is.
     * @param enemyPlayer The other player.
     * @param slot Slot where the minion is put in table.
     */
    public void enterTable(Player ownPlayer, Player enemyPlayer, int slot) {
        //System.out.println(getName() + " played to table!");
    }
    
    /**
     * What happens when a minion dies. This method can be Overrided
     * to add special dying effects to minion.
     *
     */
    public void die() {
        //System.out.println(getName() + " has died!");
    }
}
