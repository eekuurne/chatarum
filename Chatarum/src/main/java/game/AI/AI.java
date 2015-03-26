package game.AI;

import cards.Card;
import cards.Minion;
import game.logic.LogicHandler;
import game.logic.Player;
import java.util.ArrayList;
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
     *
     */
    public abstract void playTurn();

    /**
     * Returns the player's table slots which are filled with minion.
     *
     * @param player The player who's table is checked
     * @return Player's table slots which are filled with minion
     */
    protected ArrayList<Integer> checkFilledTableSlots(Player player) {
        ArrayList<Integer> tableSlots = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (player.getTable().getMinions()[i] != null) {
                tableSlots.add(i);
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
    protected ArrayList<Integer> checkEmptyTableSlots(Player player) {
        ArrayList<Integer> tableSlots = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (player.getTable().getMinions()[i] == null) {
                tableSlots.add(i);
            }
        }
        return tableSlots;
    }

    /**
     * Checks if the player has possibility to end the game on this turn and
     * ends the game if so.
     *
     * @param playerA The player who's turn it is.
     * @param playerB The other player.
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
     * Returns total damage of the minions in player's table.
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
     * Returns the damage potential of mounted minions in hand.
     */
    private int checkHandMountedDamage() {
        int ownResources = playerA.getRemainingResources();
        int damage = 0;
        int emptySlots = checkEmptyTableSlots(playerA).size();

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
     *
     */
    protected void playMountedMinions() {
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
