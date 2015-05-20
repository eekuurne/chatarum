package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 * A warrior minion summoned by voodoo priest.
 *
 * @author Eero Kuurne
 */
public class Zombie extends Minion {

    public Zombie() {
        super("Zombie", 15, 1, 2);
        
        setSmallPic(Assets.zombieSmall);
        setBigPic(Assets.zombieBig);
    }
}