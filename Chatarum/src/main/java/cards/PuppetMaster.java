
package cards;

public class PuppetMaster extends Minion implements Card {

    public PuppetMaster() {
        super(3, 5, 1);
    }

    @Override
    public int getFaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void playCard() {
        // Takes control of a random enemy minion
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
