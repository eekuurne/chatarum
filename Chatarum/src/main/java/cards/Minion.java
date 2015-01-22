package cards;

public class Minion {

    private int damage;
    private int health;
    private int faction;

    public Minion(int damage, int health, int faction) {
        this.damage = damage;
        this.health = health;
        this.faction = faction;
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
    
    public int takeDamage(int amount) {
        return health - amount;
    }
}
