
package cards.minions;

import cards.Minion;

public class PuppetMaster extends Minion {

    public PuppetMaster() {
        super(3, 5, 1, "Puppet Master", 15);
    }

    @Override
    public void playCard() {
        // Takes control of a random enemy minion
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
