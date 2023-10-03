import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public void gameplay() {
        Scanner input = new Scanner(System.in);
        Scenario dialogue = new Scenario();
        Event scenarioShop = new Event();
        Entity player1 = createCharacter(input);
        Entity npc = createNPC();

        createName(input, player1);                                         // A method is called that prompts a user to create their desired hero's name

        String merchantName = createRandomName();                           // Calling a method which creates and chooses a random name for a merchant name to trade with

        Item randomItem = createRandomItem();                               // This calls a method that randomises an item for a merchant to sell

        dialogue.gameIntro(player1, merchantName);                          // This outputs dialogue for setting the introduction of the game

        scenarioShop.startShop(input, player1, merchantName, randomItem);   // Plays the introduction to the first shop scenario

      //  showHealth(input, player1);                                       // Calling a method that shows the players health when they type "show health"

       createNPC();                                                         // Calling a method that creates an NPC for the main characters first fight!


        //TODO: Create a few more methods to shorten the code in main
        // Set the scenario/tutorial/lore and build up to the players first fight
        // Create a merchant entity so that the player can interact with them
        // Create an enemy for the player to face off against
        // Change code for apple and orange items to suit all random items. Lines 28 and 29...
    }

    public Entity createCharacter(Scanner input) {

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

    public void createName(Scanner input, Entity player1) {

        System.out.println("What would you like to be called?");
        String name = input.next();
        player1.setName(name);

        System.out.println("You are a " + player1.getType().toLowerCase() + " and your name is " + player1.getName() + ".");
    }

    public Item createRandomItem() {
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Orange", 2));
        itemList.add(new Item("Apple", 3));
        Random rand = new Random();
        int randomise = rand.nextInt(itemList.size());
        return itemList.get(randomise);
    }

    public String createRandomName() {
        ArrayList<String> namesList = new ArrayList<>();
        namesList.add("Peter");
        namesList.add("John");
        namesList.add("Matthew");
        namesList.add("Paul");
        Random rand = new Random();
        int randomise = rand.nextInt(namesList.size());
        return namesList.get(randomise);
    }
    public Entity createNPC() {
        ArrayList<Entity> npcList = new ArrayList<>();
        Entity thug1 = new Warrior("Warrior", "Thug", 90, 160);
        Entity thug2 = new Medic("Medic", "Thug", 150, 80);
        Entity thug3 = new Archer("Archer", "Thug",80 , 150);
        npcList.add(thug1);
        npcList.add(thug2);
        npcList.add(thug3);
        Random rand = new Random();
        int randomise = rand.nextInt(npcList.size());
        return npcList.get(randomise);
    }

    public void showHealth(Scanner input, Entity player1) {
        System.out.println("Type 'show health' to display your health at any given time.");
        input.nextLine();
        String showHealth = input.nextLine();

        if (showHealth.equals("show health")) {
            System.out.println("Your health is: " + player1.getHealth());
        }
        else {
            System.out.println("Invalid command");
        }
    }
}