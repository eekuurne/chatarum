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

    private UserInterface ui; // In case it is needed for testing with keys.

    public KeyboardInput(UserInterface component) {
        this.ui = component;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        // ESC: Close the program.
        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
