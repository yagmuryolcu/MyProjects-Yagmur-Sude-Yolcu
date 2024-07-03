import java.util.ArrayList;
import java.util.Scanner;

public class ManageRoom {
        Scanner scanner = new Scanner(System.in);

        public void run(Scanner scanner) {
        System.out.println("WELCOME TO CANDLES RESORT ROOMS");
        ArrayList<Room> rooms = new ArrayList<>();


        rooms.add(new Room(100, "Single", "Queen", 1250, true));
        rooms.add(new Room(150, "Single", "King", 1500, false));
        rooms.add(new Room(200, "Single", "Double", 1000, true));
        rooms.add(new Room(250, "Single", "King", 1500, true));
        rooms.add(new Room(300, "Single", "King", 1500, true));
        rooms.add(new Room(350, "Double", "King", 3500, true));
        rooms.add(new Room(400, "Double", "King", 3500, false));
        rooms.add(new Room(450, "Double", "Queen", 3250, true));
        rooms.add(new Room(500, "Double", "Double", 3000, true));
        rooms.add(new Room(550, "Double", "Double", 3000, true));
        rooms.add(new Room(600, "Triple", "Queen", 6250, false));
        rooms.add(new Room(650, "Triple", "Double", 6000, true));
        rooms.add(new Room(700, "Triple", "Double", 6250, true));
        rooms.add(new Room(750, "Triple", "Queen", 6250, true));
        rooms.add(new Room(800, "Quad", "King", 8000, true));
        rooms.add(new Room(850, "Quad", "King", 8000, true));
        rooms.add(new Room(900, "Quad", "King", 8000, true));
        System.out.printf("%-10s%-10s%-10s%-10s%-15s\n", "Number", "Type", "Bed Type", "Price", "Status");

        for (Room room : rooms) {
                System.out.printf("%-10d%-10s%-10s%-10.2f%-15s\n",
                        room.getRoomNumber(), room.getRoomType(), room.getBedType(),
                        room.getPrice(), room.isCleaningStatus() ? "Cleaned" : "Not Cleaned");
        }
}

        public void displayRoomInformation(ArrayList<Room> selectedRooms) {
        }

        public Room findRoomByNumber(ArrayList<Room> rooms, int roomNumber) {
                return null;
        }

        public ArrayList<Room> getSampleRooms() {
                return null;
        }

}