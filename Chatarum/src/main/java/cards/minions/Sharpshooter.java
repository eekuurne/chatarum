package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Sharpshooter extends Minion {

    public Sharpshooter() {
        super("Sharpshooter", 45, 3, 3, false, true, false, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.archerSmall, super.getX(), super.getY(), null);
    }
}
