
package inventory;

public class Bobo extends NPC {

    private int convoNumber = 0;

    public Bobo() {
        super("bobo");
    }

    @Override
    public void talk() {

        if (convoNumber == 0) {

            say("Hello! How may I help you today?");

            String[] responses = {
                "Got any gum?",
                "You can't help me. I'm here to help you.",
                "Can I have 50 cents?"
            };

            int option = getResponse(responses);

            switch (option) {
            case 1:
                say("All we have left is pineapple-flavored gum. Oh, wait. Never mind. I'm chewing the last piece.");
                convoNumber = 1;
                break;
            case 2:
                say("Ooh! Nobody's ever helped me before. Thanks!");
                convoNumber = 2;
                break;
            case 3:
                say("No.");
                convoNumber = 3;
                break;
            default:
                say("Uhhh…what?");
            }

        } else if (convoNumber == 1) {
            say("Sorry, I still don't have any gum.");

        } else if (convoNumber == 2) {
            respond();

        } else if (convoNumber == 3) {
            say("I still don't have 50 cents.");

        } else if (convoNumber == 4) {
            say("Thanks for helping me! Bye!");

        } else if (convoNumber == 5) {
            say("I am Peaches! Kneel before me, worm!");

        } else if (convoNumber == 6) {
            say("I guess I'm beyond help. Bye!");
        }
        respond();
    }

    public void respond() {

        say("Are you gonna help me now?");

        String[] responses = {
            "I'm going to teach you Spanish: Me llamo Bobo.",
            "I'm giving you a new name: Peaches.",
            "No. I was kidding before. You're beyond help."
        };

        int option = getResponse(responses);

        switch (option) {
        case 1:
            say("Me llamo Bobo. Yay! I speak Spanish now!");
            convoNumber = 4;
            break;

        case 2:
            setName("peaches");
            say("Ooooh! I feel fuzzy...");
            convoNumber = 5;
            break;

        case 3:
            say("Oh, okay.");
            convoNumber = 6;
            break;

        default:
            say("Uhhh…what?");
        }
    }
}
