
package cards.minions;

import cards.Minion;
import graphics.Assets;
import java.awt.Graphics;

/**
 * Simple worker minion.
 * 
 * @author Eero
 */
public class Peasant extends Minion {

    public Peasant() {
        super(0, 2, 0, "Peasant", 5, false, false, false , 5, Assets.swordmanBig);
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