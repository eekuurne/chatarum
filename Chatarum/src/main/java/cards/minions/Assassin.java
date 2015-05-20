package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Assassin extends Minion {

    public Assassin() {
        super("Assassin", 30, 0, 2);
        setDeadly(true);
        
        setSmallPic(Assets.assassinSmall);
        setBigPic(Assets.assassinBig);
    }
}