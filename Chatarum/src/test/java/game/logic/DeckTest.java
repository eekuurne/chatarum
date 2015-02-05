
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
    public void getRemainingRight() {
        Deck deck = new Deck();

        deck.addCard(new Minion(1, 2, 2, "Paladin", 15, false, false, false , 0));
        deck.addCard(new Minion(1, 2, 2, "Berserker", 15, false, false, false , 0));
        
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
        
        deck.addCard(new Minion(1, 2, 2, "Puppet Master", 15, false, false, false , 0));
 
        assertEquals(1, deck.getRemaining());
        assertEquals(2, deck.getCards().get(0).getFaction());
    }
    
    @Test
    public void addTooManySameCards() {
        Deck deck = new Deck();

        for (int i = 0; i < 10; i++) {
            deck.addCard(new Minion(1, 2, 2, "Puppet Master", 15, false, false, false , 0));
        }
        
        assertEquals(deck.getMaxSingle(), deck.getRemaining());
    }
    
    @Test
    public void addTooManyCards() {
        Deck deck = new Deck();

        for (int i = 0; i < 10; i++) {
            deck.addCard(new Minion(1, 2, 2, "Puppet Master", 15, false, false, false , 0));
            deck.addCard(new Minion(1, 2, 2, "Shadowcat", 15, false, false, false , 0));
            deck.addCard(new Minion(1, 2, 2, "Bounty Hunter", 15, false, false, false , 0));
            deck.addCard(new Minion(1, 2, 2, "Paladin", 15, false, false, false , 0));
            deck.addCard(new Minion(1, 2, 2, "Moonblade", 15, false, false, false , 0));
            deck.addCard(new Minion(1, 2, 2, "Berserker", 15, false, false, false , 0));
            deck.addCard(new Minion(1, 2, 2, "Plague Monk", 15, false, false, false , 0));
        }
        
        assertEquals(deck.getMaxSize(), deck.getRemaining());
    }
    
    @Test
    public void takeCardSizeRight() {
        Deck deck = new Deck();
        
        deck.addCard(new Minion(1, 2, 2, "Paladin", 15, false, false, false , 0));
        deck.addCard(new Minion(1, 2, 2, "Berserker", 15, false, false, false , 0));
        
        Card card = deck.takeCard();
        
        assertEquals(1, deck.getRemaining());
    }
    
    @Test
    public void takeCardSizeZero() {
        Deck deck = new Deck();
        
        deck.addCard(new Minion(1, 2, 2, "Paladin", 15, false, false, false , 0));
        
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
    
    

}
