package states;

import cards.minions.Swordman;
import graphics.Assets;
import java.awt.Graphics;

/**
 * The state while playing a match.
 *
 * @author Eero
 */
public class GameState extends State {

    private Swordman pekka; // just testing...
    
    public GameState() {
        pekka = new Swordman();
        pekka.setX(155);
        pekka.setY(125);
    }

    @Override
    public void tick() {
        
    }

    /**
     * Method for rendering what happens in the game board.
     *
     * @param g The graphics drawing variable.
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0, 0, null);
        
        pekka.render(g);
    }
    
}
