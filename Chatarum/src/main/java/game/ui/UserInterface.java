package game.ui;

import game.assets.Assets;
import game.logic.LogicHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Eero Kuurne
 */
public class UserInterface extends JPanel {

    private LogicHandler handler;
    
    public UserInterface() {
        super.setBackground(Color.WHITE);
        
        this.handler = new LogicHandler();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        paintBackgroundObjects(g);
        paintTurn(g);
        handler.getPlayer1().paintComponent(g, 1, handler.getTurn());
        handler.getPlayer2().paintComponent(g, 2, handler.getTurn());
    }
    
    private void paintBackgroundObjects(Graphics g) {
        g.drawImage(Assets.background, 0, 0, null);
        g.drawImage(Assets.tableSlots, Locations.tableSlotsX, Locations.tableSlotsY, null);
        g.drawImage(Assets.endTurn, Locations.endTurnX, Locations.endTurnY, null);
    }
    
    private void paintTurn(Graphics g) {
        Font font = new Font("Segoe Script", Font.PLAIN, 48);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("" + handler.getTurn(), Locations.turnNumberX, Locations.turnNumberY);
    }
    
    public LogicHandler getHandler() {
        return handler;
    }
}
