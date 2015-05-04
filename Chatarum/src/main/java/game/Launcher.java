package game;

import game.AI.AI;
import game.AI.AITester;
import game.AI.AdvancedAI;
import game.AI.MediumAI;
import game.AI.SimpleAI;
import game.AI.TestAI;
import javax.swing.SwingUtilities;

/**
 *
 * @author Eero Kuurne
 */
public class Launcher {

    public static void main(String[] args) {

        AI player1AI = null;
        AI player2AI = new AdvancedAI(null, null, null);

        if (false) { // for testing
            AITester tester = new AITester(player1AI, player2AI);
            tester.runTests(10000000);
        } else {
            Game ui = new Game("Chatarum", 1280, 720, false, player1AI, player2AI);
            SwingUtilities.invokeLater(ui);
        }

    }
}
