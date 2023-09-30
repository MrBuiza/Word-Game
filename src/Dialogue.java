public class Dialogue {
    public void gameIntro(Entity player1, String merchantName) {
        System.out.println(" /Year 1597/\n" +
                "You are healthy. Here you can see your health when it is effected, take care it doesn't go to low:\n" +
                "Player health = " + player1.getHealth() + "\n" +
                player1.getName() + ", you are in a town called Ribberry. Your stomach growls from hunger.\n" +
                "You walk past a stranger carrying goods. He stops to ask you something...");

        System.out.println("Stranger Merchant: Hello friend, my name is " + merchantName + ". Could I interest you in some fresh products?");

    }
    public void merchantDialogue(Entity player1, Item item, String merchantName) {
        System.out.println("Merchant " + merchantName + ":  Excellent! I have, here with me, some freshly picked " + item.getItemName().toLowerCase() + "s." +
                "Each " + item.getItemName().toLowerCase() + " costs " + item.getValue() + " gold coins. How many would you like?\n" +
                "Your inventory: " + player1.getInventory() + "\n" +
                "Your GOLD: " + player1.getCoins() + "g\n" +
                "Cost for 1 " + item.getItemName().toLowerCase() + ": " + item.getValue() + "g\n");
    }
}
