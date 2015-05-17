package game;

import game.AI.AI;
import game.AI.AITester;
import game.AI.AdvancedAI;
import game.AI.MediumAI;
import game.AI.SimpleAI;
import game.AI.TestAI;
import javax.swing.SwingUtilities;

/**
 * Launcher is responsible for starting the game. The settings are given in
 * main method's code at the moment, later in user interface.
 *
 * @author Eero Kuurne
 */
public class Launcher {

    public static void main(String[] args) {
        /* 
        If true, the AIs defined below will play against each other. Amount of
        games is given as parameter to runTests. In the end the victories
        are printed to console.
        
        If false, the game starts normally. If both AIs are null, the game
        can be played with 2 players.
        */
        if (false) {
            AI player1AI = new AdvancedAI(null, null, null);
            AI player2AI = new MediumAI(null, null, null);
            AITester tester = new AITester(player1AI, player2AI);
            tester.runTests(1000);
        } else {
            AI player1AI = null;
            AI player2AI = new AdvancedAI(null, null, null);

            Game ui = new Game("Chatarum", 1280, 720, false, player1AI, player2AI);
            SwingUtilities.invokeLater(ui);
        }
    }
}
