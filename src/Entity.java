import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class Entity {
    protected int level;
    protected String type;
    protected String name;
    protected int health;
    protected int attack;
    protected int coins = 50;
    protected int defence;
    protected int hunger = 0;
    protected int thirst = 0;
    private int playerXP = 0;
    private Inventory inventory = new Inventory();

    public Entity(String type, String name, int health, int attack, int defence, int level){
        this.type = type;
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
        this.level = level;
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

    public void gainXP(int eventXp) {
        while (eventXp >= 100) {
            level++;
            eventXp -= 100;
        }
        playerXP += eventXp;
    }

    public void getState(int health){
        if (health >= 80){
            System.out.println("You are healthy, no need for medical attention.");
        } else if (health <= 79 && health >=50) {
            System.out.println("You are injured, minor medical attention is advised.");
        }
        else if(health <= 49 && health >0){
            System.out.println("You are severely wounded, imminent death is likely. Medical attention is STRONGLY advised.");
        }
        else{
            System.out.println("YOU DIED.");
        }
    }

    public Inventory useInventory() {
        return inventory;
    }

    public HashMap<String, InventorySlot> getInventory() {
        return inventory.getInventory();
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
    public int getDefence(){
        return  defence;
    }
    public int getLevel(){
        return level;
    }
}