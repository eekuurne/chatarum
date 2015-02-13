package cards.minions;

import cards.Minion;
import graphics.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Simple warrior minion.
 *
 * @author Eero Kuurne
 */
public class Swordman extends Minion {

    public Swordman() {
        super(3, 2, 0, "Swordman", 25, false, false, false, 0, Assets.swordmanBig);
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.swordmanSmall, (int) x, (int) y, null);
    }
}
