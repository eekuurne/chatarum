
package cards.minions;

import cards.Minion;
import graphics.Assets;
import java.awt.Graphics;

/**
 * Simple mounted minion.
 *
 * @author Eero
 */
public class Raider extends Minion {
    
    public Raider() {
        super(2, 1, 0, "Militia", 25, true, false, false , 0, Assets.raiderBig);
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.raiderSmall, (int) x, (int) y, null);
    }
}