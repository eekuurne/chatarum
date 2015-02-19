
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
        super(2, 3, 0, "Watchman", 30, false, false, false , 0, Assets.watchmanBig);
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.watchmanSmall, (int) x, (int) y, null);
    }
}