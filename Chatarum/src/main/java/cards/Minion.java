package cards;

import cards.containers.Table;
import game.assets.Assets;
import game.logic.LogicHandler;
import game.logic.Player;
import game.ui.Locations;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Minion cards can be played from hand to table. They have all have damage
 * and health values and they fight against each other in the table. They
 * can also have special abilities, which are explained below.
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
    private BufferedImage smallPic; // Picture in table and hand
    private BufferedImage bigPic; // Zoomed picture while mouse hovering

    public Minion(String name, int cost, int damage, int health) {
        super(name, cost);
        this.damage = damage;
        this.maxHealth = health;
        this.health = health;
        this.turnLeft = false;
        this.ranged = false;
        this.guardian = false;
        this.production = 0;
        this.deadly = false;
        this.smallPic = Assets.cardBackGroundSmall;
        this.bigPic = Assets.cardBackGroundBig;
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

    /**
     * Chooses a minion from hand.
     *
     * @param handler The logic handler.
     * @param slot The slot that is chosen.
     */
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
     * What happens when a minion is clicked in a table. Changes the location of
     * the minion and sets it chosen in the handler. This could be moved over to
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
     * What happens when a minion dies. This method can be Overrided to add
     * special dying effects to minion.
     *
     */
    public void die() {
        //System.out.println(getName() + " has died!");
    }

    /**
     * Draws a placeholder card if no picture has been assigned to a card.
     *
     * @param g Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(smallPic, super.getX(), super.getY(), null);
    }

    /**
     * Draws a placeholder if no card picture has been assigned.
     *
     * @param g Graphics
     */
    @Override
    public void paintHover(Graphics g) {
        if (super.getY() <= Locations.tableSlotsY) {
            g.drawImage(bigPic, super.getX() - (Assets.bigWidth - Assets.smallWidth)
                    / 2, super.getY(), null);
        } else {
            g.drawImage(bigPic, super.getX() - (Assets.bigWidth - Assets.smallWidth)
                    / 2, super.getY() - (Assets.bigHeight - Assets.smallHeight), null);
        }
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

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setGuardian(boolean guardian) {
        this.guardian = guardian;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public void setRanged(boolean ranged) {
        this.ranged = ranged;
    }

    public BufferedImage getBigPic() {
        return bigPic;
    }

    public BufferedImage getSmallPic() {
        return smallPic;
    }

    public void setBigPic(BufferedImage bigPic) {
        this.bigPic = bigPic;
    }

    public void setSmallPic(BufferedImage smallPic) {
        this.smallPic = smallPic;
    }
}


/*
    placeholder card code:
        // Draw name:
        Font font = new Font("Serif", Font.BOLD, (int) (Assets.statTextFont / 1.1));
        g.setFont(font);
        g.drawString("  " + getName(), getX(), getY() + 2 * Assets.smallHeight / 3);
        
        // Draw damage:
        font = new Font("Serif", Font.BOLD, (int) (Assets.statTextFont * 1.5));
        g.setFont(font);
        g.drawString(" " + getDamage(), getX(), getY() + Assets.smallHeight - 5);
        
        // Draw health:
        g.drawString("" + getHealth(), getX() + 4 * Assets.smallWidth / 5, getY() + Assets.smallHeight - 5);
        
        // Draw cost:
        font = new Font("Serif", Font.BOLD, (int) (Assets.statTextFont * 1.2));
        g.setFont(font);
        g.drawString("" + getCost(), getX() + Assets.smallWidth / 2 - 5, getY() + Assets.smallHeight - 5);
*/