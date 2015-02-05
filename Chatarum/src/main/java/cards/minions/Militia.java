
package cards.minions;

import cards.Minion;

/**
 * Simple warrior minion, which can be drawn from an empty deck or converted 
 * from the cheapest worker or gained with some Skills.
 * 
 * @author Eero Kuurne
 */
public class Militia extends Minion {
    
    public Militia() {
        super(1, 1, 0, "Militia", 10, false, false, false, 0);
    }
}