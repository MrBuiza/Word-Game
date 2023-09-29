public class Main {
    public static void main(String[] args) {
        Game start = new Game();
        start.gameplay();

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