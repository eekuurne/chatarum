package game.input;

import cards.Card;
import game.assets.Assets;
import game.logic.LogicHandler;
import game.logic.Player;
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
    private LogicHandler handler;

    public MouseInput(UserInterface ui) {
        this.ui = ui;
        this.handler = ui.getHandler();
    }

    /**
     * Defines all the possible slots the players can click on their turn.
     * 
     * (Figured out a better way to code this, will fix it later when there are
     * no more things with higher priority, as this works ok as well)
     *
     * @param me Mouse event.
     */
    @Override
    public void mousePressed(MouseEvent me) {
        int mx = me.getX(); // Mouse Y coordinate when pressed.
        int my = me.getY(); // Mouse X coordinate when pressed.
        
        Player playerA = handler.checkPlayerTurn()[0]; // Player whose turn it is.
        Player playerB = handler.checkPlayerTurn()[1]; // The other player.
        int turnPlayer = playerA.getPlayerNumber(); // Player number of A.

        // End turn button:
        if (mx >= Locations.endTurnX && mx <= Locations.endTurnX + Assets.endTurnWidth
                && my >= Locations.endTurnY && my <= Locations.endTurnY + Assets.endTurnHeight) {
            
            handler.changeTurn();

        } // Player A table:
        else if ((turnPlayer == 1 && mx >= Locations.tableSlotsX && mx <= Locations.tableSlotsX + Assets.tableSlotsWidth
                && my >= Locations.player1TableSlotY && my <= Locations.tableSlotsY + Assets.tableSlotsHeight) 
                || (turnPlayer == 2 && mx >= Locations.tableSlotsX && mx <= Locations.tableSlotsX + Assets.tableSlotsWidth
                && my >= Locations.tableSlotsY && my <= Locations.tableSlotsY + Assets.tableSlotHeight)) {

            handler.playerATableClicked(mx, my, playerA, playerB);
            
        } // Player B table:
        else if ((turnPlayer == 2 && mx >= Locations.tableSlotsX && mx <= Locations.tableSlotsX + Assets.tableSlotsWidth
                && my >= Locations.player1TableSlotY && my <= Locations.tableSlotsY + Assets.tableSlotsHeight) 
                || (turnPlayer == 1 && mx >= Locations.tableSlotsX && mx <= Locations.tableSlotsX + Assets.tableSlotsWidth
                && my >= Locations.tableSlotsY && my <= Locations.tableSlotsY + Assets.tableSlotHeight)) {

            handler.playerBTableClicked(mx, my, playerA, playerB);
            
        }// Player A hand:
        else if ((turnPlayer == 1 && my >= Locations.player1HandY 
                && my <= Locations.player1HandY + Assets.smallHeight) 
                || (turnPlayer == 2 && my >= Locations.player2HandY 
                && my <= Locations.player2HandY + Assets.smallHeight)) {
            
            handler.playerAHandClicked(mx, my, playerA);
            
        } // Player clicks anywhere else:
        else {
            ui.getHandler().clearChosen();
        }

        // Repaint no matter what happened.
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
