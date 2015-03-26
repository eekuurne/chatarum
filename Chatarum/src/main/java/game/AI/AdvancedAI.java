package game.AI;

import game.logic.LogicHandler;
import game.logic.Player;

/**
 *
 * @author Eero Kuurne
 */
public class AdvancedAI extends AI {

    public AdvancedAI(Player playerA, Player playerB, LogicHandler handler) {
        super(playerA, playerB, handler);
    }

    @Override
    public void playTurn() {
        
        // Has different states depending on the state of the game, for example offensive, defensive, resource gathering etc.
        
    }

}
