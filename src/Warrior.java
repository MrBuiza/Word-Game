public class Warrior extends Entity {


    public Warrior(String name, int health, int attack){
        super(name, health, attack);
    }
    @Override
    public String toString() {
        return "I am a warrior";
    }
}