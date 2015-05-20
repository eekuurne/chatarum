/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.minions;

import cards.Minion;
import cards.containers.Table;
import game.assets.Assets;
import game.logic.Player;
import game.ui.Locations;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Eero Kuurne
 */
public class PuppetMaster extends Minion {

    public PuppetMaster() {
        super("Puppet Master", 80, 2, 4);
        setRanged(true);
        
        setSmallPic(Assets.puppetMasterSmall);
        setBigPic(Assets.puppetMasterBig);
    }

    /**
     * Takes control of a random enemy minion when played to table. Places it to
     * the leftmost empty slot on own table. If own table is full, doesn't do
     * anything.
     *
     * @param ownPlayer Player who plays the minion.
     * @param enemyPlayer The other player.
     */
    @Override
    public void enterTable(Player ownPlayer, Player enemyPlayer, int slot) {
        ArrayList<Integer> enemyMinionSlots = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (enemyPlayer.getTable().getMinions()[i] != null) {
                enemyMinionSlots.add(i);
            }
        }
        if (enemyMinionSlots.isEmpty()) {
            return;
        }
        int chosen = randomSlot(enemyMinionSlots);

        for (int i = 0; i < 8; i++) {
            if (ownPlayer.getTable().getMinions()[i] == null) {
                ownPlayer.getTable().insertMinion(enemyPlayer.getTable().getMinions()[chosen], i);
                enemyPlayer.getTable().removeMinion(chosen);
                return;
            }
        }
    }
    
    private int randomSlot(ArrayList<Integer> enemyMinionSlots) {
        Random rand = new Random();
        int chosenSlot = rand.nextInt(enemyMinionSlots.size());
        return enemyMinionSlots.get(chosenSlot);
    }
}
