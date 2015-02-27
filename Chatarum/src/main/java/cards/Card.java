package cards;

import game.logic.LogicHandler;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseListener;

/**
 * Absract class for all cards. Cards can be contained in decks and hands, and
 * they can be played from hand. The cards will be divided to minions and
 * skills.
 *
 * @author Eero Kuurne
 */
public abstract class Card {

    private String name;
    private int cost;
    private int x, y;

    public Card(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.x = 0;
        this.y = 0;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void paintComponent(Graphics g);

    /**
     * What happens when a card is clicked in hand. Minions go to their own
     * chosen-variable, others will have their own when implemented.
     *
     * @param handler LogicHandler.
     * @param slot Slot in hand.
     */
    public abstract void clickInHand(LogicHandler handler, int slot);

}
