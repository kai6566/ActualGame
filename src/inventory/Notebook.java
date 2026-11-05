
package inventory;

public class Notebook extends Items {

	private boolean foundpassword;

	public Notebook() {
		super("notebook", false);
		foundpassword = false;
	}

	@Override
	public void read() {

		if (foundpassword) {
			Game.print("you already found the password");
		}
		else {
			Items password = new Items("password", true);
			Game.item.add(password);
			foundpassword = true;
			Game.print("You found the password!");
		}
	}
}
