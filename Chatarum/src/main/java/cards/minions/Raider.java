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
public class Raider extends Minion {

    public Raider() {
        super("Raider", 25, 2, 1, true, false, false, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.raiderSmall, super.getX(), super.getY(), null);
    }
}
