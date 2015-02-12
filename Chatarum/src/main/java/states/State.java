package states;

import java.awt.Graphics;

/**
 *
 * @author Eero
 */
public abstract class State {

    private static State currentState = null;
    
    public static State getState() {
        return currentState;
    }
    
    public static void setState(State state) {
        currentState = state;
    }

    // For the specified states:
    public abstract void tick();
    public abstract void render(Graphics g);

}
