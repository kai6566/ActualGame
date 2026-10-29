package inventory;

import java.io.Serializable;

public class Items implements Serializable {
	private String name;
	private boolean heavy;
	
	public Items(String n, boolean h) {
		name = n;
		heavy = h;
		
	}
	
	public String getName() {
		return name;
	}
	public Boolean isHeavy() {
		return heavy;
	}
	
	public void setName(String n) {
		name = n;
	}
	public String toString() {
		return name;
	}
	public void useItem() {
		Game.print("you cannot use this item");
		
	}


		 
	
}