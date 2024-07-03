import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RoomPriceUpdater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            HashMap<Integer, Room> rooms = getSampleRoomsMap();

            displayRoomInformation(rooms);

            System.out.println("1. Update room price");
            System.out.println("2. Return to the main menu");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    updateRoomPrice(scanner, rooms);
                    break;
                case "2":
                    System.out.println("Returning to the main menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
    }

    private static void updateRoomPrice(Scanner scanner, Map<Integer, Room> rooms) {
        System.out.print("Enter the room number to update price: ");
        String roomNumberInput = scanner.nextLine();

        if (roomNumberInput.equalsIgnoreCase("exit")) {
            System.out.println("Returning to the main menu.");
            return;
        }

        try {
            int roomNumberToUpdate = Integer.parseInt(roomNumberInput);

            if (rooms.containsKey(roomNumberToUpdate)) {
                System.out.print("Enter the new price for room " + roomNumberToUpdate + ": ");
                double newPrice = scanner.nextDouble();

                // fiyat güncelleme
                rooms.get(roomNumberToUpdate).setPrice(newPrice);

                System.out.println("Price updated successfully!");
            } else {
                System.out.println("Room not found. Please enter a valid room number.");
            }

            //  Lambda
            rooms = rooms.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));

            displayRoomInformation(rooms);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid room number or type 'exit'.");
        } finally {
            scanner.nextLine(); // Consume newline
        }
    }

    private static void displayRoomInformation(Map<Integer, Room> rooms) {
        System.out.printf("%-10s%-10s%-10s%-10s%-15s\n", "Number", "Type", "Bed Type", "Price", "Status");

        for (Map.Entry<Integer, Room> entry : rooms.entrySet()) {
            Room room = entry.getValue();
            System.out.printf("%-10d%-10s%-10s%-10.2f%-15s\n",
                    entry.getKey(), room.getRoomType(), room.getBedType(),
                    room.getPrice(), room.isCleaningStatus() ? "Cleaned" : "Not Cleaned");
        }
    }


    private static HashMap<Integer, Room> getSampleRoomsMap() {
        HashMap<Integer, Room> roomMap = new HashMap<>();
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

        // Eşleştirme işlemi
        for (Room room : rooms) {
            roomMap.put(room.getRoomNumber(), room);
        }

        return roomMap;
    }

}