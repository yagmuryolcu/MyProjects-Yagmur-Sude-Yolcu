
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;



public class SignUpScreen extends JFrame {
    private JButton btnLogIn;
    private JButton btnCancel;
    private JPanel signUpPanel;
    private JTextField tfName;
    private JTextField tfEmail;
    private JTextField tfPhone;
    private JTextField tfAddress;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPassword;
    private JFrame frame;

    public SignUpScreen() {
        frame = new JFrame("SignUp Frame");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 450));
        frame.setResizable(false);

        frame.add(signUpPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();

            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        setVisible(true);
    }

    private void registerUser() {
        String name = tfName.getText();
        String email = tfEmail.getText();
        String phone = tfPhone.getText();
        String address = tfAddress.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String confirmPassword = String.valueOf(pfConfirmPassword.getPassword());


        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all fields",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Confirm Password does not match",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (addUserToDatabase(name, email, phone, address, password)) {
            JOptionPane.showMessageDialog(this,
                    "User registered successfully",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
            LogInScreen f1 = new LogInScreen();
            f1.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register new user",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean addUserToDatabase(String name, String email, String phone, String address, String password) {
        final String DB_URL = "jdbc:mysql://localhost:3306/20200305036?useSSL=false";
        final String USERNAME = "root";
        final String PASSWORD = "";


        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String createTableQuery = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200), email VARCHAR(200), phone VARCHAR(200), address VARCHAR(200), password VARCHAR(200))";
            Statement statement = conn.createStatement();
            statement.executeUpdate(createTableQuery);

            String insertQuery = "INSERT INTO users (name, email, phone, address, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, password);

            int addedRows = preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

            return addedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        SignUpScreen signupScreen = new SignUpScreen();
        //signupForm.setVisible(true);
    }
}
