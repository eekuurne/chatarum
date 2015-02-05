
package cards;

/**
 * Interface for cards to allow Skill and Minion cards to be stored to the
 * same lists.
 * 
 * @author Eero Kuurne
 */
public interface Card {
    
    String getName();
    
    int getFaction();
    int getCost();
    
    // What happens when the card is played from hand.
    void playCard();
    
}
