package cards.minions;

import cards.Minion;
import game.assets.Assets;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * Simple warrior minion.
 *
 * @author Eero Kuurne
 */
public class Watchman extends Minion {

    public Watchman() {
        super("Watchman", 30, 2, 3, false, false, true, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.watchmanSmall, super.getX(), super.getY(), null);
    }
}
