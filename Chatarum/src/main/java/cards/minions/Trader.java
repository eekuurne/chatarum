package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Trader extends Minion {

    public Trader() {
        super("Trader", 10, 0, 4, false, false, false, 10);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.traderSmall, super.getX(), super.getY(), null);
    }

    public void paintHover(Graphics g) {
        if (super.getY() <= Locations.tableSlotsY) {
            g.drawImage(Assets.traderBig, super.getX() - (Assets.bigWidth - Assets.smallWidth)
                    / 2, super.getY(), null);
        } else {
            g.drawImage(Assets.traderBig, super.getX() - (Assets.bigWidth - Assets.smallWidth)
                    / 2, super.getY() - (Assets.bigHeight - Assets.smallHeight), null);
        }
    }
}
