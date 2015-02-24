package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.logic.LogicHandler;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * Simple warrior minion.
 *
 * @author Eero Kuurne
 */
public class Swordman extends Minion {

    public Swordman() {
        super("Swordman", 25, 3, 2, false, false, false, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.swordmanSmall, super.getX(), super.getY(), null);
    }
}
