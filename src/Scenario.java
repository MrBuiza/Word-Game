import java.util.Scanner;

public class Scenario {
    public void startShop(Scanner input, Entity player1, String merchantName, Item item){
        while (true) {

            System.out.println("Would you like to buy from this merchant? Enter 'yes' or 'no' to proceed");
            String decideShop = input.next();

            int amount;

            if (decideShop.equals("yes")) {

                System.out.println("How many would you like? Enter an amount from 1 to 20 or type 'exit' to quit shopping.");
                amount = input.nextInt();
                System.out.println("Cost for " + amount + " " + item.getItemName().toLowerCase() + "(s): " + item.getValue() * amount + "g\n" +
                        "Do you want to purchase " + amount + " " + item.getItemName().toLowerCase() + "s?\n" +
                        "Enter 'yes' or 'no' to continue...");

                String confirm = input.next();

                if (confirm.equals("yes")) {

                    player1.addToInventory(item, amount);
                    System.out.println("You have purchased " + amount + " " + item.getItemName().toLowerCase() + "s.");
                    player1.setCoins(player1.getCoins() - (item.getValue() * amount));

                    System.out.println(item.getValue() * amount + " coins removed. You now have " + player1.getCoins() + " coins.");
                    System.out.println("In your inventory you have " + player1.getInventory());
                    break;
                } else if (confirm.equals("no")) {
                    System.out.println("You don't want that many? Alright then.");

                } else if (confirm.equals("exit")) {
                    System.out.println("Merchant " + merchantName + ": Changed your mind did you? Your loss " + player1.getType());
                    break;
                } else {
                    System.out.println("I don't understand that. Let's try again shall we?");
                }

            } else if (decideShop.equals("no")) {
                System.out.println("Merchant " + merchantName + ": Suit yourself " + player1.getType().toLowerCase() + ", You will not find goods this fresh anywhere else...");
                break;
            } else {
                System.out.println("Merchant " + merchantName + ": I don't understand... Do you want to buy something?");
            }

        }
    }
}
