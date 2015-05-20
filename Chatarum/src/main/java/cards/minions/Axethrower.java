package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Axethrower extends Minion {

    public Axethrower() {
        super("Axethrower", 35, 2, 1);
        setRanged(true);
        
        setSmallPic(Assets.axethrowerSmall);
        setBigPic(Assets.axethrowerBig);
    }
}
