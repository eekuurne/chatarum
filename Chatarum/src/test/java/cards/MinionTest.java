
package cards;

import cards.minions.Swordman;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MinionTest {
    
    public MinionTest() {
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
    public void takeDamageStayAlive() {
        Minion minion = new Swordman();
        minion.takeDamage(1);
        assertEquals(1, minion.getHealth());
    }
    
    @Test
    public void takeDamageGoZero() {
        Minion minion = new Swordman();
        minion.takeDamage(2);
        assertEquals(0, minion.getHealth());
    }
    
    @Test
    public void takeDamageGoNegative() {
        Minion minion = new Swordman();
        minion.takeDamage(3);
        assertEquals(-1, minion.getHealth());
    }
}
