package cards.minions;

import cards.Minion;
import game.assets.Assets;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Zombie extends Minion {

    public Zombie() {
        super("Zombie", 15, 1, 2, false, false, false, 0);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Assets.zombieSmall, super.getX(), super.getY(), null);
    }
}