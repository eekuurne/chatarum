/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cards.minions;

import cards.Minion;
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
public class VoodooPriest extends Minion {

    public VoodooPriest() {
        super("Voodoo Priest", 55, 2, 2);
        setRanged(true);
        
        setSmallPic(Assets.voodooPriestSmall);
        setBigPic(Assets.voodooPriestBig);
    }

    /**
     * Summons 2 zombies to adjacent slots.
     *
     * @param ownPlayer Player who plays the minion.
     * @param enemyPlayer The other player.
     */
    @Override
    public void enterTable(Player ownPlayer, Player enemyPlayer, int slot) {
        //System.out.println("Voodoo priest has arrived!");
        if (slot != 0 && ownPlayer.getTable().getMinions()[slot - 1] == null) {
            //System.out.println("Left zombie summoned!");
            ownPlayer.getTable().insertMinion(new Zombie(), slot - 1);
        }
        if (slot != 7 && ownPlayer.getTable().getMinions()[slot + 1] == null) {
            //System.out.println("Right zombie summoned!");
            ownPlayer.getTable().insertMinion(new Zombie(), slot + 1);
        }
        
    }
}