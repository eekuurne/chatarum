package cards;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseListener;

/**
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
}
