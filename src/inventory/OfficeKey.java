package inventory;

public class OfficeKey extends Items {
    private boolean usedKey;

    public OfficeKey() {
        super("officekey", false);
        usedKey = false;
    }

    @Override
    public void useItem() {
        if (Game.getCurrentRoom().getName().equals("Living Room")) {
            if (usedKey) {
                Game.print("You already unlocked the office!");
            } else {
                Game.getCurrentRoom().getExit(1).setIslocked(false);
                usedKey = true;
                Game.print("You unlocked the office!");
            }
        } else {
            Game.print("You cannot use the office key here.");
        }
    }
}
