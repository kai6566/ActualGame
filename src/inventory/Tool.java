package inventory;

public class Tool extends Items {
	private boolean usedTool;

	public Tool() {
		super("tool",false);
		usedTool = false;
		
	}

	@Override
	public void useItem() {
		if (Game.getCurrentRoom().getName().equals("Bedroom")) {
			if (usedTool) {
				Game.print("You already opened the attic door!");
			} else {
				Game.getCurrentRoom().getExit(4).setIslocked(false);
				usedTool = true;
				Game.print("Using the tool, you are able to unlock the attic");
			}
		} else
			Game.print("You don't see any way to use the tool in the "+ Game.getCurrentRoom().getName());
	}
}