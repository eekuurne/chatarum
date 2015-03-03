
package cards.containers;

import cards.containers.Deck;
import cards.*;
import cards.minions.Archer;
import cards.minions.Militia;
import cards.minions.Peasant;
import cards.minions.PuppetMaster;
import cards.minions.Raider;
import cards.minions.Swordman;
import cards.minions.Watchman;
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
    public void getRemainingRight() {
        Deck deck = new Deck();

        deck.addCard(new Swordman());
        deck.addCard(new Swordman());
        
        assertEquals(2, deck.getRemaining());
    }
    
    @Test
    public void getRemainingZero() {
        Deck deck = new Deck();

        assertEquals(0, deck.getRemaining());
    }
    
    @Test
    public void addSingleCard() {
        Deck deck = new Deck();
        
        deck.addCard(new Swordman());
 
        assertEquals(1, deck.getRemaining());
    }
    
    @Test
    public void addTooManySameCards() {
        Deck deck = new Deck();

        for (int i = 0; i < 10; i++) {
            deck.addCard(new Swordman());
        }
        
        assertEquals(deck.getMaxSingle(), deck.getRemaining());
    }
    
    @Test
    public void addTooManyCards() {
        Deck deck = new Deck();

        for (int i = 0; i < 10; i++) {
            deck.addCard(new Swordman());
            deck.addCard(new Archer());
            deck.addCard(new Militia());
            deck.addCard(new Peasant());
            deck.addCard(new Raider());
            deck.addCard(new Watchman());
        }
        
        assertEquals(deck.getMaxSize(), deck.getRemaining());
    }
    
    @Test
    public void takeCardSizeRight() {
        Deck deck = new Deck();
        
        deck.addCard(new Swordman());
        deck.addCard(new Swordman());
        
        Card card = deck.takeCard();
        
        assertEquals(1, deck.getRemaining());
    }
    
    @Test
    public void takeCardSizeZero() {
        Deck deck = new Deck();
        
        deck.addCard(new Swordman());
        
        Card card = deck.takeCard();
        
        assertEquals(0, deck.getRemaining());
    }
    
    @Test
    public void takeCardFromEmptyDeck() {
        Deck deck = new Deck();

        Card card = deck.takeCard();
        
        assertEquals(0, deck.getRemaining());
        assertEquals("Militia", card.getName());
    }
    
    @Test
    public void takeCardReturnRight() {
        Deck deck = new Deck();
        
        deck.addCard(new Swordman());
        Card card = deck.takeCard();
        
        assertEquals("Swordman", card.getName());
    }
}
