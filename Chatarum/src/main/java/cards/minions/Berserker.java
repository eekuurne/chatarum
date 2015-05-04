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
 *
 * @author Eero Kuurne
 */
public class Berserker extends Minion {

    public Berserker() {
        super("Berserker", 35, 4, 3, false, false, false, 0);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.berserkerSmall, super.getX(), super.getY(), null);
    }

    public void paintHover(Graphics g) {
        if (super.getY() <= Locations.tableSlotsY) {
            g.drawImage(Assets.berserkerBig, super.getX() - (Assets.bigWidth - Assets.smallWidth)
                    / 2, super.getY(), null);
        } else {
            g.drawImage(Assets.berserkerBig, super.getX() - (Assets.bigWidth - Assets.smallWidth)
                    / 2, super.getY() - (Assets.bigHeight - Assets.smallHeight), null);
        }
    }
}
