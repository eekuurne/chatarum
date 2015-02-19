
package cards.minions;

import cards.Minion;
import graphics.Assets;
import java.awt.Graphics;

/**
 * Simple ranged minion.
 * 
 * @author Eero
 */
public class Archer extends Minion {

    public Archer() {
        super(1, 1, 0, "Archer", 15, false, true, false , 0, Assets.archerBig);
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.archerSmall, (int) x, (int) y, null);
    }
}