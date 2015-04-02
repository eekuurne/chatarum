package game.AI;

import game.logic.LogicHandler;
import game.logic.Player;
import java.util.ArrayList;

/**
 * THIS CLASS IS FOR TESTING ONLY. IT WILL MOST LIKELY CONTAIN METHODS THAT AREN'T
 * PROPERLY COMMENTED, TESTED OR ARE UNDER CONSTRUCTION IN ANY OTHER WAY.
 * 
 * I copy another AI here, change something and play this AI against the copied 
 * one to test the effects of the change. This class is where I build all the
 * new methods.
 *
 * @author Eero Kuurne
 */
public class TestAI extends AI {

    private final int[] normalOrder = {2, 4, 6, 0, 7, 1, 3, 5};
    private final int[] guardianOrder = {3, 5, 1, 7, 6, 4, 2, 0};

    public TestAI(Player playerA, Player playerB, LogicHandler handler) {
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
        playTableRandomly();
    }

    private void playHand() {
        int handSize = playerA.getHand().getRemaining();
        for (int i = handSize - 1; i >= 0; i--) {
            if (playerA.getRemainingResources() >= playerA.getHand().getCards().get(i).getCost()) {
                handler.clickHandSlot(i, playerA);

                if (handler.getChosenHandMinion() != null && handler.getChosenHandMinion().getGuardian()) {
                    insertGuardianToTable(i);
                } else {
                    insertMinionToTable(i);
                }
            }
        }
    }

    private void playHandEmptyTableB() {
        playWorker();
        playOtherMinion();
        playGuardian();
        playMounted();
        // Play anything else than guardian or mounted
        // Play guardian
        // Play mounted
    }

    private void playWorker() {
        for (int i = 0; i < playerA.getHand().getRemaining(); i++) {

        }
    }

    private void playOtherMinion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void playGuardian() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void playMounted() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Insert any other minion than guardian to the table.
     *
     */
    private void insertMinionToTable(int handSlot) {
        placeMinionNextToGuardian();

        if (handler.getChosenHandMinion() != null) {
            placeMinionInOrder(normalOrder);
        }
    }

    /**
     * Insert a guardian minion to the table.
     *
     */
    private void insertGuardianToTable(int handSlot) {
        placeGuardianNextToMinion();

        if (handler.getChosenHandMinion() != null) {
            placeMinionInOrder(guardianOrder);
        }
    }

    /**
     * Checks the guardian placing order and places the guardian to the slot if
     * there is another minion next to it.
     *
     */
    private void placeGuardianNextToMinion() {
        for (int i = 0; i < 8; i++) {
            int nextSlot = guardianOrder[i] + 1;
            int previousSlot = guardianOrder[i] - 1;
            if (playerA.getTable().getMinions()[guardianOrder[i]] == null
                    && ((previousSlot >= 0 && playerA.getTable().getMinions()[previousSlot] != null
                    && !playerA.getTable().getMinions()[previousSlot].getGuardian())
                    || (nextSlot <= 7 && playerA.getTable().getMinions()[nextSlot] != null)
                    && !playerA.getTable().getMinions()[nextSlot].getGuardian())) {
                handler.placeChosenMinionToTable(guardianOrder[i], playerA, playerB);
                break;
            }
        }
    }

    /**
     * Places a minion next to guardian.
     *
     */
    private void placeMinionNextToGuardian() {
        for (int i = 0; i < 8; i++) {
            int nextSlot = normalOrder[i] + 1;
            int previousSlot = normalOrder[i] - 1;
            if (playerA.getTable().getMinions()[normalOrder[i]] == null
                    && ((previousSlot >= 0 && playerA.getTable().getMinions()[previousSlot] != null
                    && playerA.getTable().getMinions()[previousSlot].getGuardian())
                    || (nextSlot <= 7 && playerA.getTable().getMinions()[nextSlot] != null)
                    && playerA.getTable().getMinions()[nextSlot].getGuardian())) {
                handler.placeChosenMinionToTable(normalOrder[i], playerA, playerB);
                break;
            }
        }
    }

    /**
     * Plays chosen minion to the table, trying the slots if they're empty
     * in the given order.
     *
     */
    private void placeMinionInOrder(int[] order) {
        for (int i = 0; i < 8; i++) {
            if (playerA.getTable().getMinions()[order[i]] == null) {
                handler.placeChosenMinionToTable(order[i], playerA, playerB);
                break;
            }
        }
    }
}
