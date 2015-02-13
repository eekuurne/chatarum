
package cards.containers;

import cards.Minion;

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
    private int[] slots;

    public Table() {
        this.minions = new Minion[8];
        this.slots = new int[8];
    }
    
    public boolean insertMinion(Minion minion, int slot) {
        if (slots[slot] != 0) { // If slot is not empty
            return false;
        }
        minions[slot] = minion;
        slots[slot] = 1;
        return true;
    }
    
    public Minion chooseMinion(int slot) {
        if (slots[slot] == 0) {
            return null;
        }
        Minion minion = minions[slot];
        return minion;
    }
    
    public void removeMinion(int slot) {
        minions[slot] = null;
        slots[slot] = 0;
    }
    
    /*
    public void minionAttack(Minion attacker, int attackerSlot, 
            Minion defender, int defenderSlot, Table enemyTable) {
        
        defender.takeDamage(attacker.getDamage());
        attacker.takeDamage(defender.getDamage());
        
        if (defender.getHealth() <= 0) {
            enemyTable.removeMinion(defenderSlot);
        }
        if (attacker.getHealth() <= 0) {
            removeMinion(attackerSlot);
        }
    }*/
}
