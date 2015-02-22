package cards.minions;

import cards.Minion;
import game.assets.Assets;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * Simple warrior minion, which can be drawn from an empty deck.
 * 
 * @author Eero Kuurne
 */
public class Militia extends Minion {

    public Militia() {
        super("Militia", 10, 1, 1, false, false, false, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.militiaSmall, super.getX(), super.getY(), null);
    }
}
