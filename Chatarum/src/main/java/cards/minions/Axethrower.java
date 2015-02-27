package cards.minions;

import cards.Minion;
import game.assets.Assets;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Axethrower extends Minion {

    public Axethrower() {
        super("Axethrower", 55, 4, 2, false, true, false, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.axethrowerSmall, super.getX(), super.getY(), null);
    }
}
