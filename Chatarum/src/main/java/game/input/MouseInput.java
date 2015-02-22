package game.input;

import game.assets.Assets;
import game.ui.Locations;
import game.ui.UserInterface;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Eero Kuurne
 */
public class MouseInput implements MouseListener {

    private UserInterface ui;

    public MouseInput(UserInterface ui) {
        this.ui = ui;
    }

    public void mousePressed(MouseEvent me) {
        int mx = me.getX();
        int my = me.getY();
        
        if (mx >= Locations.endTurnX && mx <= Locations.endTurnX + Assets.endTurnWidth
                && my >= Locations.endTurnY && my <= Locations.endTurnY + Assets.endTurnHeight) {
            ui.getHandler().changeTurn();
        }
        
        ui.repaint();
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mouseClicked(MouseEvent me) {
    }
}
