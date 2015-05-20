package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 * A guardian minion.
 *
 * @author Eero Kuurne
 */
public class Shieldmaiden extends Minion {

    public Shieldmaiden() {
        super("Shieldmaiden", 40, 3, 4);
        setGuardian(true);
        
        setSmallPic(Assets.shieldmaidenSmall);
        setBigPic(Assets.shieldmaidenBig);
    }
}