package cards.spells;

import cards.OffensiveAOE;
import game.assets.Assets;
import game.logic.LogicHandler;
import game.logic.Player;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Eero Kuurne
 */
public class Volley extends OffensiveAOE {

    public Volley() {
        super("Command: Volley", 70);
    }

    @Override
    public void clickEnemyTable(LogicHandler handler, Player playerA, Player playerB) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void paintComponent(Graphics g) {
        // Draw placeholder.
        g.drawRoundRect(getX(), getY(), Assets.smallWidth, Assets.smallHeight, 21, 21);

        Font font = new Font("Serif", Font.BOLD, Assets.statTextFont);
        g.setFont(font);
        g.drawString("  " + getName(), getX() + 5, getY() + 2 * Assets.smallHeight / 3);

        font = new Font("Serif", Font.BOLD, (int) (Assets.statTextFont / 1.5));
        g.setFont(font);
        g.drawString("Deals 2 AOE damage.", getX() + 5, getY() + 4 * Assets.smallHeight / 5);

        font = new Font("Serif", Font.BOLD, (int) (Assets.statTextFont / 1.2));
        g.setFont(font);
        g.drawString("" + getCost(), getX() + Assets.smallWidth / 2, getY() + Assets.smallHeight - 5);

        g.drawString("   <Placeholder>", getX() + 5, getY() + Assets.smallHeight / 3);
    }
    
    public void paintHover(Graphics g) {
        g.drawImage(Assets.archerBig, super.getX(), super.getY(), null);
    }

}
