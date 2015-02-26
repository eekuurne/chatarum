package game.ui;

import cards.Minion;
import game.assets.Assets;
import game.logic.LogicHandler;
import game.logic.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Eero Kuurne
 */
public class UserInterface extends JPanel {

    private LogicHandler handler;

    public UserInterface() {
        super.setBackground(Color.WHITE);

        this.handler = new LogicHandler(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        paintBackgroundObjects(g);
        paintTurn(g);

        handler.getPlayer1().paintComponent(g, 1, handler.getTurn());
        handler.getPlayer2().paintComponent(g, 2, handler.getTurn());

        paintProtected(g, handler.getPlayer1());
        paintProtected(g, handler.getPlayer2());
        paintMinionTurnsLeft(g, handler.getPlayer1());
        paintMinionTurnsLeft(g, handler.getPlayer2());
        paintHealthLosses(g, handler.getPlayer1());
        paintHealthLosses(g, handler.getPlayer2());
    }

    private void paintBackgroundObjects(Graphics g) {
        g.drawImage(Assets.background, 0, 0, null);
        g.drawImage(Assets.tableSlots, Locations.tableSlotsX, Locations.tableSlotsY, null);
        g.drawImage(Assets.endTurn, Locations.endTurnX, Locations.endTurnY, null);
    }

    private void paintTurn(Graphics g) {
        Font font = new Font("Segoe Script", Font.PLAIN, Assets.turnTextFont);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("" + handler.getTurn(), Locations.turnNumberX, Locations.turnNumberY);
    }

    public LogicHandler getHandler() {
        return handler;
    }

    private void paintProtected(Graphics g, Player player) {
        ArrayList<Integer> guardians = handler.checkGuardians(player);

        for (int i = 0; i < guardians.size(); i++) {
            // Paint minions left to guardians.
            if (player.getTable().getMinions()[guardians.get(i) - 1] != null) {
                g.drawImage(Assets.guardianIcon,
                        player.getTable().getMinions()[guardians.get(i) - 1].getX() + Locations.protectedX,
                        player.getTable().getMinions()[guardians.get(i) - 1].getY() + Locations.protectedY, null);
            } // Paint minions right to guardians.
            if (player.getTable().getMinions()[guardians.get(i) + 1] != null) {
                g.drawImage(Assets.guardianIcon,
                        player.getTable().getMinions()[guardians.get(i) + 1].getX() + Locations.protectedX,
                        player.getTable().getMinions()[guardians.get(i) + 1].getY() + Locations.protectedY, null);
            }
        }
    }

    private void paintMinionTurnsLeft(Graphics g, Player player) {
        for (int i = 0; i < 8; i++) {
            // Paint minions left to guardians.
            if (player.getTable().getMinions()[i] != null
                    && player.getTable().getMinions()[i].getTurnleft()) {

                g.drawImage(Assets.turnLeftIcon,
                        player.getTable().getMinions()[i].getX() + Assets.smallWidth - Locations.turnLeftX,
                        player.getTable().getMinions()[i].getY() + Locations.turnLeftY, null);
            }
        }
    }

    private void paintHealthLosses(Graphics g, Player player) {
        Minion minion;
        int healthLost;
        for (int i = 0; i < 8; i++) {
            if (player.getTable().getMinions()[i] != null) {
                minion = player.getTable().getMinions()[i];
                healthLost = minion.getMaxHealth() - minion.getHealth();
                if (healthLost != 0) {
                    Font font = new Font("Segoe Script", Font.PLAIN, Assets.healthLostFont);
                    g.setFont(font);
                    g.setColor(Color.red);
                    g.drawString("-" + healthLost, minion.getX() + Assets.smallWidth - Locations.damageTakenX,
                            minion.getY() + Assets.smallHeight - Locations.damageTakenY);
                }
            }
        }
    }
}