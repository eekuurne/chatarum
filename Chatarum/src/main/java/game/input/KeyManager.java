package game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyListener class for all keyboard input. The only key will probably be
 * esc, which currently closes the game, but opens a menu in later iteration.
 *
 * @author Eero
 */
public class KeyManager implements KeyListener {

    private boolean[] keys;
    
    public boolean esc; // Hotkey for closing the game. Later for ingame menu.
    public boolean q; // Hotkey for test use.
    
    public KeyManager() {
        keys = new boolean[256];
    }
    
    public void tick() {
        esc = keys[KeyEvent.VK_ESCAPE];
        q = keys[KeyEvent.VK_Q];
    }
    
    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
