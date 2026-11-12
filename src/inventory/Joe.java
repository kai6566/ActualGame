package inventory;
public class Joe extends NPC {
	public Joe() {
		super("joe"); // NOTE: name must be lower-case
	}

	@Override
	public void talk() {
		say("Hello! What bring you here?");
		String[] responses = { "Where is the key", "i need a milk shake.?", "can you help me look for the tool?" };
		int option = getResponse(responses);
		switch (option) {
		case 1:
			say("i can tell you but you wont beleive me");
			break;
		case 2:
			say("Ooh! good to know. go find one!");
			break;
		case 3:
			say("No. tool for your own tool!");
			break;
		default:
			say("Uhhh…what?");
		}
	}
}