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
 * A mounted minion.
 *
 * @author Eero Kuurne
 */
public class Moonblade extends Minion {

    public Moonblade() {
        super("Moonblade", 40, 3, 2);
        setTurnLeft(true);
        
        setSmallPic(Assets.moonbladeSmall);
        setBigPic(Assets.moonbladeBig);
    }
}