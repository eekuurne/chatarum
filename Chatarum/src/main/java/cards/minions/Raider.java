package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * A simple mounted minion.
 *
 * @author Eero Kuurne
 */
public class Raider extends Minion {

    public Raider() {
        super("Raider", 25, 2, 1);
        setTurnLeft(true);
        
        setSmallPic(Assets.raiderSmall);
        setBigPic(Assets.raiderBig);
    }
}