import java.util.*;

public class Event {
    public void startShop(Scanner input, Entity player1, Entity merchant){

        HashMap<String, InventorySlot> merchantInventory = merchant.getInventory();

        // Get all keys as an array
        Object[] keys = merchantInventory.keySet().toArray();

        // Generate a random index
        Random random = new Random();
        int randomIndex = random.nextInt(keys.length);

        // Get the random key using the random index
        String randomKey = (String) keys[randomIndex];

        InventorySlot slot = merchantInventory.get(randomKey);

        while (true) {

            System.out.println("Would you like to buy from this merchant? Enter 'yes' or 'no' to proceed");
            String decideShop = input.next();

            int amount = 0;

            if (decideShop.equals("yes")) {

                System.out.println("Merchant " + merchant.getName() + ":  Excellent! I have, here with me, some freshly picked " + slot.getItem().getItemName().toLowerCase() + "s." +
                        "Each " + slot.getItem().getItemName().toLowerCase() + " costs " + slot.getItem().getValue() + " gold coin(s).\n" +
                        "Your inventory: " + player1.getInventory() + "\n" +
                        "Your GOLD: " + player1.getCoins() + "g\n" +
                        "Cost for 1 " + slot.getItem().getItemName().toLowerCase() + ": " + slot.getItem().getValue() + "g" + "\n" +
                        "How many would you like? Enter an amount from 1 to 20 or type 'exit' to quit shopping.");

                try {
                    amount = input.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("You need to enter a number between 1 and 20");
                }

                System.out.println("Cost for " + amount + " " + slot.getItem().getItemName().toLowerCase() + "(s): " + slot.getItem().getValue() * amount + "g\n" +
                        "Do you want to purchase " + amount + " " + slot.getItem().getItemName().toLowerCase() + "s?\n" +
                        "Enter 'yes' or 'no' to continue...");

                boolean purchased = confirmPurchase(amount, player1, input, slot.getItem(), merchant);
                if (purchased) {
                    break;
                }

            } else if (decideShop.equals("no")) {
                System.out.println("Merchant " + merchant.getName() + ": Suit yourself " + player1.getType().toLowerCase() + ", You will not find goods this fresh anywhere else...");
                break;
            } else {
                System.out.println("Merchant " + merchant.getName() + ": I don't understand... Do you want to buy something?");
            }

        }
    }

    public void firstFight(){

    }

    public boolean confirmPurchase(int amount, Entity player1, Scanner input, Item item, Entity merchant){

        String confirm = input.next();

        if (confirm.equals("yes")) {

            player1.addToInventory(item, amount);
            merchant.removeFromInventory(item, amount);

            System.out.println("You have purchased " + amount + " " + item.getItemName().toLowerCase() + "s.");

            player1.updateCoins(-(item.getValue() * amount));
            merchant.updateCoins(item.getValue() * amount);

            System.out.println(merchant.getInventory());
            System.out.println(merchant.getCoins());

            System.out.println(item.getValue() * amount + " coins removed. You now have " + player1.getCoins() + " coins.");
            System.out.println("In your inventory you have " + player1.getInventory());
            return true;
        } else if (confirm.equals("no")) {
            System.out.println("You don't want that many? Alright then.");
        } else if (confirm.equals("exit")) {
            System.out.println("Merchant " + merchant.getName() + ": Changed your mind did you? Your loss " + player1.getType());
            return true;
        } else {
            System.out.println("I don't understand that. Let's try again shall we?");
        }
        return false;
    }

    public void useItem(Entity player1, Item item, Scanner input) {
        while (true) {
        System.out.println("Would you like to use " + item.getItemName() + "?\n +" +
                "Please type yes or no");
        String confirm = input.nextLine();

            if (confirm.equals("yes")) {
                player1.setHealth(player1.getHealth() + item.getHeal());
                System.out.println("You have used the " + item.getItemName());
                System.out.println("Your health is now " + player1.getHealth());
                break;
            } else if (confirm.equals("no")) {
                System.out.println("The " + item.getItemName() + " will not be used.");
                System.out.println("Your health is " + player1.getHealth());
                break;
            } else {
                System.out.println("Unrecognised command, please try again.");
            }

        }
    }

}
