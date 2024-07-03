import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomAllocation {
    private ArrayList<Customer> customers;

    public RoomAllocation() {
        this.customers = new ArrayList<>();
        initializeCustomers();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    private void initializeCustomers() {
        customers.add(new Customer("John", "Doe", "123456789", "john.doe@example.com", "Male", LocalDate.of(2023, 12, 28)));
        customers.add(new Customer("Jane", "Smith", "987654321", "jane.smith@example.com", "Female", LocalDate.of(2023, 12, 24)));
        customers.add(new Customer("Bob", "Johnson", "56986953266", "bob.johnson@example.com", "Male", LocalDate.of(2024, 1, 20)));
        customers.add(new Customer("Suzy", "Brown", "55565492315", "suzy.brown@example.com", "Female", LocalDate.of(2024, 1, 8)));
        customers.add(new Customer("Jack", "Noah", "5551112233", "jack.noah@example.com", "Male", LocalDate.of(2023, 2, 10)));
        customers.add(new Customer("Allison", "Murphy", "5368597458", "allison.murphy@example.com", "Female", LocalDate.of(2024, 2, 7)));
        customers.add(new Customer("Jessica", "Miller", "5274859612", "jessica.miller@example.com", "Female", LocalDate.of(2024, 2, 11)));
        customers.add(new Customer("Katherina", "Thomas", "522585457", "katherina.thomas@example.com", "Female", LocalDate.of(2024, 3, 15)));
        customers.add(new Customer("David", "Wilson", "222333555", "david.wilson@example.com", "Male", LocalDate.of(2024, 3, 19)));
        customers.add(new Customer("Olivia", "Byrne", "1112525655", "olivia.byrne@example.com", "Female", LocalDate.of(2024, 4, 24)));
        customers.add(new Customer("Emily", "Garcia", "8887775565", "emily.garcia@example.com", "Female", LocalDate.of(2024, 4, 26)));
    }

    public void displayCustomerInformation() {
        System.out.printf("%-15s%-15s%-15s%-30s%-10s%-15s\n", "First Name", "Last Name", "Phone Number", "Email", "Gender", "Check-In Date");

        for (Customer customer : customers) {
            System.out.printf("%-15s%-15s%-15s%-30s%-10s%-15s\n",
                    customer.getFirstName(), customer.getLastName(),
                    customer.getPhoneNumber(), customer.getEmail(),
                    customer.getGender(), formatCheckInDate(customer.getCheckInDate()));
        }
    }

    private void addCustomerFromUserInput(Scanner scanner) {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Check-In Date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        LocalDate checkInDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Customer newCustomer = new Customer(firstName, lastName, phoneNumber, email, gender, checkInDate);
        addCustomer(newCustomer);

        System.out.println("Customer added successfully!");
    }

    private String formatCheckInDate(LocalDate checkInDate) {
        return checkInDate != null ? checkInDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : "N/A";
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCANDLES RESORT ROOM ALLOCATION");
            displayCustomerInformation();

            System.out.println("1. Add Customer");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        // Add Customer
                        addCustomerFromUserInput(scanner);
                        break;
                    case 2:
                        System.out.println("Exiting Room Allocation. Goodbye!");
                        scanner.close(); // Close the scanner here
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    public static void main(String[] args) {
        RoomAllocation roomAllocation = new RoomAllocation();
        roomAllocation.run();
    }
}