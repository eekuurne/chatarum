package game.AI;

import game.logic.LogicHandler;
import game.logic.Player;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Eero Kuurne
 */
public abstract class AI {

    protected Player playerA;
    protected Player playerB;
    protected LogicHandler handler;
    
    protected Random rand;

    public AI(Player playerA, Player playerB, LogicHandler handler) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.handler = handler;
        this.rand = new Random();
    }
    
    public abstract void playTurn();

    protected ArrayList<Integer> checkFilledTableSlots(Player player) {
        ArrayList<Integer> tableSlots = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (player.getTable().getMinions()[i] != null) {
                tableSlots.add(i);
            }
        }
        return tableSlots;
    }
    
    protected ArrayList<Integer> checkEmptyTableSlots(Player player) {
        ArrayList<Integer> tableSlots = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (player.getTable().getMinions()[i] == null) {
                tableSlots.add(i);
            }
        }
        return tableSlots;
    }
}
