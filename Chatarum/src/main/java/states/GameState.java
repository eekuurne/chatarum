 package states;

import cards.containers.Deck;
import cards.minions.Archer;
import cards.minions.Militia;
import cards.minions.Peasant;
import cards.minions.Raider;
import cards.minions.Swordman;
import cards.minions.Watchman;
import game.Game;
import game.logic.Controller;
import game.logic.Player;
import graphics.Assets;
import java.awt.Graphics;

/**
 * The state while playing a match.
 *
 * @author Eero
 */
public class GameState extends State {
    
    private Controller controller;
    private int turn;
    
    public GameState(Game game) {
        super(game);
        controller = new Controller(false);
        this.turn = 1;
        
        init();
    }

    /**
     * What happens when tick() is called in game -> all the changes in the game
     * that need to be updated realtime (within the 60fps game loop).
     * 
     * Will be used mainly for input listeners (and animations later).
     *
     */
    @Override
    public void tick() {
        keyBoard();
    }

    /**
     * Method for rendering what happens in the game board.
     *
     * @param g The graphics drawing variable.
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.background, 0, 0, null);
        g.drawImage(Assets.tableSlots, 285, 306, null);
        g.drawImage(Assets.endTurn, 1590, 510, null);
        g.drawString("" + turn, 1850, 530);
        
        
        controller.getPlayer1().render(g, 1, turn);
        controller.getPlayer2().render(g, 2, turn);
    }

    
    /**
     * What happens at the start of the game state (match).
     *
     */
    private void init() {

    }
    
    /**
     * Method for ticking all the hotkeys. Just esc to exit now.
     *
     */
    private void keyBoard() {
        if (game.getKeyManager().esc) {
            System.exit(0);
        }
        if (game.getKeyManager().q) {
            turn++;
        }
    }
}
