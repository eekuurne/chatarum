package states;

import game.Game;
import java.awt.Graphics;

/**
 * Abstract class for states.
 *
 * @author Eero
 */
public abstract class State {

    private static State currentState = null;
    protected Game game;

    public State(Game game) {
        this.game = game;
    }

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
