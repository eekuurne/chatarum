package cards.minions;

import cards.Minion;
import game.assets.Assets;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * Simple production minion.
 *
 * @author Eero Kuurne
 */
public class Peasant extends Minion {

    public Peasant() {
        super("Peasant", 5, 0, 1, false, false, false, 5);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.peasantSmall, super.getX(), super.getY(), null);
    }
}
