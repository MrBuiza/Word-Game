public class Item {
    protected String itemName;
    protected int value;


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