package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 * A deadly minion.
 *
 * @author Eero Kuurne
 */
public class Headhunter extends Minion {

    public Headhunter() {
        super("Headhunter", 40, 0, 3);
        setDeadly(true);
        
        setSmallPic(Assets.headhunterSmall);
        setBigPic(Assets.headhunterBig);
    }
}