package game.input;

import cards.Card;
import game.logic.LogicHandler;
import game.ui.UserInterface;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Eero Kuurne
 */
public class KeyboardInput implements KeyListener {

    private UserInterface ui;

    public KeyboardInput(UserInterface component) {
        this.ui = component;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        // ESC: Close the program.
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        } // Q: 
        else if (ke.getKeyCode() == KeyEvent.VK_Q) {
            ui.getHandler().getPlayer1().changeRemainingInfluence(-1);
        } // W:
        else if (ke.getKeyCode() == KeyEvent.VK_W) {
            ui.getHandler().getPlayer1().changeRemainingInfluence(1);
        } // E: 
        else if (ke.getKeyCode() == KeyEvent.VK_E) {
            ui.getHandler().getPlayer1().changeRemainingResources(-5);
        } // A: 
        else if (ke.getKeyCode() == KeyEvent.VK_A) {
            ui.getHandler().getPlayer1().changeRemainingResources(5);
        } // S:
        else if (ke.getKeyCode() == KeyEvent.VK_S) {
            ui.getHandler().getPlayer2().changeRemainingInfluence(-1);
        } // D:
        else if (ke.getKeyCode() == KeyEvent.VK_D) {
            ui.getHandler().getPlayer2().changeRemainingInfluence(1);
        } // Z:
        else if (ke.getKeyCode() == KeyEvent.VK_Z) {
            ui.getHandler().getPlayer2().changeRemainingResources(-5);
        } // X: 
        else if (ke.getKeyCode() == KeyEvent.VK_X) {
            ui.getHandler().getPlayer2().changeRemainingResources(5);
        }
        
        ui.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
