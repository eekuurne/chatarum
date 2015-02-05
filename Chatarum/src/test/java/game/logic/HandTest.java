
package game.logic;

import cards.Card;
import cards.Minion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HandTest {
    
    public HandTest() {
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
        Hand hand = new Hand();

        hand.addCard(new Minion(1, 2, 2, "Paladin", 15, false, false, false , 0));
        hand.addCard(new Minion(1, 2, 2, "Berserker", 15, false, false, false , 0));
        
        assertEquals(2, hand.getRemaining());
    }
    
    @Test
    public void getRemainingZero() {
        Hand hand = new Hand();

        assertEquals(0, hand.getRemaining());
    }
    
    @Test
    public void addSingleCard() {
        Hand hand = new Hand();
        
        hand.addCard(new Minion(1, 2, 2, "Puppet Master", 15, false, false, false , 0));
 
        assertEquals(1, hand.getRemaining());
        assertEquals(2, hand.getCards().get(0).getFaction());
    }
    
    @Test
    public void addTooManyCards() {
        Hand hand = new Hand();

        for (int i = 0; i < 10; i++) {
            hand.addCard(new Minion(1, 2, 2, "Puppet Master", 15, false, false, false , 0));
            hand.addCard(new Minion(1, 2, 2, "Shadowcat", 15, false, false, false , 0));
            hand.addCard(new Minion(1, 2, 2, "Bounty Hunter", 15, false, false, false , 0));
        }
        
        assertEquals(hand.getMaxSize(), hand.getRemaining());
    }
    
    @Test
    public void takeCardSizeRight() {
        Hand hand = new Hand();
        
        hand.addCard(new Minion(1, 2, 2, "Paladin", 15, false, false, false , 0));
        hand.addCard(new Minion(1, 2, 2, "Berserker", 15, false, false, false , 0));
        
        Card card = hand.takeCard(0);
        
        assertEquals(1, hand.getRemaining());
    }
    
    @Test
    public void takeCardSizeZero() {
        Hand hand = new Hand();
        
        hand.addCard(new Minion(1, 2, 2, "Paladin", 15, false, false, false , 0));
        
        Card card = hand.takeCard(0);
        
        assertEquals(0, hand.getRemaining());
    }
    
    @Test
    public void takeCardFromEmptyHand() {
        Hand hand = new Hand();

        Card card = hand.takeCard(0);
        
        assertEquals(0, hand.getRemaining());
        assertEquals(null, card);
    }
}
