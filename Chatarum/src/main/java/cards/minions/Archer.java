package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * Basic warrior class.
 *
 * @author Eero Kuurne
 */
public class Archer extends Minion {

    public Archer() {
        super("Archer", 15, 1, 1, false, true, false, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.archerSmall, super.getX(), super.getY(), null);
    }
    
    @Override
    public void paintHover(Graphics g) {
        if (super.getY() <= Locations.tableSlotsY) {
            g.drawImage(Assets.archerBig, super.getX() - (Assets.bigWidth - Assets.smallWidth) 
                    / 2, super.getY(), null);
        } else {
            g.drawImage(Assets.archerBig, super.getX() - (Assets.bigWidth - Assets.smallWidth) 
                    / 2, super.getY() - (Assets.bigHeight - Assets.smallHeight), null);
        }
    }
}