package cards;

import java.awt.image.BufferedImage;

/**
 * Interface for cards to allow Skill and Minion cards to be stored to the same
 * lists.
 *
 * @author Eero Kuurne
 */
public interface Card {

    String getName();

    /**
     * Change the x coordinate of the card.
     *
     */
    void setX(float x);

    /**
     * Change the y coordinate of the card.
     *
     */
    void setY(float y);

    /**
     * Get the zoomed picture of a card to help reading it.
     *
     * @return bigPic of the card.
     */
    BufferedImage getBigPic();

    // What happens when the card is played from hand.
    void playCard();

}
