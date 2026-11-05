
package inventory;

public class Safe extends Items {

    private boolean foundNotebook;

    public Safe() {
        super("safe", true);
        foundNotebook = false;
    }

    @Override
    public void open() {

        if (foundNotebook) {
            Game.print("You already found the notebook. There is nothing else in here.");
        }
        else {
            Notebook notebook = new Notebook();
            Game.getCurrentRoom().addItem(notebook);

            foundNotebook = true;
            Game.print("You opened the safe and found a notebook.");
        }
    }

    @Override
    public void close() {
        Game.print("You closed the safe.");
    }
}
