package game;

/**
 * The class for main method and launching the game.
 *
 * @author Eero
 */
public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("Chatarum", 1920, 1080);
        game.start();
    }
}
