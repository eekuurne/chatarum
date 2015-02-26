package game;

import javax.swing.SwingUtilities;

/**
 *
 * @author Eero Kuurne
 */
public class Launcher {

    public static void main(String[] args) {
        // 1920x1080 (1)
        // 1440x810 (0.75)
        // 1280x720 (0.66)
        // 960x540 (0.5)
        Game ui = new Game("Chatarum", 1280, 720, false);
        SwingUtilities.invokeLater(ui);
    }
}
