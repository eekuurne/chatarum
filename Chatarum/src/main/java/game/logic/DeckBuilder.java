package game.logic;

import cards.containers.Deck;
import cards.minions.Archer;
import cards.minions.Militia;
import cards.minions.Peasant;
import cards.minions.Raider;
import cards.minions.Swordman;
import cards.minions.Watchman;

/**
 * Temporary class for making the decks for gameplay programming tests.
 *
 * @author Eero
 */
public class DeckBuilder {
    
    private Deck deck1;
    private Deck deck2;

    public DeckBuilder() {
        deck1 = new Deck(1);
        deck2 = new Deck(2);
        
        init();
    }
    
    public void init() {
        for (int i = 0; i < 4; i++) {
            deck1.addCard(new Swordman());
            deck1.addCard(new Archer());
            deck1.addCard(new Militia());
            deck1.addCard(new Peasant());
            deck1.addCard(new Raider());
            deck1.addCard(new Watchman());
        }
        
        for (int i = 0; i < 4; i++) {
            deck2.addCard(new Swordman());
            deck2.addCard(new Archer());
            deck2.addCard(new Militia());
            deck2.addCard(new Peasant());
            deck2.addCard(new Raider());
            deck2.addCard(new Watchman());
        }
    }

    public Deck getDeck1() {
        return deck1;
    }

    public Deck getDeck2() {
        return deck2;
    }
    
    
}
