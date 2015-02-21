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
import graphics.Locations;
import java.awt.Color;
import java.awt.Font;
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
     * that need to be updated realtime (within the 30fps game loop).
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
        renderBackground(g);
        renderTurn(g);

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
    
    private void mouse() {
        
    }

    private void renderBackground(Graphics g) {
        g.drawImage(Assets.background, 0, 0, null);
        g.drawImage(Assets.tableSlots, Locations.tableSlotsX, Locations.tableSlotsY, null);
        g.drawImage(Assets.endTurn, Locations.endTurnX, Locations.endTurnY, null);
    }

    private void renderTurn(Graphics g) {
        Font font = new Font("Segoe Script", Font.PLAIN, 48);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("" + turn, 1800, 555);
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
