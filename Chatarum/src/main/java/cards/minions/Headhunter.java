package cards.minions;

import cards.Minion;
import game.assets.Assets;
import game.ui.Locations;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Headhunter extends Minion {

    public Headhunter() {
        super("Headhunter", 40, 0, 3, false, false, false, 0);
        setDeadly(true);
    }
}
