import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String chosenClass = "";
        Entity player1 = null;

        while (true) {
            System.out.println("Please enter number 1, 2 or 3 to choose from these classes: 1)Warrior 2)Medic 3)Archer");
            chosenClass = input.next();

            if (chosenClass.equals("1")) {
                System.out.println("You have chosen the Warrior, may your courage lead you to victory.");
                player1 = new Warrior("", 100, 10);
                break;

            } else if (chosenClass.equals("2")) {
                System.out.println("You have chosen the Medic, may your hands be blessed with life.");
                player1 = new Medic("",150, 5);
                break;

            } else if (chosenClass.equals("3")) {
                System.out.println("You have chosen the Archer, may the wind favour you and your aim be true.");
                player1 = new Archer("", 70, 7);
                break;

            } else {
                System.out.println("You have not entered a valid option.");

            }
        }

        System.out.println("What would you like to be called?");
        String name = input.next();
        player1.setName(name);

        System.out.println("You are a " + chosenClass + " and your name is " + player1.getName() + "." +
                " It is time to begin your journey. Let me take you back 600 years to where it all started... " +
                "You are healthy. Here you can see your health, take care it doesn't go to low: " + player1.getHealth());
    }

}

//Create an inventory. Add a coins variable and each class starts with a set number of coins.
//Create an NPC that sells apples. The player is asked to buy an apple.
//If the player chooses yes, the coin value of the apple is taken from coins and apple is added to inventory.
//Another NPC approaches and asks you If you want to sell anything in your inventory.
//If you have nothing, your character will automatically say he/she has nothing.
//If you have something, your character will be given a choice sell or don't sell?
//If you choose to sell, you get to choose how much to sell your item(s) for. If price is too high, NPC will decline.
//NPC may ask up to 3 times for a better price before walking off annoyed.
//If you sell, the coins you sold the item for will be added to coins and the item you sold will be removed from inventory.