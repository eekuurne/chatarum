package game;

import javax.swing.SwingUtilities;

/**
 *
 * @author Eero Kuurne
 */
public class Launcher {

    public static void main(String[] args) {
        Game ui = new Game("Chatarum", 1920, 1080);
        SwingUtilities.invokeLater(ui);
    }
}
