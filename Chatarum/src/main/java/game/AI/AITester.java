package game.AI;

import game.assets.Assets;
import game.logic.LogicHandler;
import game.ui.Locations;
import game.ui.UserInterface;

/**
 *
 * @author Eero Kuurne
 */
public class AITester {

    private AI player1AI;
    private AI player2AI;

    private LogicHandler handler;

    public AITester(AI player1AI, AI player2AI) {
        this.player1AI = player1AI;
        this.player2AI = player2AI;

        Assets.init(1); // Load and crop images and set dimensions.
        Locations.init(); // Set locations.
        
        this.handler = new LogicHandler(new UserInterface(player1AI, player2AI), player1AI, player2AI);
        handler.setAITesting(true);
    }

    public void runTests(int amount) {
        int player1Wins = 0;
        int player2Wins = 0;

        for (int i = 0; i < amount; i++) {
            this.handler = new LogicHandler(new UserInterface(player1AI, player2AI), player1AI, player2AI);
            handler.setAITesting(true);
            
            while (true) {
                handler.getPlayer1().getAI().playTurn();
                int win = handler.endTurn();
                if (win == 1) {
                    player1Wins++;
                    break;
                } else if (win == 2) {
                    player2Wins++;
                    break;
                }

                handler.startTurn();

                handler.getPlayer2().getAI().playTurn();
                win = handler.endTurn();
                if (win == 1) {
                    player1Wins++;
                    break;
                } else if (win == 2) {
                    player2Wins++;
                    break;
                }

                handler.startTurn();
            }

        }
        System.out.println("Pelaaja 1: " + player1Wins + " voittoa");
        System.out.println("Pelaaja 2: " + player2Wins + " voittoa");
        System.out.println("Pelaajan 1 voitto-häviö-ratio: " + (float) player1Wins / player2Wins);
        System.out.println("Pelaajan 2 voitto-häviö-ratio: " + (float) player2Wins / player1Wins);
        
    }

}
