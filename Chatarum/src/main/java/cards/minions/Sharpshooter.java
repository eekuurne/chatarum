package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 * A ranged minion.
 *
 * @author Eero Kuurne
 */
public class Sharpshooter extends Minion {

    public Sharpshooter() {
        super("Sharpshooter", 45, 3, 3);
        setRanged(true);
        
        setSmallPic(Assets.sharpshooterSmall);
        setBigPic(Assets.sharpshooterBig);
    }
}