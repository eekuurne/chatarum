package game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyListener class for all keyboard input. The only key will probably be
 * esc, which currently closes the game, but opens a menu in later iteration.
 * 
 * Q-key changes turn atm. It should be changed to single press though, changes
 * 60 turns per second when pressed.
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
    
    /**
     * Defines what keys can be used as key events and ticked.
     * 
     */
    public void tick() {
        esc = keys[KeyEvent.VK_ESCAPE];
        q = keys[KeyEvent.VK_Q];
    }
    
    /**
     * Sets the key of the parameter's key event to true ("pressed down").
     * 
     * @param ke Key event.
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    /**
     * Sets the key of the parameter's key event to false ("not pressed down").
     * 
     * @param ke Key event.
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
    }

    /**
     * (Will work on this later)
     * 
     */
    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
