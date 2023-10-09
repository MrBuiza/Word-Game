import java.util.InputMismatchException;
import java.util.Scanner;

public class Event {
    public void startShop(Scanner input, Entity player1, String merchantName, Item item){
        while (true) {

            System.out.println("Would you like to buy from this merchant? Enter 'yes' or 'no' to proceed");
            String decideShop = input.next();

            int amount = 0;

            if (decideShop.equals("yes")) {

                System.out.println("Merchant " + merchantName + ":  Excellent! I have, here with me, some freshly picked " + item.getItemName().toLowerCase() + "s." +
                        "Each " + item.getItemName().toLowerCase() + " costs " + item.getValue() + " gold coin(s).\n" +
                        "Your inventory: " + player1.getInventory() + "\n" +
                        "Your GOLD: " + player1.getCoins() + "g\n" +
                        "Cost for 1 " + item.getItemName().toLowerCase() + ": " + item.getValue() + "g" + "\n" +
                        "How many would you like? Enter an amount from 1 to 20 or type 'exit' to quit shopping.");

                try {
                    amount = input.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("You need to enter a number between 1 and 20");
                }

                System.out.println("Cost for " + amount + " " + item.getItemName().toLowerCase() + "(s): " + item.getValue() * amount + "g\n" +
                        "Do you want to purchase " + amount + " " + item.getItemName().toLowerCase() + "s?\n" +
                        "Enter 'yes' or 'no' to continue...");

                boolean purchased = confirmPurchase(amount, player1, input, item, merchantName);
                if (purchased) {
                    break;
                }

            } else if (decideShop.equals("no")) {
                System.out.println("Merchant " + merchantName + ": Suit yourself " + player1.getType().toLowerCase() + ", You will not find goods this fresh anywhere else...");
                break;
            } else {
                System.out.println("Merchant " + merchantName + ": I don't understand... Do you want to buy something?");
            }

        }
    }

    public void firstFight(){

    }

    public boolean confirmPurchase(int amount, Entity player1, Scanner input, Item item, String merchantName){

        String confirm = input.next();

        if (confirm.equals("yes")) {

            player1.addToInventory(item, amount);
            System.out.println("You have purchased " + amount + " " + item.getItemName().toLowerCase() + "s.");
            player1.setCoins(player1.getCoins() - (item.getValue() * amount));

            System.out.println(item.getValue() * amount + " coins removed. You now have " + player1.getCoins() + " coins.");
            System.out.println("In your inventory you have " + player1.getInventory());
            return true;
        } else if (confirm.equals("no")) {
            System.out.println("You don't want that many? Alright then.");

        } else if (confirm.equals("exit")) {
            System.out.println("Merchant " + merchantName + ": Changed your mind did you? Your loss " + player1.getType());
            return true;
        } else {
            System.out.println("I don't understand that. Let's try again shall we?");
        }
        return false;
    }

    public void useItem(Entity player1, Item item, Scanner input) {
        item.setHeal(50);
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
