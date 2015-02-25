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
            System.out.println("End turn clicked!");
            handler.changeTurn();

        } // Player A table:
        else if ((turnPlayer == 1 && mx >= Locations.tableSlotsX && mx <= Locations.tableSlotsX + Assets.tableSlotsWidth
                && my >= Locations.player1TableSlotY && my <= Locations.tableSlotsY + Assets.tableSlotsHeight) 
                || (turnPlayer == 2 && mx >= Locations.tableSlotsX && mx <= Locations.tableSlotsX + Assets.tableSlotsWidth
                && my >= Locations.tableSlotsY && my <= Locations.tableSlotsY + Assets.tableSlotHeight)) {

            handler.playerATableClicked(mx, my, playerA);
            
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
            System.out.println("Somewhere else clicked!");
            ui.getHandler().clearChosen();
        }

        // Repaint no matter what happened.
        ui.repaint();

        


        /*
// Minion has been chosen from table and player clicks enemy minion:
        else if (handler.getChosenTableCard() != null && mx >= Locations.tableX[0]
                && mx <= Locations.tableX[7] + Assets.smallWidth && my >= Locations.player2TableY
                && my <= Locations.player1TableY + Assets.smallHeight) {

            // Check which player did the click.
            if (handler.getTurn() % 2 != 0 && my <= Locations.player2TableY + Assets.smallHeight) {
                playerA = handler.getPlayer1();
                playerB = handler.getPlayer2();
            } else if (handler.getTurn() % 2 == 0 && my >= (Locations.player1TableY)) {
                playerA = handler.getPlayer2();
                playerB = handler.getPlayer1();
            } else {
                handler.clearChosen();
                ui.repaint();
                return;
            }

            // Attack table slot 1:
            if (mx <= Locations.tableX[0] + Assets.smallWidth
                    && playerB.getTable().getMinions()[0] != null) {
                handler.minionAttack(handler.getChosenTableSlot(), 0, playerA, playerB);

            } // Attack table slot 2:
            else if (mx <= Locations.tableX[1] + Assets.smallWidth && mx >= Locations.tableX[1]
                    && playerB.getTable().getMinions()[1] != null) {
                handler.minionAttack(handler.getChosenTableSlot(), 1, playerA, playerB);

            } // Attack table slot 3:
            else if (mx <= Locations.tableX[2] + Assets.smallWidth && mx >= Locations.tableX[2]
                    && playerB.getTable().getMinions()[2] != null) {
                handler.minionAttack(handler.getChosenTableSlot(), 2, playerA, playerB);

            } // Attack table slot 4:
            else if (mx <= Locations.tableX[3] + Assets.smallWidth && mx >= Locations.tableX[3]
                    && playerB.getTable().getMinions()[3] != null) {
                handler.minionAttack(handler.getChosenTableSlot(), 3, playerA, playerB);

            } // Attack table slot 5:
            else if (mx <= Locations.tableX[4] + Assets.smallWidth && mx >= Locations.tableX[4]
                    && playerB.getTable().getMinions()[4] != null) {
                handler.minionAttack(handler.getChosenTableSlot(), 4, playerA, playerB);

            } // Attack table slot 6:
            else if (mx <= Locations.tableX[5] + Assets.smallWidth && mx >= Locations.tableX[5]
                    && playerB.getTable().getMinions()[51] != null) {
                handler.minionAttack(handler.getChosenTableSlot(), 5, playerA, playerB);

            } // Attack table slot 7:
            else if (mx <= Locations.tableX[6] + Assets.smallWidth && mx >= Locations.tableX[6]
                    && playerB.getTable().getMinions()[6] != null) {
                handler.minionAttack(handler.getChosenTableSlot(), 6, playerA, playerB);

            } // Attack table slot 8:
            else if (mx <= Locations.tableX[7] + Assets.smallWidth && mx >= Locations.tableX[7]
                    && playerB.getTable().getMinions()[7] != null) {
                handler.minionAttack(handler.getChosenTableSlot(), 7, playerA, playerB);

            } // Click empty slot:
            else {
                handler.clearChosen();
            }

            
        }// Minion has been chosen from hand and player clicks table:
        else if (handler.getChosenHandCard() != null && mx >= Locations.tableSlotsX
                && mx <= Locations.tableSlotsX + 1194 && my >= Locations.tableSlotsY
                && my <= Locations.tableSlotsY + 468) {

            // Check which player did the click.
            if (handler.getTurn() % 2 != 0 && my >= Locations.player1TableY - 9) {
                playerA = handler.getPlayer1();
            } else if (handler.getTurn() % 2 == 0 && my <= (Locations.player2TableY + Assets.smallHeight + 19)) {
                playerA = handler.getPlayer2();
            } else {
                handler.clearChosen();
                ui.repaint();
                return;
            }

            // Table slot 1:
            if (mx <= Locations.tableSlotsX + Assets.smallWidth + 19) {
                System.out.println("Table slot 1 clikt!");
                handler.placeChosenMinionToTable(0, playerA);

            } // Table slot 2:
            else if (mx >= Locations.tableX[1] - 9
                    && mx <= Locations.tableX[1] + Assets.smallWidth + 19) {
                System.out.println("Table slot 2 clikt!");
                handler.placeChosenMinionToTable(1, playerA);

            } // Table slot 3:
            else if (mx >= Locations.tableX[2] - 9
                    && mx <= Locations.tableX[2] + Assets.smallWidth + 19) {
                System.out.println("Table slot 3 clikt!");
                handler.placeChosenMinionToTable(2, playerA);

            } // Table slot 4:
            else if (mx >= Locations.tableX[3] - 9
                    && mx <= Locations.tableX[3] + Assets.smallWidth + 19) {
                System.out.println("Table slot 4 clikt!");
                handler.placeChosenMinionToTable(3, playerA);

            } // Table slot 5:
            else if (mx >= Locations.tableX[4] - 9
                    && mx <= Locations.tableX[4] + Assets.smallWidth + 19) {
                System.out.println("Table slot 5 clikt!");
                handler.placeChosenMinionToTable(4, playerA);

            } // Table slot 6:
            else if (mx >= Locations.tableX[5] - 9
                    && mx <= Locations.tableX[5] + Assets.smallWidth + 19) {
                System.out.println("Table slot 6 clikt!");
                handler.placeChosenMinionToTable(5, playerA);

            } // Table slot 7:
            else if (mx >= Locations.tableX[6] - 9
                    && mx <= Locations.tableX[6] + Assets.smallWidth + 19) {
                System.out.println("Table slot 7 clikt!");
                handler.placeChosenMinionToTable(6, playerA);

            } // Table slot 8:
            else if (mx >= Locations.tableX[7] - 9
                    && mx <= Locations.tableX[7] + Assets.smallWidth + 19) {
                System.out.println("Table slot 8 clikt!");
                handler.placeChosenMinionToTable(7, playerA);
            }

        } // Player clicks a card in his hand.
        else if ((my >= Locations.player1HandY && my <= Locations.player1HandY + Assets.smallHeight)
                || my >= Locations.player2HandY && my <= Locations.player2HandY + Assets.smallHeight) {

            // Which player did the click:
            if (handler.getTurn() % 2 != 0 && my >= Locations.player1HandY) {
                playerA = handler.getPlayer1();
            } else if (handler.getTurn() % 2 == 0 && my <= (Locations.player2HandY + Assets.smallHeight)) {
                playerA = handler.getPlayer2();
            } else {
                handler.clearChosen();
                ui.repaint();
                return;
            }

            // Hand button 1:
            if (mx >= Locations.handX[0] && mx <= Locations.handX[0] + Assets.smallWidth
                    && playerA.getHand().getCards().size() >= 1) {
                System.out.println("Hand slot 1 clicked!");
                handler.clickHandSlot(0, playerA);

            } // Hand button 2:
            else if (mx >= Locations.handX[1] && mx <= Locations.handX[1] + Assets.smallWidth
                    && playerA.getHand().getCards().size() >= 2) {
                System.out.println("Hand slot 2 clicked!");
                handler.clickHandSlot(1, playerA);

            } // Hand button 3:
            else if (mx >= Locations.handX[2] && mx <= Locations.handX[2] + Assets.smallWidth
                    && playerA.getHand().getCards().size() >= 3) {
                System.out.println("Hand slot 3 clicked!");
                handler.clickHandSlot(2, playerA);

            } // Hand button 4:
            else if (mx >= Locations.handX[3] && mx <= Locations.handX[3] + Assets.smallWidth
                    && playerA.getHand().getCards().size() >= 4) {
                System.out.println("Hand slot 4 clicked!");
                handler.clickHandSlot(3, playerA);

            } // Hand button 5:
            else if (mx >= Locations.handX[4] && mx <= Locations.handX[4] + Assets.smallWidth
                    && playerA.getHand().getCards().size() >= 5) {
                System.out.println("Hand slot 5 clicked!");
                handler.clickHandSlot(4, playerA);

            } // Hand button 6:
            else if (mx >= Locations.handX[5] && mx <= Locations.handX[5] + Assets.smallWidth
                    && playerA.getHand().getCards().size() >= 6) {
                System.out.println("Hand slot 6 clicked!");
                handler.clickHandSlot(5, playerA);

            } // Hand button 7:
            else if (mx >= Locations.handX[6] && mx <= Locations.handX[6] + Assets.smallWidth
                    && playerA.getHand().getCards().size() >= 7) {
                System.out.println("Hand slot 7 clicked!");
                handler.clickHandSlot(6, playerA);

            } // Hand button 8:
            else if (mx >= Locations.handX[7] && mx <= Locations.handX[7] + Assets.smallWidth
                    && playerA.getHand().getCards().size() >= 8) {
                System.out.println("Hand slot 8 clicked!");
                handler.clickHandSlot(7, playerA);

            } // Hand button 9:
            else if (mx >= Locations.handX[8] && mx <= Locations.handX[8] + Assets.smallWidth
                    && playerA.getHand().getCards().size() >= 9) {
                System.out.println("Hand slot 9 clicked!");
                handler.clickHandSlot(8, playerA);

            } // Hand button 10:
            else if (mx >= Locations.handX[9] && mx <= Locations.handX[9] + Assets.smallWidth
                    && playerA.getHand().getCards().size() >= 10) {
                System.out.println("Hand slot 10 clicked!");
                handler.clickHandSlot(9, playerA);

            } // Between or sides of hand buttons:
            else {
                System.out.println("Clicked between or sides of hand slots!");
                handler.clearChosen();
            }

        } */// Player clicks anywhere else:
        
        
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
