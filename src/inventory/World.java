package inventory;

public class World {
	public static void main(String[] args) {

		Room currentRoom = buildWorld();

		System.out.println(currentRoom); // living room
		currentRoom = currentRoom.getExit(0); // 0=east
		System.out.println(currentRoom); // kitchen
		currentRoom = currentRoom.getExit(3); // 3=south
		System.out.println(currentRoom); // garage
		currentRoom = currentRoom.getExit(2); // 2=north
		System.out.println(currentRoom); // kitchen again
		currentRoom = currentRoom.getExit(1); // 1=west
		System.out.println(currentRoom); // living room again
		currentRoom = currentRoom.getExit(2); // 2=north
		System.out.println(currentRoom); // bedroom
		currentRoom = currentRoom.getExit(4); // 4=up
		System.out.println(currentRoom); // attic
	}

	public static Room buildWorld() {

		Room livingRoom = new Room("Living Room");
		Room office = new Room("Office");
		Room kitchen = new Room("Kitchen");
		Room bedroom = new Room("Bedroom");
		Room attic = new Room("Attic");
		Room garage = new Room("Garage");
		Items key = new OfficeKey();
		Items tool = new Tool();
		Items garagekey = new GarageKey();
		Items musicbox = new Items("musicbox", false);
		Items flashlight = new Items("flashlight", false);
		Items knife = new Items("knife", false);
		Items mysteriousorb = new Items("mysteriousorb", false);
		Items couch = new Items("couch", true);
		Items Safe = new Safe();
		
		bedroom.addExit(attic, 4); // 4=up
		bedroom.addExit(livingRoom, 3); // 3=south
		livingRoom.addExit(bedroom, 2); // 2=North
		livingRoom.addExit(office, 1); // 1=west
		livingRoom.addExit(kitchen, 0); // 0=East
		kitchen.addExit(garage, 3); // 3=south
		office.addExit(livingRoom, 0);// 0=East
		attic.addExit(bedroom, 3); // 3=south
		garage.addExit(kitchen, 2); // 2=up
		kitchen.addExit(livingRoom, 1);// 1=west
		bedroom.addItem(key);
		bedroom.addItem(tool);
		livingRoom.addItem(musicbox);
		livingRoom.addItem(flashlight);
		kitchen.addItem(garagekey);
		kitchen.addItem(knife);
		kitchen.addItem(mysteriousorb);
		attic.addItem(Safe);
		attic.setIslocked(true);
		office.setIslocked(true);
		garage.setIslocked(true);

		return bedroom;

	}
}
