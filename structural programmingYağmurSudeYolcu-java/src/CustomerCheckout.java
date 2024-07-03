import java.util.ArrayList;
import java.util.Scanner;

public class CustomerCheckout {

    public void run() {
        ArrayList<Room> rooms = getSampleRooms();

        System.out.printf("%-10s%-10s%-10s%-10s%-15s\n", "Number", "Type", "Bed Type", "Price", "Status");

        int roomNumber = 100;
        for (Room room : rooms) {
            System.out.printf("%-10d%-10s%-10s%-10.2f%-15s\n",
                    roomNumber, room.getRoomType(), room.getBedType(),
                    room.getPrice(), room.isCleaningStatus() ? "Cleaned" : "Not Cleaned");
            roomNumber += 50;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many rooms would you like to book? ");
        int numberOfRooms = scanner.nextInt();

        ArrayList<Room> selectedRooms = new ArrayList<>();
        for (int i = 0; i < numberOfRooms; i++) {
            System.out.print("Enter the room number for room " + (i + 1) + ": ");
            int selectedRoomNumber = scanner.nextInt();
            Room selectedRoom = findRoomByNumber(rooms, selectedRoomNumber);
            if (selectedRoom != null && selectedRoom.isCleaningStatus()) {
                selectedRooms.add(selectedRoom);
            } else {
                if (selectedRoom == null) {
                    System.out.println("Room not found. Please enter a valid room number.");
                } else {
                    System.out.println("Selected room is not clean. Please choose a different room.");
                }
                i--;  // Retry the current room selection
            }
        }

        double totalAmount = calculateTotalAmount(selectedRooms);
        System.out.println("\nSelected Rooms:");
        displayRoomInformation(selectedRooms);
        System.out.println("\nTotal Amount: $" + totalAmount);

        // New code to handle user's choice to return to the main menu or exit
        System.out.print("Enter your choice (1 to return to the main menu, 2 to exit): ");
        int userChoice = scanner.nextInt();

        switch (userChoice) {
            case 1:
                System.out.println("Returning to the main menu.");
                return; // Exit from the run method
            case 2:
                System.out.println("Exiting Customer Checkout. Returning to the main menu.");
                System.exit(0); // Exit the entire program
            default:
                System.out.println("Invalid choice. Returning to the main menu.");
                break;
        }
    }

    static ArrayList<Room> getSampleRooms() {
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
        return rooms;
    }

    private static void displayRoomInformation(ArrayList<Room> rooms) {
        // displayRoomInformation metodunu aynen kopyalıyoruz
        // (istediğiniz değişiklikleri yapabilirsiniz, burada bir değişiklik yapılmadı)
        System.out.printf("%-10s%-10s%-10s%-10s%-15s\n", "Number", "Type", "Bed Type", "Price", "Status");

        int roomNumber = 100;
        for (Room room : rooms) {
            System.out.printf("%-10d%-10s%-10s%-10.2f%-15s\n",
                    roomNumber, room.getRoomType(), room.getBedType(),
                    room.getPrice(), room.isCleaningStatus() ? "Cleaned" : "Not Cleaned");
            roomNumber += 50;
        }
    }

    private static Room findRoomByNumber(ArrayList<Room> rooms, int roomNumber) {
        // findRoomByNumber metodunu aynen kopyalıyoruz
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    private static double calculateTotalAmount(ArrayList<Room> selectedRooms) {
        double totalAmount = 0;
        for (Room room : selectedRooms) {
            totalAmount += room.getPrice();
        }
        return totalAmount;
        }

}