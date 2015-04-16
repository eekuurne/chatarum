package game.AI;

import cards.Card;
import cards.Minion;
import game.logic.LogicHandler;
import game.logic.Player;
import java.util.ArrayList;

/**
 * A very simple AI which does every move randomly.
 *
 * @author Eero Kuurne
 */
public class SimpleAI extends AI {

    public SimpleAI(Player playerA, Player playerB, LogicHandler handler) {
        super(playerA, playerB, handler);
    }

    /**
     * First the AI plays the turns of the minions in table. Then it plays the
     * hand. Then it plays the new mounted minions.
     */
    @Override
    public void playTurn() {
        playTableRandomly();
        playHandRandomly();
        playTableRandomly();
    }
}
