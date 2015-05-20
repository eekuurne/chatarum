package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * Basic ranged minion.
 *
 * @author Eero Kuurne
 */
public class Archer extends Minion {

    public Archer() {
        super("Archer", 15, 1, 1);
        setRanged(true);
        
        setSmallPic(Assets.archerSmall);
        setBigPic(Assets.archerBig);
    }
}