package game.AI;

import cards.Minion;
import game.logic.LogicHandler;
import game.logic.Player;
import java.util.ArrayList;

/**
 * THIS CLASS IS FOR TESTING ONLY. IT WILL MOST LIKELY CONTAIN METHODS THAT
 * AREN'T PROPERLY COMMENTED, TESTED OR ARE UNDER CONSTRUCTION IN ANY OTHER WAY.
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

        tableAttackToKill();

        if (playerB.getTable().isEmpty()) {
            playBEmpty();
        } else {
            playBNotEmpty();
        }

        tableAttackToKill();
        playTableRandomly();
    }

    private void playBEmpty() {
        if (playerA.getHand().getRemaining() > 3) { // change to count resource costs of remaining cards in hand
            playWorkers();
        }
        playWarriors();
        playRangeds();
        playDeadlys();
        playGuardians();
        playMounteds();
        playWorkers();
    }

    private void playBNotEmpty() {
        playMountedsToKill();

        if (playerB.getTable().isEmpty()) {
            playBEmpty();
        } else {
            playGuardians();
            playWarriors();
            playDeadlys();
            playMounteds();
            playRangeds();
            playWorkers();
        }
    }

    /**
     * Plays the worker minions from player's hand if possible.
     */
    private void playWorkers() {
        for (int i = playerA.getHand().getRemaining() - 1; i >= 0; i--) {
            handler.clickHandSlot(i, playerA);
            Minion chosen = handler.getChosenHandMinion();
            if (chosen != null && chosen.getProduction() > 0) {
                insertMinionToTable(i);
            }
        }
    }

    /**
     * Plays the warrior minions from player's hand if possible.
     */
    private void playWarriors() {
        for (int i = playerA.getHand().getRemaining() - 1; i >= 0; i--) {
            handler.clickHandSlot(i, playerA);
            Minion chosen = handler.getChosenHandMinion();
            if (chosen != null && !chosen.getDeadly() && !chosen.getGuardian()
                    && !chosen.getRanged() && !chosen.getTurnleft() && chosen.getProduction() == 0) {
                insertMinionToTable(i);
            }
        }
    }

    /**
     * Plays the ranged minions from player's hand if possible.
     */
    private void playRangeds() {
        for (int i = playerA.getHand().getRemaining() - 1; i >= 0; i--) {
            handler.clickHandSlot(i, playerA);
            Minion chosen = handler.getChosenHandMinion();
            if (chosen != null && chosen.getRanged()) {
                insertMinionToTable(i);
            }
        }
    }

    /**
     * Plays the deadly minions from player's hand if possible.
     */
    private void playDeadlys() {
        for (int i = playerA.getHand().getRemaining() - 1; i >= 0; i--) {
            handler.clickHandSlot(i, playerA);
            Minion chosen = handler.getChosenHandMinion();
            if (chosen != null && chosen.getDeadly()) {
                insertMinionToTable(i);
            }
        }
    }

    /**
     * Plays the guardian minions from player's hand if possible.
     */
    private void playGuardians() {
        for (int i = playerA.getHand().getRemaining() - 1; i >= 0; i--) {
            handler.clickHandSlot(i, playerA);
            Minion chosen = handler.getChosenHandMinion();
            if (chosen != null && chosen.getGuardian()) {
                insertGuardianToTable(i);
            }
        }
    }

    /**
     * Plays the mounted minions from player's hand if possible.
     */
    private void playMounteds() {
        for (int i = playerA.getHand().getRemaining() - 1; i >= 0; i--) {
            handler.clickHandSlot(i, playerA);
            Minion chosen = handler.getChosenHandMinion();
            if (chosen != null && chosen.getTurnleft()) {
                insertMinionToTable(i);
            }
        }
    }

    /**
     * Plays all the mounted minions who have enough damage to kill enemy
     * minions in table.
     */
    private void playMountedsToKill() {
        for (int i = playerA.getHand().getRemaining() - 1; i >= 0; i--) {
            handler.clickHandSlot(i, playerA);
            Minion attacker = handler.getChosenHandMinion();

            if (attacker != null && attacker.getTurnleft()) {
                boolean continueTrying = true;

                for (int j = 0; j < 8; j++) {
                    Minion defender = playerB.getTable().getMinions()[j];
                    if (defender != null && (attacker.getDamage() == defender.getHealth()) && continueTrying) {
                        for (int k = 0; k < 8; k++) {
                            if (playerA.getTable().getMinions()[k] == null) {
                                handler.placeChosenMinionToTable(k, playerA, playerB);
                                handler.minionAttack(k, j, playerA, playerB);
                                continueTrying = false;
                                break;
                            }
                        }
                    }
                }
                for (int j = 0; j < 8; j++) {
                    Minion defender = playerB.getTable().getMinions()[j];
                    if (defender != null && attacker.getDamage() > defender.getHealth() && continueTrying) {
                        for (int k = 0; k < 8; k++) {
                            if (playerA.getTable().getMinions()[k] == null) {
                                handler.placeChosenMinionToTable(k, playerA, playerB);
                                handler.minionAttack(k, j, playerA, playerB);
                                continueTrying = false;
                                break;
                            }
                        }
                    }
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
