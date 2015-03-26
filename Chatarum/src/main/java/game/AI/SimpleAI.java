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

    @Override
    public void playTurn() {
        playTable();
        playHand();
        playTable();

    }

    /**
     * Attacks random targets with every minion on the player's table.
     *
     */
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

    /**
     * Goes through hand slots in order and places minions on table to a random
     * slot if there is enough resources.
     *
     */
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
