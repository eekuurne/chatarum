package game.logic;

import cards.containers.Deck;
import cards.minions.Archer;
import cards.minions.Assassin;
import cards.minions.Axethrower;
import cards.minions.Militia;
import cards.minions.Moonblade;
import cards.minions.Peasant;
import cards.minions.PuppetMaster;
import cards.minions.Raider;
import cards.minions.Swordman;
import cards.minions.VoodooPriest;
import cards.minions.Watchman;
import cards.spells.RainOfFire;

/**
 * Temporary class for making the decks for gameplay programming tests. In final
 * version the decks will be built and saved to file using the deck builder in
 * the menu and then loaded from the file to the match.
 *
 * @author Eero
 */
public class DeckBuilder {

    private Deck deck1;
    private Deck deck2;

    public DeckBuilder() {
        deck1 = new Deck();
        deck2 = new Deck();

        init();
    }

    /**
     * Builds 2 decks for test usage.
     *
     */
    public void init() {
        for (int i = 0; i < 5; i++) {
            deck1.addCard(new RainOfFire());
            deck1.addCard(new RainOfFire());
            deck1.addCard(new RainOfFire());
            deck1.addCard(new Swordman());
            deck1.addCard(new Archer());
            deck1.addCard(new Militia());
            deck1.addCard(new Peasant());
            deck1.addCard(new Raider());
            deck1.addCard(new Watchman());
            deck1.addCard(new PuppetMaster());
            deck1.addCard(new Axethrower());
            deck1.addCard(new Assassin());
            deck1.addCard(new VoodooPriest());
            deck1.addCard(new Moonblade());
        }

        for (int i = 0; i < 5; i++) {
            deck2.addCard(new Swordman());
            deck2.addCard(new Archer());
            deck2.addCard(new Militia());
            deck2.addCard(new Peasant());
            deck2.addCard(new Raider());
            deck2.addCard(new Watchman());
            deck2.addCard(new PuppetMaster());
            deck2.addCard(new Axethrower());
            deck2.addCard(new Assassin());
            deck2.addCard(new VoodooPriest());
            deck2.addCard(new Moonblade());
        }
    }

    public Deck getDeck1() {
        return deck1;
    }

    public Deck getDeck2() {
        return deck2;
    }
}
