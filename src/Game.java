import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public void gameplay () {
        Scanner input = new Scanner(System.in);
        Dialogue dialogue = new Dialogue();

        Entity player1 = createCharacter(input);
        createName(input, player1);
        String merchantName = createRandomName();           // Created a method which creates and chooses a random name for a merchant name to trade with.
        dialogue.gameIntro(player1, merchantName);
        Item randomItem = createRandomItem();
        dialogue.merchantDialogue(player1, randomItem, merchantName);

        //TODO: Create a few more methods to shorten the code in main
        // Set the scenario/tutorial/lore and build up to the players first fight
        // Create a merchant entity so that the player can interact with them
        // Create an enemy for the player to face off against

        while (true) {

            System.out.println("Enter 'yes' or 'no' to proceed");
            String decideShop = input.next();
            int amount;
            Item apple = new Item("Apple", 3);
            Item orange = new Item("Orange", 2);

            if (decideShop.equals("yes")) {

                System.out.println("How many would you like? Enter an amount from 1 to 20 or type 'exit' to quit shopping.");
                amount = input.nextInt();
                System.out.println("Cost for " + amount + " " + apple.getItemName().toLowerCase() + "(s): " + apple.getValue() * amount + "g\n" +
                        "Do you want to purchase " + amount + " " + apple.getItemName().toLowerCase() + "s?\n" +
                        "Enter 'yes' or 'no' to continue...");

                String confirm = input.next();

                if (confirm.equals("yes")) {

                    player1.addToInventory(apple, amount);
                    System.out.println("You have purchased " + amount + " " + apple.getItemName().toLowerCase() + "s.");
                    player1.setCoins(player1.getCoins() - (apple.getValue() * amount));

                    System.out.println(apple.getValue() * amount + " coins removed. You now have " + player1.getCoins() + " coins.");
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

    public Entity createCharacter(Scanner input){

        while (true) {
            System.out.println("Please enter number 1, 2 or 3 to choose from these classes: 1)Warrior 2)Medic 3)Archer");
            String chosenClass = input.next();

            if (chosenClass.equals("1")) {
                System.out.println("You have chosen the Warrior, may your courage lead you to victory.");
                return new Warrior("Warrior", "", 100, 10);

            } else if (chosenClass.equals("2")) {
                System.out.println("You have chosen the Medic, may your hands be blessed with life.");
                return new Medic("Medic", "", 150, 5);

            } else if (chosenClass.equals("3")) {
                System.out.println("You have chosen the Archer, may the wind favour you and your aim be true.");
                return new Archer("Archer", "", 70, 7);

            } else {
                System.out.println("You have not entered a valid option.");
            }
        }
    }

    public void createName(Scanner input, Entity player1){

        System.out.println("What would you like to be called?");
        String name = input.next();
        player1.setName(name);

        System.out.println("You are a " + player1.getType().toLowerCase() + " and your name is " + player1.getName() + ".");
    }

    public Item createRandomItem(){
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Orange", 2));
        itemList.add(new Item("Apple", 3));
        Random rand = new Random();
        int randomise = rand.nextInt(itemList.size());
        return itemList.get(randomise);
    }

    public String createRandomName(){
        ArrayList<String> namesList = new ArrayList<>();
        namesList.add("Peter");
        namesList.add("John");
        namesList.add("Matthew");
        namesList.add("Paul");
        Random rand = new Random();
        int randomise = rand.nextInt(namesList.size());
        return namesList.get(randomise);
    }
}