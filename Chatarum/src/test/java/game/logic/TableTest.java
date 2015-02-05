
package game.logic;

import cards.Minion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TableTest {
    
    public TableTest() {
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
    public void insertMinion() {
        Table table1 = new Table();
        Minion minion = new Minion(1, 3, 1, "Puppet Master", 15, false, false, false , 0);
        table1.insertMinion(minion, 1);
        
        assertEquals(3, table1.chooseMinion(1).getHealth());
    }
    
    /*@Test
    public void minionAttackOneDies() {
        Table table1 = new Table();
        Table table2 = new Table();
        
        Minion attacker = new Minion(1, 3, 1);
        Minion defender = new Minion(5, 6, 2);
        
        table1.insertMinion(attacker, 1);
        table2.insertMinion(defender, 1);
        
        table1.minionAttack(attacker, 1, defender, 1, table2);
        
        //assertEquals(null, table1.chooseMinion(1));
        assertEquals(5, table2.chooseMinion(5).getHealth());
    }*/
}
