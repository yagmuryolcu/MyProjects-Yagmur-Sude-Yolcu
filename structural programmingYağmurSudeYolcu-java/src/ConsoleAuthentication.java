import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleAuthentication {

    private static Map<String, String> users = new HashMap<>();
    //users isimli Map nesnesi, kullanıcı adlarını ve şifrelerini depolamak için kullanılır.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("1. Sign up");
            System.out.println("2. Login");
            System.out.println("3. Customer Checkout");
            System.out.println("4. Cheap Rooms");
            System.out.println("5. Room Price Updater");
            System.out.println("6. Room Allocation");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            if (scanner.hasNext()) {
                String input = scanner.next();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting program. Goodbye!");
                    exitProgram = true;
                } else {
                    try {
                        int choice = Integer.parseInt(input);
                           //switch (choice) ifadesi, kullanıcının girdiği seçeneği değerlendirir.
                        //break; ifadeleri, programın switch bloğundan çıkmasını sağlar.
                        switch (choice) {
                            case 1:
                                signUp(scanner);
                                break;
                            case 2:
                                loginAndHandleOptions(scanner);
                                break;
                            case 3:
                                //  CustomerCheckout class
                                CustomerCheckout customerCheckout = new CustomerCheckout();
                                customerCheckout.run();
                                break;
                            case 4:
                                //  CheapRooms class
                                CheapRooms cheapRooms = new CheapRooms();
                                cheapRooms.mainMenu(scanner);
                                break;
                            case 5:
                                //  RoomPriceUpdater class
                                RoomPriceUpdater.main(null);
                                break;
                            case 6:
                                //  RoomAllocation class
                                RoomAllocation roomAllocation = new RoomAllocation();
                                roomAllocation.run();
                                break;
                            case 7:
                                System.out.println("Exiting program. Goodbye!");
                                exitProgram = true;
                                break;
                            default:
                                System.out.println("Invalid choice. Please enter a valid option.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number or type 'exit'.");
                    }
                }
            } else {
                System.out.println("No input found. Please enter a valid option.");
            }
        }

        // Döngü dışında scanner'ı kapat
        scanner.close();
    }

    private static void loginAndHandleOptions(Scanner scanner) {
        if (login(scanner)) {
            // Login successful
            handleUserOptions(scanner);
        }
    }

    private static void signUp(Scanner scanner) {
        String username = getValidUsername(scanner);
        String password = getValidPassword(scanner);
        users.put(username, password);
        System.out.println("Sign up successful!");
    }

    private static String getValidUsername(Scanner scanner) {
        while (true) {
            System.out.print("Enter your username: ");
            String username = scanner.next();
            if (!users.containsKey(username)) {
                return username;
            } else {
                System.out.println("Username already exists. Please choose another one.");
            }
        }
    }

    private static String getValidPassword(Scanner scanner) {
        System.out.print("Enter your password: ");
        return scanner.next();
    }

    private static boolean login(Scanner scanner) {
        String username = getValidUsernameForLogin(scanner);
        String password = getValidPassword(scanner);

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

    private static String getValidUsernameForLogin(Scanner scanner) {
        while (true) {
            System.out.print("Enter your username: ");
            String username = scanner.next();
            if (users.containsKey(username)) {
                return username;
            } else {
                System.out.println("Username does not exist. Please enter a valid username.");
            }
        }
    }

    private static void handleUserOptions(Scanner scanner) {
        // Login sonrası kullanıcıya ek seçenekler sun
        while (true) {
            System.out.println("1. Customer Checkout");
            System.out.println("2. Cheap Rooms");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Yeni satır karakterini tüket

                switch (choice) {
                    case 1:
                        // CustomerCheckout class
                        CustomerCheckout customerCheckout = new CustomerCheckout();
                        customerCheckout.run();
                        break;
                    case 2:
                        //  CheapRooms class
                        CheapRooms cheapRooms = new CheapRooms();
                        cheapRooms.mainMenu(scanner);
                        break;
                    case 3:
                        System.out.println("Logging out.");
                        return; // handleUserOptions döngüsünden çık
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Geçersiz girişi tüket
            }
        }
    }
}