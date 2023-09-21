public class Medic extends Entity{
    public Medic(String name, int health, int attack){
        super(name, health, attack);
    }
    @Override
    public String toString() {
        return "I am a Medic";
    }
}
