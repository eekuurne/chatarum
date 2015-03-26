package game.AI;

import game.logic.LogicHandler;
import game.logic.Player;
import java.util.ArrayList;

/**
 * AI which tries to mimic an average player: it tries to play the minions
 * like they are supposed to and uses minions to attack enemy influence if
 * the turn is lethal.
 *
 * @author Eero Kuurne
 */
public class MediumAI extends AI {

    public MediumAI(Player playerA, Player playerB, LogicHandler handler) {
        super(playerA, playerB, handler);
    }

    @Override
    public void playTurn() {
        checkLethal();
        playTable();
        playHand();
        playTable();
    }

    private void playTable() {
        for (int i = 0; i < 8; i++) {
            if (playerA.getTable().getMinions()[i] != null
                    && playerA.getTable().getMinions()[i].getTurnleft()) {
                ArrayList<Integer> enemyTableSlots = checkFilledTableSlots(playerB);

                if (enemyTableSlots.size() > 0) {
                    int attackSlot = enemyTableSlots.get(rand.nextInt(enemyTableSlots.size()));
                    handler.minionAttack(i, attackSlot, playerA, playerB);
                }
            }
        }
    }

    private void playHand() {
        int handSize = playerA.getHand().getRemaining();
        for (int i = handSize - 1; i >= 0; i--) {
            if (playerA.getRemainingResources() >= playerA.getHand().getCards().get(i).getCost()) {
                handler.clickHandSlot(i, playerA);

                ArrayList<Integer> tableSlots = checkEmptyTableSlots(playerA);

                if (tableSlots.size() > 0) {
                    int slot = tableSlots.get(rand.nextInt(tableSlots.size()));
                    handler.placeChosenMinionToTable(slot, playerA, playerB);
                }
            }
        }
    }
}
