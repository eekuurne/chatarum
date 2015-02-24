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
     * Defines all the possible slots the players can click on their turn. If I
     * figure out a way to divide it and make it look better, I will...
     *
     * @param me Mouse event.
     */
    @Override
    public void mousePressed(MouseEvent me) {
        int mx = me.getX();
        int my = me.getY();
        Player player;

        // End turn button:
        if (mx >= Locations.endTurnX && mx <= Locations.endTurnX + Assets.endTurnWidth
                && my >= Locations.endTurnY && my <= Locations.endTurnY + Assets.endTurnHeight) {
            System.out.println("End turn clicked!");
            handler.changeTurn();

        } // Minion has been chosen and player clicks table:
        else if (handler.getChosenCard() != null && mx >= Locations.tableSlotsX
                && mx <= Locations.tableSlotsX + 1194 && my >= Locations.tableSlotsY
                && my <= Locations.tableSlotsY + 468) {

            // Check which player did the click.
            if (handler.getTurn() % 2 != 0 && my >= Locations.player1TableY - 9) {
                player = handler.getPlayer1();
            } else if (handler.getTurn() % 2 == 0 && my <= (Locations.player2TableY + Assets.smallHeight + 19)) {
                player = handler.getPlayer2();
            } else {
                handler.clearChosen();
                ui.repaint();
                return;
            }

            // Table slot 1:
            if (mx <= Locations.tableSlotsX + Assets.smallWidth + 19) {
                System.out.println("Table slot 1 clikt!");
                handler.placeChosenMinionToTable(0, player);

            } // Table slot 2:
            else if (mx >= Locations.tableX[1] - 9
                    && mx <= Locations.tableX[1] + Assets.smallWidth + 19) {
                System.out.println("Table slot 2 clikt!");
                handler.placeChosenMinionToTable(1, player);

            } // Table slot 3:
            else if (mx >= Locations.tableX[2] - 9
                    && mx <= Locations.tableX[2] + Assets.smallWidth + 19) {
                System.out.println("Table slot 3 clikt!");
                handler.placeChosenMinionToTable(2, player);

            } // Table slot 4:
            else if (mx >= Locations.tableX[3] - 9
                    && mx <= Locations.tableX[3] + Assets.smallWidth + 19) {
                System.out.println("Table slot 4 clikt!");
                handler.placeChosenMinionToTable(3, player);

            } // Table slot 5:
            else if (mx >= Locations.tableX[4] - 9
                    && mx <= Locations.tableX[4] + Assets.smallWidth + 19) {
                System.out.println("Table slot 5 clikt!");
                handler.placeChosenMinionToTable(4, player);

            } // Table slot 6:
            else if (mx >= Locations.tableX[5] - 9
                    && mx <= Locations.tableX[5] + Assets.smallWidth + 19) {
                System.out.println("Table slot 6 clikt!");
                handler.placeChosenMinionToTable(5, player);

            } // Table slot 7:
            else if (mx >= Locations.tableX[6] - 9
                    && mx <= Locations.tableX[6] + Assets.smallWidth + 19) {
                System.out.println("Table slot 7 clikt!");
                handler.placeChosenMinionToTable(6, player);

            } // Table slot 8:
            else if (mx >= Locations.tableX[7] - 9
                    && mx <= Locations.tableX[7] + Assets.smallWidth + 19) {
                System.out.println("Table slot 8 clikt!");
                handler.placeChosenMinionToTable(7, player);

            }

        } // Hand buttons:
        else if ((my >= Locations.player1HandY && my <= Locations.player1HandY + Assets.smallHeight)
                || my >= Locations.player2HandY && my <= Locations.player2HandY + Assets.smallHeight) {
            
            // Which player did the click:
            if (handler.getTurn() % 2 != 0 && my >= Locations.player1HandY) {
                player = handler.getPlayer1();
            } else if (handler.getTurn() % 2 == 0 && my <= (Locations.player2HandY + Assets.smallHeight)) {
                player = handler.getPlayer2();
            } else {
                handler.clearChosen();
                ui.repaint();
                return;
            }
            
            // Hand button 1:
            if (mx >= Locations.handX[0] && mx <= Locations.handX[0] + Assets.smallWidth
                    && player.getHand().getCards().size() >= 1) {
                System.out.println("Hand slot 1 clicked!");
                handler.clickHandSlot(0, player);

            } // Hand button 2:
            else if (mx >= Locations.handX[1] && mx <= Locations.handX[1] + Assets.smallWidth
                    && player.getHand().getCards().size() >= 2) {
                System.out.println("Hand slot 2 clicked!");
                handler.clickHandSlot(1, player);

            } // Hand button 3:
            else if (mx >= Locations.handX[2] && mx <= Locations.handX[2] + Assets.smallWidth
                    && player.getHand().getCards().size() >= 3) {
                System.out.println("Hand slot 3 clicked!");
                handler.clickHandSlot(2, player);

            } // Hand button 4:
            else if (mx >= Locations.handX[3] && mx <= Locations.handX[3] + Assets.smallWidth
                    && player.getHand().getCards().size() >= 4) {
                System.out.println("Hand slot 4 clicked!");
                handler.clickHandSlot(3, player);

            } // Hand button 5:
            else if (mx >= Locations.handX[4] && mx <= Locations.handX[4] + Assets.smallWidth
                    && player.getHand().getCards().size() >= 5) {
                System.out.println("Hand slot 5 clicked!");
                handler.clickHandSlot(4, player);

            } // Hand button 6:
            else if (mx >= Locations.handX[5] && mx <= Locations.handX[5] + Assets.smallWidth
                    && player.getHand().getCards().size() >= 6) {
                System.out.println("Hand slot 6 clicked!");
                handler.clickHandSlot(5, player);

            } // Hand button 7:
            else if (mx >= Locations.handX[6] && mx <= Locations.handX[6] + Assets.smallWidth
                    && player.getHand().getCards().size() >= 7) {
                System.out.println("Hand slot 7 clicked!");
                handler.clickHandSlot(6, player);

            } // Hand button 8:
            else if (mx >= Locations.handX[7] && mx <= Locations.handX[7] + Assets.smallWidth
                    && player.getHand().getCards().size() >= 8) {
                System.out.println("Hand slot 8 clicked!");
                handler.clickHandSlot(7, player);

            } // Hand button 9:
            else if (mx >= Locations.handX[8] && mx <= Locations.handX[8] + Assets.smallWidth
                    && player.getHand().getCards().size() >= 9) {
                System.out.println("Hand slot 9 clicked!");
                handler.clickHandSlot(8, player);

            } // Hand button 10:
            else if (mx >= Locations.handX[9] && mx <= Locations.handX[9] + Assets.smallWidth
                    && player.getHand().getCards().size() >= 10) {
                System.out.println("Hand slot 10 clicked!");
                handler.clickHandSlot(9, player);

            } // Between or sides of hand buttons:
            else {
                System.out.println("Clicked between or sides of hand slots!");
                handler.clearChosen();
            }

        } // Player clicks anywhere else:
        else {
            System.out.println("Somewhere else clicked!");
            ui.getHandler().clearChosen();
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
