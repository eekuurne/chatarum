package game.AI;

import game.logic.LogicHandler;
import game.logic.Player;
import java.util.ArrayList;

/**
 * AI which tries to mimic an average player: it tries to play the minions like
 * they are supposed to and uses minions to attack enemy influence if the turn
 * is lethal.
 *
 * Still, it doesn't know which cards are best and when, and who to attack. So
 * in conclusion: this AI doesn't know how to play optimally, but it is not
 * obviously stupid.
 *
 * @author Eero Kuurne
 */
public class MediumAI extends AI {

    private final int[] normalOrder = {2, 4, 6, 0, 7, 1, 3, 5};
    private final int[] guardianOrder = {3, 5, 1, 7, 6, 4, 2, 0};

    public MediumAI(Player playerA, Player playerB, LogicHandler handler) {
        super(playerA, playerB, handler);
    }

    /**
     * The AI starts with checking if it can finish the game in this turn and
     * does so if possible. Then it proceeds to play the turns of the minions in
     * table. Then it plays the hand. Then it plays the new mounted minions.
     *
     * This order seems to win most with these methods according to my tests, so
     * I'll keep it for MediumAI.
     */
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

    /**
     * The AI tries the minions in hand in order, and if there's enough
     * resources it plays it to the table. If it's a guardian, it tries to place
     * it next to other minions if possible, otherwise places on predefined
     * slots (guardianOrder). If it's any other minion, it tries to place it
     * next to guardian if possible, otherwise places it on predefined slots
     * (normalOrder).
     */
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

    /**
     * Insert any other minion than guardian to the table.
     */
    private void insertMinionToTable(int handSlot) {
        placeMinionNextToGuardian();

        if (handler.getChosenHandMinion() != null) {
            placeMinionInOrder(normalOrder);
        }
    }

    /**
     * Insert a guardian minion to the table.
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
     * Plays chosen minion to the table, trying the slots if they're empty in
     * the given order.
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
