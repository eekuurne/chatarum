package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * A simple warrior minion, which can be drawn from an empty deck.
 * 
 * @author Eero Kuurne
 */
public class Militia extends Minion {

    public Militia() {
        super("Militia", 10, 1, 1);
        
        setSmallPic(Assets.militiaSmall);
        setBigPic(Assets.militiaBig);
    }
}