package ludus.chatarum;

import cards.Minion;
import game.logic.Deck;

public class App {

    public static void main(String[] args) {
        
        Deck deck = new Deck();

        for (int i = 0; i < 10; i++) {
            deck.addCard(new Minion(1, 2, 2, "Puppet Master"));
        }
        
        
    }
}
