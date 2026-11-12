package inventory;

import javax.swing.JOptionPane;

public class NPC {
	private String name;
	
	
	public NPC(String n) {
		name = n;
	}
	public String getName() {
		return name;	
	}
	public void setName(String n) {
		name = n;
		
	}
	public void say(String d) {
		
		Game.print(name.toUpperCase() + "\n" + d);
		
	}
	public void talk() {
		Game.print("you cant talk to" + name + "right now");
	}
	public int getResponse(String[] a) {
		for(int i=0; i < a.length; i++){
			Game.print(i + 1 + ") " + a[i] + "\n");
			}
		String input = JOptionPane.showInputDialog(null, "Choose an option:");
		return Integer.parseInt(input);
		
	}
}
