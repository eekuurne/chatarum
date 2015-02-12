package states;

import graphics.Assets;
import java.awt.Graphics;

/**
 *
 * @author Eero
 */
public class GameState extends State {

    public GameState() {
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.swordman, 250, 300, null);
    }
    
}
