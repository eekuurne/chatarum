package game.input;

import graphics.Locations;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import states.GameState;

/**
 *
 * @author Eero Kuurne
 */
public class MouseManager implements MouseListener {

    private GameState gameState;

    public MouseManager(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        int mx = me.getX();
        int my = me.getY();
        
        // End turn button.
        if (mx >= Locations.endTurnX && mx <= Locations.endTurnX + 200) {
            if (my >= Locations.endTurnY && my <= Locations.endTurnY + 200) {
                gameState.setTurn(gameState.getTurn() + 1);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
}
