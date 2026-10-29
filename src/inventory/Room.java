package inventory;

import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable {

    private String name;
    private Room[] room;
    private Items items;
    private boolean isLocked;
    private HashMap<String, Items> item;
    public static HashMap<String,Room> rooms = new HashMap<>();
    

    // Constructor method - used to build an object
    public Room(String n) {
        name = n;
        room = new Room[6];
        item = new HashMap<>();
        rooms.put(name,this);
        isLocked = false;
    }


    // Get Methods
    public boolean getIslocked() {
		return isLocked;
    	
    }
    public void setIslocked(boolean n) {
  		isLocked = n;
    }
    public String getName() {
        return name;
    }
    
    public static HashMap<String,Room> getRooms(){
    	return rooms;
    }
    public String getDescription() {
        return Game.roomDescription.get(name);
    }


    public Items getItems(String n) {
        return item.get(n);
    }


    // Set Methods
    public void setName(String n) {
        name = n;
    }


    public void setItems(Items i) {
        items = i;
    }


    public void removeItems(String n) {
        item.remove(n);
    }


    public void setDescription(String d) {
        Game.roomDescription.put(name, d);
    }


    // Special Methods
    public String toString() {
        String s = name + "\n" + getDescription();

        return s;
    }


    public void addExit(Room z, int n) {
        room[n] = z;
    }


    public void addItem(Items i) {
        item.put(i.getName(), i);
    }


    public Room getExit(int n) {
        return room[n];
    }
}