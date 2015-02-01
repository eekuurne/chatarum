
package game.logic;

public class Player {
    
    private Deck deck;
    private Hand hand;
    private Table table;
    private Hero hero;
    private int health;

    public Player(Deck deck, Hero hero) {
        this.deck = deck;
        this.hand = new Hand();
        this.table = new Table();
        this.hero = hero;
        this.health = 30;
    }

    
    
    
    
    
}
