package inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Game {

	private static Room currentRoom;

	public static ArrayList<Items> item = new ArrayList<>();
	public static HashMap<String, String> roomDescription = new HashMap<>();

	public static void printFile() {
		try {
			Scanner fileScan = new Scanner(new File("roomDescriptions.txt"));

			while (fileScan.hasNextLine()) {
				String name = fileScan.nextLine();
				String description = "";

				while (fileScan.hasNextLine()) {
					String line = fileScan.nextLine();

					if (line.equals("#")) {
						break;
					}

					description += line + "\n";
				}

				roomDescription.put(name, description);
			}

			fileScan.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void openItem(String n) {
		Items i = currentRoom.getItems(n);

		if (i == null) {
			print("This item is not in the room.");
		} else {
			i.open();
		}
	}

	public static void closeItem(String n) {
		Items i = currentRoom.getItems(n);

		if (i == null) {
			print("This item is not in the room.");
		} else {
			i.close();
		}
	}

	public static void readItem(String n) {
		for (Items i : item) {
			if (i.getName().equals(n)) {
				i.read();
				return;
			}
		}

		print("You do not have this item.");
	}

	public static void saveGame() {
		try {
			File saveFile = new File("save0.sav"); // name the file yourself
			saveFile.createNewFile(); // creates a new file
			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(saveFile));
			outStream.writeObject(currentRoom);
			outStream.writeObject(Room.getRooms());
			outStream.writeObject(item);

			outStream.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void loadGame() {
		try {
			File saveFile = new File("save0.sav"); // name the file yourself
			ObjectInputStream outStream = new ObjectInputStream(new FileInputStream(saveFile));
			currentRoom = (Room) outStream.readObject();
			Room.rooms = (HashMap<String, Room>) outStream.readObject();
			item = (ArrayList<Items>) outStream.readObject();

			outStream.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void startGame() {

		printFile();

		currentRoom = World.buildWorld();

		print(currentRoom);
	}

	public static void processCommand(String name) {

		String[] command = name.toLowerCase().split(" ");

		switch (command[0]) {

		case "east":
			move("east");
			break;

		case "west":
			move("west");
			break;

		case "north":
			move("north");
			break;

		case "south":
			move("south");
			break;

		case "up":
			move("up");
			break;

		case "down":
			move("down");
			break;

		case "save":
			saveGame();
			Game.print("you saved the game");
			break;

		case "load":
			loadGame();
			Game.print("you loaded a game");
			break;

		case "open":
			if (command.length == 1) {
				print("Open what?");
			} else {
				openItem(command[1]);
			}
			break;

		case "close":
			if (command.length == 1) {
				print("Close what?");
			} else {
				closeItem(command[1]);
			}
			break;

		case "read":
			if (command.length == 1) {
				print("Read what?");
			} else {
				readItem(command[1]);
			}
			break;

		case "exit":
			print("Goodbye!");
			System.exit(0);
			break;

		case "take":

			if (command.length == 1) {
				print("Take what?");
			} else {
				takeItem(command[1]);
			}

			break;

		case "use":
			if (command.length == 1) {
				print("Use what?");
			} else {
				String itemName = command[1];
				if (itemName.equals("the") && command.length > 2) {
					itemName = command[2];
				}
				useItem(itemName);
			}
			break;

		default:
			print("Invalid command.");
		}

		print(currentRoom);

		updateInventoryDisplay();
	}

	public static void takeItem(String n) {

		if (currentRoom.getItems(n) == null) {

			print("This item is not in the room");

		} else if (currentRoom.getItems(n).isHeavy()) {

			print("You cannot carry the " + n + " because it is too heavy");

		} else if (n.equals(currentRoom.getItems(n).toString())) {

			item.add(currentRoom.getItems(n));
			currentRoom.removeItems(n);

			print("You take the " + n + " and carry it with you");

		} else {

			print("There is no " + n + " here");
		}
	}

	public static void useItem(String n) {
		for (Items i : item) {
			if (i.getName().equals(n)) {
				i.useItem();
				return;
			}
		}
		print("You do not have this item.");
	}

	public static void Enterroom(String n) {
		if (currentRoom.getIslocked() == true) {
			Game.print("this room is locked you cannot enter");

		} else {

		}

	}

	public static void move(String s) {

		int z = 0;

		if (s.equals("east")) {
			z = 0;
		} else if (s.equals("west")) {
			z = 1;
		} else if (s.equals("north")) {
			z = 2;
		} else if (s.equals("south")) {
			z = 3;
		} else if (s.equals("up")) {
			z = 4;
		} else if (s.equals("down")) {
			z = 5;
		} else {
			print("That is not a valid direction.");
			return;
		}

		if (currentRoom.getExit(z) == null) {
			print("You can't go that way.");
		} else if (currentRoom.getExit(z).getIslocked() == true) {
			Game.print("this room is locked you cannot enter");

		} else {
			currentRoom = currentRoom.getExit(z);
		}
	}

	public static void updateInventoryDisplay() {

		String[] inventory = new String[item.size()];

		for (int i = 0; i < item.size(); i++) {
			inventory[i] = item.get(i).toString();
		}

		GameGUI.updateInventoryList(inventory);
	}

	public static void print(Object obj) {
		GameGUI.printToScreen(obj.toString());
	}

	public static Room getCurrentRoom() {

		return currentRoom;
	}
}