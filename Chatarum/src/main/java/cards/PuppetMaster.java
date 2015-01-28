
package cards;

public class PuppetMaster extends Minion implements Card {

    public PuppetMaster() {
        super(3, 5, 1, "Puppet Master");
    }

    @Override
    public void playCard() {
        // Takes control of a random enemy minion
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
