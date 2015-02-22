package cards.minions;

import cards.Minion;
import game.assets.Assets;
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
}