package testing;

import cards.Minion;
import game.logic.Deck;

public class Test {

    public static void main(String[] args) {

        Deck deck = new Deck();

        deck.addCard(new Minion(1, 2, 2, "Puppet Master", 15));
        deck.addCard(new Minion(1, 2, 2, "Puppa", 15));
        System.out.println(deck.takeCard().getName());

    }
}
