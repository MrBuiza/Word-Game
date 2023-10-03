public class Scenario {
    public void gameIntro(Entity player1, String merchantName) {
        System.out.println(" /Year 1597/\n" +
                "Ribberry Town\n" +
                "You are healthy. Here you can see your health when it is effected, take care it doesn't go to low:\n" +
                "Player health = " + player1.getHealth() + "\n" +
                player1.getName() + ", you are in a town called Ribberry. Your stomach growls from hunger.\n" +
                "You walk down the bustling main street filled with local merchants, workers and travellers." +
                "You walk past a stranger carrying goods. He stops to ask you something...");

        System.out.println("Stranger Merchant: Hello friend, my name is " + merchantName + ". Could I interest you in some fresh products?");

    }

    public void tutorial(){

    }

    public void scenario1(Entity player1, String merchatName) {
        System.out.println("You leave the merchant and continue down the path until you reach a suspicious alleyway..." +
                "The alleyway is dark and eerily quiet. Not a soul in sight. You must pass through to reach your destination" +
                "As you take a few dozen steps, a band of thugs begin to surround you from in front and behind..." +
                "Thug 1: Looks like we got a live one here fellas. How much d'ya think this one has?" +
                player1.getName() + ": More than this is worth for you." +
                "The thugs look at one another and begin laughing increasingly louder." +
                "Thug1: Don't tell me you're a bloody hero. We've got no time for heroes mate.. Tell ya what," +
                "I'll let the boys sit out for this one and teach ya a lesson meself. Draw your weapon...");
    }


   // public void
}
