import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Entity {
    protected int level;
    protected String type;
    protected String name;
    protected int health;
    protected int attack;
    protected int coins = 50;
    protected int defence;
    protected int hunger = 0;
    protected int thirst = 0;
    protected int xp;
    protected HashMap<String, InventorySlot> inventory = new HashMap<>();

    public Entity(String type, String name, int health, int attack, int defence, int level){
        this.type = type;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
        this.level = level;
    }

    public void addToInventory(Item item, int amount){
        InventorySlot currentSlot = new InventorySlot(item, amount);
        inventory.put(item.getItemName(), currentSlot);
    }

    public void removeFromInventory(Item item, int amount){
        if (!inventory.containsKey(item.getItemName())){
            return;
        }
        InventorySlot slot = inventory.get(item.getItemName());
        int newValue = slot.getAmount() - amount;
        InventorySlot updatedSlot = new InventorySlot(item, newValue);
        inventory.put(item.getItemName(), updatedSlot);
    }

    public static String createRandomName() {
        ArrayList<String> namesList = new ArrayList<>();
        namesList.add("Peter");
        namesList.add("John");
        namesList.add("Matthew");
        namesList.add("Paul");
        Random rand = new Random();
        int randomise = rand.nextInt(namesList.size());
        return namesList.get(randomise);
    }

    public HashMap<String, InventorySlot> getInventory() {
        return inventory;
    }

    public String getType() {
        return type;
    }

    public int getCoins() {
        return coins;
    }

    /**
     * This will update the coins based on what's passed through as a parameter
     * @param coins This will be a positive or negative number
     */
    public void updateCoins(int coins) {
        this.coins += coins;
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

    public void setHealth(int health){
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }
    public int getDefence(){ return  defence; }

    public int getLevel(){
        return level;
    }

}