package cards.containers;

import cards.Minion;
import graphics.Assets;
import graphics.Locations;
import java.awt.Graphics;

/**
 * (The class will be changed a bit, that's why no comments for methods.)
 *
 * Contains the minions a player has placed on table. Can be targeted by the
 * enemy player on his turn.
 *
 * @author Eero Kuurne
 */
public class Table {

    private Minion[] minions;

    public Table() {
        this.minions = new Minion[8];
    }

    public boolean insertMinion(Minion minion, int slot) {
        if (minions[slot] != null) { // If slot is not empty
            return false;
        }
        minions[slot] = minion;
        return true;
    }

    public Minion chooseMinion(int slot) {
        if (minions[slot] == null) {
            return null;
        }
        Minion minion = minions[slot];
        return minion;
    }

    public void removeMinion(int slot) {
        minions[slot] = null;
    }

    public void render(Graphics g) {
        for (int i = 0; i < 8; i++) {
            if (minions[i] != null) { // If slot is not empty
                minions[i].render(g);
            }
        }
    }
    
    public void cardPositions(int player) {
        int y = Locations.player1TableY;
        if (player == 2) {
            y = Locations.player2TableY;
        }
        
        for (int i = 0; i < minions.length; i++) {
            if (minions[i] != null) {
                minions[i].setX(285 + 9 + i * 150);
                minions[i].setY(y);
            }
        }
    }
}
