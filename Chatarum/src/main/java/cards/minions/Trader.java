package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 * A production minion.
 *
 * @author Eero Kuurne
 */
public class Trader extends Minion {

    public Trader() {
        super("Trader", 10, 0, 4);
        setProduction(10);
        
        setSmallPic(Assets.traderSmall);
        setBigPic(Assets.traderBig);
    }
}