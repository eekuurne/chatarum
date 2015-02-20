package game.logic;

import graphics.Assets;
import java.awt.Graphics;

/**
 * (Implemented on later iteration.)
 *
 * All the Champions bring 3 unique skills to the table. Each player has 1
 * Champion, which are faction specific. The Champions will be stored in deck
 * when composing the deck and will be moved to Player when game starts. Their
 * health is stored in Player class.
 *
 * @author Eero Kuurne
 */
public class Champion {

    /**
     * Method for taking damage.
     *
     * @param g Graphics tool.
     * @param player 1 for player at bottom, 2 for top.
     * @param faction Defines the frame decorations. Will probably be changed
     * later when the champion itself will contain it's faction.
     */
    public void render(Graphics g, int player, int faction) {
        int x = 1540;
        int y;
        if (player == 1) {
            y = 1080 - 208 - 282;
        } else {
            y = 282;
        }

        if (faction == 1) {
            g.drawImage(Assets.brotherhoodChampionFrame, x, y, null);
        } else if (faction == 2) {
            g.drawImage(Assets.cultChampionFrame, x, y, null);
        }
    }
}
