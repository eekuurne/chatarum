package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.logic.LogicHandler;
import game.ui.Locations;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * A simple warrior minion.
 *
 * @author Eero Kuurne
 */
public class Swordman extends Minion {

    public Swordman() {
        super("Swordman", 25, 3, 2);
        
        setSmallPic(Assets.swordmanSmall);
        setBigPic(Assets.swordmanBig);
    }
}