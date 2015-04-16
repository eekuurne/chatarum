package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * Simple production minion.
 *
 * @author Eero Kuurne
 */
public class Peasant extends Minion {

    public Peasant() {
        super("Peasant", 5, 0, 2, false, false, false, 5);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.peasantSmall, super.getX(), super.getY(), null);
    }
    
    public void paintHover(Graphics g) {
        if (super.getY() <= Locations.tableSlotsY) {
            g.drawImage(Assets.peasantBig, super.getX() - (Assets.bigWidth - Assets.smallWidth) 
                    / 2, super.getY(), null);
        } else {
            g.drawImage(Assets.peasantBig, super.getX() - (Assets.bigWidth - Assets.smallWidth) 
                    / 2, super.getY() - (Assets.bigHeight - Assets.smallHeight), null);
        }
    }
}
