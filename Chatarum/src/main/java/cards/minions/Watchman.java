
package cards.minions;

import cards.Minion;
import graphics.Assets;
import java.awt.Graphics;

/**
 * Simple guardian minion.
 * 
 * @author Eero
 */
public class Watchman extends Minion {

    public Watchman() {
        super(1, 2, 0, "Watchman", 20, false, false, false , 0, Assets.swordmanBig);
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