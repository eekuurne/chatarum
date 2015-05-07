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
            System.out.println("AdvancedAI vs. AdvancedAI: ");
            AITester tester = new AITester(player1AI, player2AI);
            tester.runTests(5000000);
            
            System.out.println("AdvancedAI vs. SimpleAI: ");
            player2AI = new SimpleAI(null, null, null);
            tester = new AITester(player1AI, player2AI);
            tester.runTests(5000000);
            
            System.out.println("MediumAI vs. MediumAI: ");
            player2AI = new MediumAI(null, null, null);
            tester = new AITester(player1AI, player2AI);
            tester.runTests(5000000);
            
        } else {
            Game ui = new Game("Chatarum", 1280, 720, false, player1AI, player2AI);
            SwingUtilities.invokeLater(ui);
        }
    }
}
