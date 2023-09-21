public class Archer extends Entity{
    public Archer(String name, int health, int attack){
        super(name, health, attack);
    }
    @Override
    public String toString() {
        return "I am a Archer";
    }
}
