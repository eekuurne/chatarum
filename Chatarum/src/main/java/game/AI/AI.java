package game.AI;

import game.logic.LogicHandler;
import game.logic.Player;
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

}
