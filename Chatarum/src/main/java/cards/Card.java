package cards;

import game.assets.Assets;
import game.logic.LogicHandler;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

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

    /**
     * Draws a placeholder card if no picture has been assigned to a card.
     *
     * @param g Graphics
     */
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.cardBackGroundSmall, x, y, null);

        Font font = new Font("Serif", Font.BOLD, Assets.statTextFont);
        g.setFont(font);
        g.drawString("  " + getName(), getX() + 5, getY() + 2 * Assets.smallHeight / 3);

        font = new Font("Serif", Font.BOLD, (int) (Assets.statTextFont / 1.5));
        g.setFont(font);
        g.drawString("<Placeholder>", getX() + 5, getY() + 4 * Assets.smallHeight / 5);

        font = new Font("Serif", Font.BOLD, (int) (Assets.statTextFont / 1.2));
        g.setFont(font);
        g.drawString("" + getCost(), getX() + Assets.smallWidth / 2, getY() + Assets.smallHeight - 5);

        g.drawString("   <Placeholder>", getX() + 5, getY() + Assets.smallHeight / 3);
    }

    /**
     * Draws the card bigger when mouse is hovering over it.
     *
     * @param g Graphics
     */
    public abstract void paintHover(Graphics g);

    /**
     * What happens when a card is clicked in hand. Minions go to their own
     * chosen-variable, others will have their own when implemented.
     *
     * @param handler LogicHandler.
     * @param slot Slot in hand.
     */
    public abstract void clickInHand(LogicHandler handler, int slot);

}
