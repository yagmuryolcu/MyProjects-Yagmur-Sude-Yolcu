import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheapRooms {
    public void mainMenu(Scanner scanner) {
        System.out.println("OUR ROOMS ");

        ArrayList<Room> rooms = getSampleRooms();

        System.out.printf("%-10s%-10s%-10s%-10s%-15s\n", "Number", "Type", "Bed Type", "Price", "Status");

        int roomNumber = 100;
        for (Room room : rooms) {
            System.out.printf("%-10d%-10s%-10s%-10.2f%-15s\n",
                    roomNumber, room.getRoomType(), room.getBedType(),
                    room.getPrice(), room.isCleaningStatus() ? "Cleaned" : "Not Cleaned");
            roomNumber += 50;
        }

        // Sadece Double tipindeki odalara uygulanan RoomAction filter
        RoomAction updatePrice = room -> {
            if ("Double".equals(room.getRoomType())) {
                double currentPrice = room.getPrice();
                double discountedPrice = currentPrice * 0.9; // %10 indirim
                room.setPrice(discountedPrice);
                room.setUpdated(true); // Indirim uygulandı olarak işaretle
            }
        };

        // Fiyat filtresini uygula
        List<Room> roomsWithDiscount = filterRooms(rooms, updatePrice);

        // Değiştirilmiş fiyatları göster
        displayUpdatedRoomPrices(roomsWithDiscount);
        System.out.print("\nEnter the number of rooms to change cleaning status: ");

        int numberOfRoomsToChange = scanner.nextInt();
        scanner.nextLine();


        // Kullanıcıdan oda numaralarını alarak temizlik durumlarını değiştir
        for (int i = 0; i < numberOfRoomsToChange; i++) {
            System.out.print(  "Enter the room number to change cleaning status: ");
            int roomNumberToChange = scanner.nextInt();
            changeCleaningStatus(rooms, roomNumberToChange);
        }

        // Değiştirilmiş temizlik durumlarını göster
        displayUpdatedCleaningStatus(rooms);

    }

    private static void displayUpdatedRoomPrices(List<Room> roomsWithDiscount) {
        System.out.println("\nDouble Rooms Will Discounted In February ! :\n");
        System.out.printf("%-10s%-10s%-10s%-10s%-15s\n", "Number", "Type", "Bed Type", "Price", "Status");

        for (Room room : roomsWithDiscount) {
            System.out.printf("%-10d%-10s%-10s%-10.2f%-15s\n",
                    room.getRoomNumber(), room.getRoomType(), room.getBedType(),
                    room.getPrice(), room.isCleaningStatus() ? "Cleaned" : "Not Cleaned");
        }
    }
  // Room action interface i kullanılarak oluşturulmuş bir filteleme
    private static List<Room> filterRooms(List<Room> rooms, RoomAction updatePrice) {
        List<Room> filteredRooms = new ArrayList<>();
        for (Room room : rooms) {
            updatePrice.performAction(room);
            if (room.isUpdated()) {
                filteredRooms.add(room);
                room.setUpdated(false);
            }
        }
        return filteredRooms;
    }

    private static void changeCleaningStatus(List<Room> rooms, int roomNumberToChange) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumberToChange) {
                room.setCleaningStatus(!room.isCleaningStatus());
                System.out.println("Cleaning status for room " + roomNumberToChange + " changed.");
                return;
            }
        }
        System.out.println("Room with number " + roomNumberToChange + " not found.");
    }

    private static void displayUpdatedCleaningStatus(List<Room> rooms) {
        System.out.println("\nUpdated Cleaning Status:");
        System.out.printf("%-10s%-15s\n", "Number", "Status");

        for (Room room : rooms) {
            System.out.printf("%-10d%-15s\n",
                    room.getRoomNumber(), room.isCleaningStatus() ? "Cleaned" : "Not Cleaned");
        }
    }
    private static ArrayList<Room> getSampleRooms () {
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


}


