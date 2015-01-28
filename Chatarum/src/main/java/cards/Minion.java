package cards;

public class Minion implements Card {

    private int damage;
    private int health;
    private int faction;
    private String name;

    public Minion(int damage, int health, int faction, String name) {
        this.damage = damage;
        this.health = health;
        this.faction = faction;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public int getFaction() {
        return faction;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int takeDamage(int amount) {
        health -= amount;
        return health;
    }

    @Override
    public void playCard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
