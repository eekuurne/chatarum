package game.AI;

import cards.Card;
import cards.Minion;
import game.logic.LogicHandler;
import game.logic.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Abstract parent class for all artificial intelligences.
 *
 * @author Eero Kuurne
 */
public abstract class AI {

    protected Player playerA; // The AI's player
    protected Player playerB; // The enemy player

    protected LogicHandler handler;
    protected Random rand;

    public AI(Player playerA, Player playerB, LogicHandler handler) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.handler = handler;
        this.rand = new Random();
    }

    /**
     * Defines what happens when the game asks for the AI to play his turn.
     * Every different AI implementation has a different approach, so the method
     * is abstract.
     */
    public abstract void playTurn();

    /**
     * Attacks random targets with every minion on the player's table.
     */
    protected void playTableRandomly() {
        for (int i = 0; i < 8; i++) {
            if (playerA.getTable().getMinions()[i] != null
                    && playerA.getTable().getMinions()[i].getTurnleft()) {
                int[] enemyTableSlots = randomSlotOrders(checkFilledTableSlots(playerB));
                if (enemyTableSlots.length > 0) {
                    for (int j = 0; j < enemyTableSlots.length; j++) {
                        handler.minionAttack(i, enemyTableSlots[j], playerA, playerB);
                        if (playerA.getTable().getMinions()[i] == null
                                || !playerA.getTable().getMinions()[i].getTurnleft()) {
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Goes through hand slots in order and places minions on table to a random
     * slot if there is enough resources.
     */
    protected void playHandRandomly() {
        int handSize = playerA.getHand().getRemaining();
        for (int i = handSize - 1; i >= 0; i--) {
            if (playerA.getRemainingResources() >= playerA.getHand().getCards().get(i).getCost()) {
                handler.clickHandSlot(i, playerA);

                int[] tableSlots = checkEmptyTableSlots(playerA);

                if (tableSlots.length > 0) {
                    int slot = tableSlots[rand.nextInt(tableSlots.length)];
                    handler.placeChosenMinionToTable(slot, playerA, playerB);
                }
            }
        }
    }

    /**
     * Attacks enemy minions with own minions if they die to the attack. First
     * tries the optimal targets, then targets with less health than attackers
     * attack value.
     */
    protected void tableAttackToKill() {
        tableAttackOptimalTargets();
        tableAttackOverkillTargets();
    }

    /**
     * Goes through minions in table and tries to attack target who has health
     * equal to attackers damage.
     */
    private void tableAttackOptimalTargets() {
        int[] attackOrder = randomSlotOrders();
        for (int i = 0; i < 8; i++) {
            if (playerA.getTable().getMinions()[i] != null && playerA.getTable().getMinions()[i].getTurnleft()) {
                playerA.getTable().getMinions()[i].clickInTable(handler, i);
                Minion attacker = playerA.getTable().getMinions()[i];
                for (int j = 0; j < 8; j++) {
                    Minion defender = playerB.getTable().getMinions()[attackOrder[j]];
                    if (defender != null && (attacker.getDamage() == defender.getHealth() || attacker.getDeadly())) {
                        handler.minionAttack(i, attackOrder[j], playerA, playerB);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Goes through minions in table and tries to attack target who has health
     * smaller than attackers damage.
     */
    private void tableAttackOverkillTargets() {
        int[] attackOrder = randomSlotOrders();
        for (int i = 0; i < 8; i++) {
            if (playerA.getTable().getMinions()[i] != null && playerA.getTable().getMinions()[i].getTurnleft()) {
                playerA.getTable().getMinions()[i].clickInTable(handler, i);
                Minion attacker = playerA.getTable().getMinions()[i];
                for (int j = 0; j < 8; j++) {
                    Minion defender = playerB.getTable().getMinions()[attackOrder[j]];
                    if (defender != null && attacker.getDamage() >= defender.getHealth()) {
                        handler.minionAttack(i, attackOrder[j], playerA, playerB);
                        break;
                    }
                }
            }
        }
    }

    /**
     * @return Array with numbers from 0 to 7 in random order.
     */
    private int[] randomSlotOrders() {
        int[] slots = {0, 1, 2, 3, 4, 5, 6, 7};

        // Fisher-Yates shuffle:
        for (int i = slots.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int a = slots[index];
            slots[index] = slots[i];
            slots[i] = a;
        }

        return slots;
    }

    /**
     * Shuffles the parameter's array and returns it.
     *
     * @param slots Array of integers
     * @return Array with numbers of parameter's array in random order
     */
    private int[] randomSlotOrders(int[] slots) {
        // Fisher-Yates shuffle:
        for (int i = slots.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int a = slots[index];
            slots[index] = slots[i];
            slots[i] = a;
        }
        return slots;
    }

    /**
     * Checks if the player has possibility to end the game on this turn and
     * ends the game if so.
     */
    protected void checkLethal() {
        int enemyInfluence = playerB.getRemainingInfluence();
        int tableDamage = checkTableDamage();
        int handMountedDamage = checkHandMountedDamage();

        if (enemyInfluence - tableDamage - handMountedDamage <= 0) {
            playMountedMinions();
            handler.endTurn();
        }
    }

    /**
     * Returns the player's table slots which are filled with minion.
     *
     * @param player The player who's table is checked
     * @return Player's table slots which are filled with minion
     */
    private int[] checkFilledTableSlots(Player player) {
        int size = 0;
        for (int i = 0; i < 8; i++) {
            if (player.getTable().getMinions()[i] != null) {
                size++;
            }
        }
        int[] tableSlots = new int[size];
        int j = 0;
        for (int i = 0; i < 8; i++) {
            if (player.getTable().getMinions()[i] != null) {
                tableSlots[j] = i;
                j++;
            }
        }
        return tableSlots;
    }

    /**
     * Returns the player's table slots which are empty.
     *
     * @param player The player who's table is checked
     * @return Player's table slots which are empty
     */
    private int[] checkEmptyTableSlots(Player player) {
        int size = 0;
        for (int i = 0; i < 8; i++) {
            if (player.getTable().getMinions()[i] == null) {
                size++;
            }
        }
        int[] tableSlots = new int[size];
        int j = 0;
        for (int i = 0; i < 8; i++) {
            if (player.getTable().getMinions()[i] == null) {
                tableSlots[j] = i;
                j++;
            }
        }
        return tableSlots;
    }

    /**
     * @return Total damage of the minions in player's table.
     */
    private int checkTableDamage() {
        int damage = 0;

        for (int i = 0; i < 8; i++) {
            Minion minion = playerA.getTable().getMinions()[i];
            if (minion != null && minion.getTurnleft()) {
                damage += minion.getDamage();
            }
        }
        return damage;
    }

    /**
     * @return The damage potential of mounted minions in hand.
     */
    private int checkHandMountedDamage() {
        int ownResources = playerA.getRemainingResources();
        int damage = 0;
        int emptySlots = checkEmptyTableSlots(playerA).length;

        for (int i = 0; i < playerA.getHand().getRemaining(); i++) {
            if (emptySlots <= 0) {
                break;
            }
            handler.clickHandSlot(i, playerA);
            if (handler.getChosenHandMinion() != null && handler.getChosenHandMinion().getTurnleft()
                    && ownResources - handler.getChosenHandMinion().getCost() >= 0) {
                damage += handler.getChosenHandMinion().getDamage();
                ownResources -= handler.getChosenHandMinion().getCost();
                emptySlots--;
            }
        }
        return damage;
    }

    /**
     * Plays mounted minions from hand to table in the order they are in hand
     * slots.
     */
    private void playMountedMinions() {
        for (int i = 0; i < playerA.getHand().getRemaining(); i++) {
            handler.clickHandSlot(i, playerA);
            if (handler.getChosenHandMinion() != null && handler.getChosenHandMinion().getTurnleft()
                    && playerA.getRemainingResources() - handler.getChosenHandMinion().getCost() >= 0) {
                for (int j = 0; j < 8; j++) {
                    if (playerA.getTable().getMinions()[j] == null) {
                        handler.placeChosenMinionToTable(j, playerA, playerB);
                        break;
                    }
                }
            }
        }
    }

    public LogicHandler getHandler() {
        return handler;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void setHandler(LogicHandler handler) {
        this.handler = handler;
    }

    public void setPlayerA(Player playerA) {
        this.playerA = playerA;
    }

    public void setPlayerB(Player playerB) {
        this.playerB = playerB;
    }
}
