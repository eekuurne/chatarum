package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 * A simple guardian.
 *
 * @author Eero Kuurne
 */
public class Bouncer extends Minion {

    public Bouncer() {
        super("Bouncer", 20, 1, 2);
        setGuardian(true);
        
        setSmallPic(Assets.bouncerSmall);
        setBigPic(Assets.bouncerBig);
    }
}