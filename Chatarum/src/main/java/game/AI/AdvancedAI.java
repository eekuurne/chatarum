package game.AI;

import cards.Minion;
import game.logic.LogicHandler;
import game.logic.Player;

/**
 * AdvancedAI is the result of vast testing and improvements made piece by
 * piece. It's currently the best AI and it wins the other AIs with high
 * win-loss-ratio.
 *
 * @author Eero Kuurne
 */
public class AdvancedAI extends AI {

    private final int[] normalOrder = {2, 4, 6, 0, 7, 1, 3, 5};
    private final int[] guardianOrder = {3, 5, 1, 7, 6, 4, 2, 0};

    public AdvancedAI(Player playerA, Player playerB, LogicHandler handler) {
        super(playerA, playerB, handler);
    }

    /**
     * The AI starts with checking if it can finish the game in this turn and
     * does so if possible. Then it tries to attack every target which its
     * minions can kill with one attack, starting with optimal targets and then
     * going for overkills. Then it plays the minions from its hand, order
     * depending on if the enemy table is empty or not. In the end it tries to
     * attack optimal targets with new mounted minions, and then attacks random
     * targets with all remaining minion turns.
     */
    @Override
    public void playTurn() {
        checkLethal();

        tableAttackToKill();
        tableAttackToKill();

        if (playerB.getTable().isEmpty()) {
            playBEmpty();
        } else {
            playBNotEmpty();
        }

        tableAttackToKill();
        tableAttackToKill();
        playTableRandomly();
    }

    /**
     * This method is called to play hand if the enemy player's table is empty.
     */
    private void playBEmpty() {
        if (guardedSlotsInTable() && checkHandCost() > 190) {
            playWorkers();
        }
        playRangeds();
        playDeadlys();
        if (playerA.getHand().getRemaining() > 7) {
            playWorkers();
        }
        playWarriors();
        playGuardians();
        playMounteds();
        playWorkers();
    }

    /**
     * This method is called to play hand if the enemy player's table is not
     * empty.
     */
    private void playBNotEmpty() {
        playMountedsToKill();
        playMountedsToKill();

        if (playerB.getTable().isEmpty()) {
            playBEmpty();
        } else {
            playGuardians();
            if (guardedSlotsInTable()) {
                playRangeds();
                playDeadlys();
            }
            playWarriors();
            playDeadlys();
            playMounteds();
            playRangeds();
            playWorkers();
        }
    }

    /**
     * @return Are there any empty slots next to guardians in table.
     */
    private boolean guardedSlotsInTable() {
        for (int i = 0; i < 8; i++) {
            int nextSlot = normalOrder[i] + 1;
            int previousSlot = normalOrder[i] - 1;
            if (playerA.getTable().getMinions()[normalOrder[i]] == null
                    && ((previousSlot >= 0 && playerA.getTable().getMinions()[previousSlot] != null
                    && playerA.getTable().getMinions()[previousSlot].getGuardian())
                    || (nextSlot <= 7 && playerA.getTable().getMinions()[nextSlot] != null)
                    && playerA.getTable().getMinions()[nextSlot].getGuardian())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return How much resources the cards in player's hand cost in total.
     */
    private int checkHandCost() {
        int cost = 0;
        for (int i = 0; i < playerA.getHand().getRemaining(); i++) {
            cost += playerA.getHand().getCards().get(i).getCost();
        }
        return cost;
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
     * Plays all the mounted minions who have same damage as an enemy minion's
     * health and attacks with them.
     */
    private void playMountedsToKill() {
        for (int i = playerA.getHand().getRemaining() - 1; i >= 0; i--) {
            handler.clickHandSlot(i, playerA);
            Minion attacker = handler.getChosenHandMinion();
            if (attacker != null && attacker.getTurnleft()) {
                boolean continueTrying = true;
                for (int j = 0; j < 8; j++) {
                    Minion defender = playerB.getTable().getMinions()[j];
                    if (defender != null && !handler.guarded(playerB.getTable().getMinions(), j)
                            && attacker.getDamage() == defender.getHealth() && continueTrying) {
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
