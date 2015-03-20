package game.AI;

import cards.Card;
import cards.Minion;
import game.logic.LogicHandler;
import game.logic.Player;
import java.util.ArrayList;

/**
 *
 * @author Eero Kuurne
 */
public class SimpleAI extends AI {

    public SimpleAI(Player playerA, Player playerB, LogicHandler handler) {
        super(playerA, playerB, handler);
    }

    @Override
    public void playTurn() {
        playTable();
        playHand();
        playTable();
    }

    /**
     *
     *
     */
    private void playTable() {
        for (int i = 0; i < 8; i++) {
            if (playerA.getTable().getMinions()[i] != null
                    && playerA.getTable().getMinions()[i].getTurnleft()) {
                ArrayList<Minion> enemyTable = checkEnemyTable();
                int attackSlot = rand.nextInt(enemyTable.size());
                handler.minionAttack(attackSlot, i, playerA, playerB);
            }
        }
    }

    private void playHand() {
        Card[] hand = new Card[playerA.getHand().getRemaining()];
        
        for (int i = 0; i < playerA.getHand().getRemaining(); i++) {
            hand[i] = playerA.getHand().getCards().get(i);
        }
        
        for (int i = 0; i < hand.length; i++) {
            if (playerA.getRemainingResources() >= hand[i].getCost()) {
                handler.clickHandSlot(i, playerA);
                
                // Randomize the slot where to put the minion.
                
                //handler.placeChosenMinionToTable(i, playerA, playerB);
            }
        }
    }

    private ArrayList<Minion> checkEnemyTable() {
        ArrayList<Minion> enemyTable = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (playerB.getTable().getMinions()[i] != null) {
                enemyTable.add(playerB.getTable().getMinions()[i]);
            }
        }
        return enemyTable;
    }

}
