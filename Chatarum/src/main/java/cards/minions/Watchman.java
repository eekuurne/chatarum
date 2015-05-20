package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * A guardian minion.
 *
 * @author Eero Kuurne
 */
public class Watchman extends Minion {

    public Watchman() {
        super("Watchman", 30, 2, 3);
        setGuardian(true);
        
        setSmallPic(Assets.watchmanSmall);
        setBigPic(Assets.watchmanBig);
    }
}