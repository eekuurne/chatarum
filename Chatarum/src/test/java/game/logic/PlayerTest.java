/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.logic;

import cards.Card;
import cards.containers.Deck;
import cards.minions.Archer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eero
 */
public class PlayerTest {
    
    public PlayerTest() {
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
    public void remainingInfluenceChangesRight() {
        Player player = new Player(new Deck(), 1);
        
        player.changeRemainingInfluence(-5);
        
        assertEquals(player.getMaxInfluence() - 5, player.getRemainingInfluence());
    }
    
    @Test
    public void remainingInfluenceDoesntGoNegative() {
        Player player = new Player(new Deck(), 1);
        
        player.changeRemainingInfluence(-player.getMaxInfluence() - 5);
        
        assertEquals(0, player.getRemainingInfluence());
    }
    
    @Test
    public void remainingInfluenceDoesntGoOverCap() {
        Player player = new Player(new Deck(), 1);
        
        player.changeRemainingInfluence(-10);
        player.changeRemainingInfluence(20);
        
        assertEquals(player.getMaxInfluence(), player.getRemainingInfluence());
    }
    
    @Test
    public void maxResourcesChangesRight() {
        Player player = new Player(new Deck(), 1);
        
        player.changeMaxResources(10);
        
        assertEquals(10, player.getMaxResources());
    }
    
    @Test
    public void maxResourcesDoesntGoNegative() {
        Player player = new Player(new Deck(), 1);
        
        player.changeMaxResources(-200);
        
        assertEquals(0, player.getMaxResources());
    }
    
    @Test
    public void maxResourcesDoesntGoOverCap() {
        Player player = new Player(new Deck(), 1);
        
        player.changeMaxResources(200);
        
        assertEquals(100, player.getMaxResources());
    }
    
    @Test
    public void maxTurnResourcesChangesRight() {
        Player player = new Player(new Deck(), 1);
        
        player.changeMaxTurnResources(10);
        
        assertEquals(10, player.getMaxTurnResources());
    }
    
    @Test
    public void maxTurnResourcesDoesntGoNegative() {
        Player player = new Player(new Deck(), 1);
        
        player.changeMaxTurnResources(-200);
        
        assertEquals(0, player.getMaxTurnResources());
    }
    
    @Test
    public void maxTurnResourcesDoesntGoOverCap() {
        Player player = new Player(new Deck(), 1);
        
        player.changeMaxTurnResources(200);
        
        assertEquals(80, player.getMaxTurnResources());
    }
    
    @Test
    public void remainingResourcesChangesRight() {
        Player player = new Player(new Deck(), 1);

        player.changeMaxResources(20);
        player.changeRemainingResources(10);
        
        assertEquals(10, player.getRemainingResources());
    }
    
    @Test
    public void remainingResourcesDoesntGoNegative() {
        Player player = new Player(new Deck(), 1);
        
        player.changeMaxResources(20);
        player.changeRemainingResources(20);
        player.changeRemainingResources(-50);
        
        assertEquals(0, player.getRemainingResources());
    }
    
    @Test
    public void remainingResourcesDoesntGoOverCap() {
        Player player = new Player(new Deck(), 1);
        
        player.changeMaxResources(20);
        player.changeRemainingResources(30);
        
        assertEquals(20, player.getRemainingResources());
    }
    
    @Test
    public void getTableSizeWorksWithZero() {
        Player player = new Player(new Deck(), 1);
        assertEquals(0, player.getTableSize());
    }
    
    @Test
    public void getTableSizeWorks() {
        Player player = new Player(new Deck(), 1);
        
        player.getTable().insertMinion(new Archer(), 1);
        player.getTable().insertMinion(new Archer(), 3);
        
        assertEquals(2, player.getTableSize());
    }
    
    @Test
    public void getTableSizeWorksWithFull() {
        Player player = new Player(new Deck(), 1);
        
        for (int i = 0; i < 8; i++) {
            player.getTable().insertMinion(new Archer(), i);
        }
        
        assertEquals(8, player.getTableSize());
    }
}
