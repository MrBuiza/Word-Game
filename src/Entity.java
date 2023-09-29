import java.util.HashMap;

public class Entity {
    protected String type;
    protected String name;
    protected int health;
    protected int attack;
    protected int coins = 50;
    protected HashMap<Item, Integer> inventory = new HashMap<>();

    public Entity(String type, String name, int health, int attack){
        this.type = type;
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public void addToInventory(Item item, int amount){
        for (int i = 0; i <amount; i++) {
            inventory.put(item, amount);
        }
    }

    public HashMap<Item, Integer> getInventory() {
        return inventory;
    }

    public String getType() {
        return type;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

}