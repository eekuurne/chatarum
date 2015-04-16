package cards.containers;

import cards.Minion;
import game.ui.Locations;
import java.awt.Graphics;

/**
 * Contains the minions a player has placed on the table. Can be targeted by the
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

    public void removeMinion(int slot) {
        minions[slot] = null;
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < 8; i++) {
            if (minions[i] != null) { // If slot is not empty
                minions[i].paintComponent(g);
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
                minions[i].setLocation(Locations.tableX[i], y);
            }
        }
    }
    
    public boolean isEmpty() {
        for (int i = 0; i < 8; i++) {
            if (minions[i] != null) {
                return false;
            }
        }
        return true;
    }

    public Minion[] getMinions() {
        return minions;
    }
}
