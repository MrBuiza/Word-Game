public class Item {
    protected String itemName;
    protected int value;

    protected int heal;

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public Item(String itemName, int value) {
        this.itemName = itemName;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return  itemName;
    }
}