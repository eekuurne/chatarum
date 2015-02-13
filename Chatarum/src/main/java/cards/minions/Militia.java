
package cards.minions;

import cards.Minion;
import graphics.Assets;
import java.awt.Graphics;

/**
 * Simple warrior minion, which can be drawn from an empty deck or converted 
 * from the cheapest worker or gained with some Skills.
 * 
 * @author Eero Kuurne
 */
public class Militia extends Minion {
    
    public Militia() {
        super(1, 1, 0, "Militia", 10, false, false, false, 0, Assets.swordmanBig);
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