import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer extends Person {
    private LocalDate checkInDate;

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Customer(String firstName, String lastName, String phoneNumber, String email, String gender, LocalDate checkInDate) {
        super(firstName, lastName, phoneNumber, email, gender);
        this.checkInDate = checkInDate;


    }
}
