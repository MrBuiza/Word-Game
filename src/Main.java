import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Please enter number 1, 2 or 3 to choose from these classes: 1)Warrior 2)Medic 3)Archer");
        Scanner askClass = new Scanner(System.in);
        String chosenClass = askClass.next();
        int counter = 0;

        while (counter <= 0) {
            if (Objects.equals(chosenClass, "1")) {
                System.out.println("You have chosen the Warrior, may your courage lead you to victory.");
                chosenClass = "Warrior";
                counter ++;

            } else if (Objects.equals(chosenClass, "2")) {
                System.out.println("You have chosen the Medic, may your hands be blessed with life.");
                chosenClass = "Medic";
                counter++;

            } else if (Objects.equals(chosenClass, "3")) {
                System.out.println("You have chosen the Archer, may the wind favour you and your aim be true.");
                chosenClass = "Archer";
                counter++;

            } else {
                System.out.println("You have not entered a valid option.");

            }
        }

        System.out.println("What would you like to be called?");
        Scanner askName = new Scanner(System.in);
        System.out.println("You are a " + chosenClass + " and your name is " + askName.nextLine() + ". It is time to begin your journey. Let me take you back 600 years to where it all started...");

    }

}

//Make a game that allows the player to choose a class:
//(warrior, medic, archer) I want the player to choose a name for whichever class they choose
// and I want the game to take user input.