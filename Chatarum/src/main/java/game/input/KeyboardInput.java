package game.input;

import cards.Card;
import game.assets.Assets;
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
            if (Assets.scale >= 0.8) {
                Assets.scale -= 0.05;
                Assets.scale(Assets.scale);
                ui.getHandler().updateCardPositions();
                ui.repaint();
            }

        } // W:
        else if (ke.getKeyCode() == KeyEvent.VK_W) {
            ui.getHandler().getPlayer1().getTable().getMinions()[1].clickInTable(ui.getHandler(), 1);
        } // E: 
        else if (ke.getKeyCode() == KeyEvent.VK_E) {
            if (Assets.scale <= 1) {
                Assets.scale += 0.05;
                Assets.scale(2 - Assets.scale);
                ui.getHandler().updateCardPositions();
                ui.repaint();
            }
        } // A: 
        else if (ke.getKeyCode() == KeyEvent.VK_A) {
            ui.getHandler().getPlayer1().getTable().getMinions()[3].clickInTable(ui.getHandler(), 3);
        } // S:
        else if (ke.getKeyCode() == KeyEvent.VK_S) {
            ui.getHandler().getPlayer1().getTable().getMinions()[4].clickInTable(ui.getHandler(), 4);
        } // D:
        else if (ke.getKeyCode() == KeyEvent.VK_D) {
            ui.getHandler().getPlayer1().getTable().getMinions()[5].clickInTable(ui.getHandler(), 5);
        } // Z:
        else if (ke.getKeyCode() == KeyEvent.VK_Z) {
            ui.getHandler().getPlayer1().getTable().getMinions()[6].clickInTable(ui.getHandler(), 6);
        } // X: 
        else if (ke.getKeyCode() == KeyEvent.VK_X) {
            ui.getHandler().getPlayer1().getTable().getMinions()[7].clickInTable(ui.getHandler(), 7);
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
