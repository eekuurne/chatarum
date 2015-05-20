package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * A simple production minion.
 *
 * @author Eero Kuurne
 */
public class Peasant extends Minion {

    public Peasant() {
        super("Peasant", 5, 0, 2);
        setProduction(5);
        
        setSmallPic(Assets.peasantSmall);
        setBigPic(Assets.peasantBig);
    }
}