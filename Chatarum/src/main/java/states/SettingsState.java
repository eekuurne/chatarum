package states;

import game.Game;
import java.awt.Graphics;

/**
 * State for the settings menu. Not supported yet.
 *
 * @author Eero
 */
public class SettingsState extends State {

    public SettingsState(Game game) {
        super(game);
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
