package game;

import javax.swing.SwingUtilities;

/**
 *
 * @author Eero Kuurne
 */
public class Launcher {

    public static void main(String[] args) {
        
        // Add parameter to game which determines which players are using AI
        
        Game ui = new Game("Chatarum", 1920, 1080, true);
        SwingUtilities.invokeLater(ui);
    }
}
