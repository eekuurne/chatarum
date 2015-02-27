/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cards.minions;

import cards.Minion;
import game.assets.Assets;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Moonblade extends Minion {

    public Moonblade() {
        super("Moonblade", 40, 3, 2, true, false, false, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.moonbladeSmall, super.getX(), super.getY(), null);
    }
}