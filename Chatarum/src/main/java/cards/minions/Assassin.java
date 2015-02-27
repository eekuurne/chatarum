package cards.minions;

import cards.Minion;
import game.assets.Assets;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Assassin extends Minion {

    public Assassin() {
        super("Assassin", 35, 0, 2, false, false, false, 0);
        setDeadly(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.assassinSmall, super.getX(), super.getY(), null);
    }
}