/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 * A warrior minion.
 *
 * @author Eero Kuurne
 */
public class Berserker extends Minion {

    public Berserker() {
        super("Berserker", 35, 4, 3);
        
        setSmallPic(Assets.berserkerSmall);
        setBigPic(Assets.berserkerBig);
    }
}