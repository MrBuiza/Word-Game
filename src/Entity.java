public class Entity {
    protected String name;
    protected int health;
    protected int attack;

    public Entity(String name, int health, int attack){
        this.name = name;
        this.health = health;
        this.attack = attack;
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
