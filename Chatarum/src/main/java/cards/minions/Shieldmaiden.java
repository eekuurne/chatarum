package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Shieldmaiden extends Minion {

    public Shieldmaiden() {
        super("Shieldmaiden", 40, 3, 4, false, false, true, 0);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.shieldmaidenSmall, super.getX(), super.getY(), null);
    }

    public void paintHover(Graphics g) {
        if (super.getY() <= Locations.tableSlotsY) {
            g.drawImage(Assets.shieldmaidenBig, super.getX() - (Assets.bigWidth - Assets.smallWidth)
                    / 2, super.getY(), null);
        } else {
            g.drawImage(Assets.shieldmaidenBig, super.getX() - (Assets.bigWidth - Assets.smallWidth)
                    / 2, super.getY() - (Assets.bigHeight - Assets.smallHeight), null);
        }
    }
}
