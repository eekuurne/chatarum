
package game.logic;

import cards.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {
    
    public DeckTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addSingleCard() {
        Deck deck = new Deck();
        
        deck.addCard(new Minion(1, 2, 2, "Puppet Master"));
 
        assertEquals(1, deck.getCards().size());
        assertEquals(2, deck.getCards().get(0).getFaction());
    }
    
    @Test
    public void addTooManySameCards() {
        Deck deck = new Deck();

        for (int i = 0; i < 10; i++) {
            deck.addCard(new Minion(1, 2, 2, "Puppet Master"));
        }
        
        assertEquals(deck.getMaxSingle(), deck.getCards().size());
    }
    
    @Test
    public void addTooManyCards() {
        Deck deck = new Deck();

        for (int i = 0; i < 10; i++) {
            deck.addCard(new Minion(1, 2, 2, "Puppet Master"));
            deck.addCard(new Minion(1, 2, 2, "Shadowcat"));
            deck.addCard(new Minion(1, 2, 2, "Bounty Hunter"));
            deck.addCard(new Minion(1, 2, 2, "Paladin"));
            deck.addCard(new Minion(1, 2, 2, "Moonblade"));
            deck.addCard(new Minion(1, 2, 2, "Berserker"));
            deck.addCard(new Minion(1, 2, 2, "Plague Monk"));
        }
        
        assertEquals(deck.getMaxSize(), deck.getCards().size());
    }
    
    @Test
    public void takeSingleCardSizeRight() {
        Deck deck = new Deck();
        
        deck.addCard(new Minion(1, 2, 2, "Paladin"));
        deck.addCard(new Minion(1, 2, 2, "Berserker"));
        
        Card card = deck.takeCard();
        
        assertEquals(1, deck.getCards().size());
    }

}
