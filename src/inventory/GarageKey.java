package inventory;

public class GarageKey extends Items {
    private boolean usedKey;

    public GarageKey() {
        super("garagekey", false);
        usedKey = false;
    }

    @Override
    public void useItem() {
        if (Game.getCurrentRoom().getName().equals("Kitchen")) {
            if (usedKey) {
                Game.print("You already unlocked the garage!");
            } else {
                Game.getCurrentRoom().getExit(3).setIslocked(false);
                usedKey = true;
                Game.print("You unlocked the garage!");
            }
        } else {
            Game.print("You cannot use the garage key here.");
        }
    }
}
