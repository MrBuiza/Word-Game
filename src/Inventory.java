import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    protected HashMap<String, InventorySlot> inventory = new HashMap<>();

    public HashMap<String, InventorySlot> getInventory() {
        return inventory;
    }

    public void addToInventory(Item item, int amount) {
        InventorySlot currentSlot = new InventorySlot(item, amount);
        inventory.put(item.getItemName(), currentSlot);
    }

    public void removeFromInventory(Item item, int amount) {
        if (!inventory.containsKey(item.getItemName())) {
            return;
        }
        InventorySlot slot = inventory.get(item.getItemName());
        int newValue = slot.getAmount() - amount;
        InventorySlot updatedSlot = new InventorySlot(item, newValue);
        inventory.put(item.getItemName(), updatedSlot);
    }
}