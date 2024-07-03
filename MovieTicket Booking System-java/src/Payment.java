import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Payment extends JFrame {
    private JTextField tfCardNumber;
    private JTextField tfHolderName;
    private JTextField tfCvv;
    private JPanel jpPayment;
    private JButton btnCancel;
    private JTextField tfEx;


    public Payment() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 490));
        setResizable(false);
        setContentPane(jpPayment);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paymentUser();
            }
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void paymentUser() {
        String card = tfCardNumber.getText();
        String holder = tfHolderName.getText();
        String cvv = tfCvv.getText();
        String exp = tfEx.getText();

        if (card.isEmpty() || holder.isEmpty() || cvv.isEmpty() || exp.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all fields",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (addPaymentToDatabase(card, holder, cvv, exp)) {
            JOptionPane.showMessageDialog(this,
                    "Payment registered successfully",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register the payment",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean addPaymentToDatabase(String card, String holder, String cvv, String exp) {
        final String DB_URL = "jdbc:mysql://localhost:3306/20200305036?useSSL=false";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String createTableQuery = "CREATE TABLE IF NOT EXISTS payment (id INT AUTO_INCREMENT PRIMARY KEY, card VARCHAR(100), holder VARCHAR(60), cvv VARCHAR(6), exp VARCHAR(60))";
            Statement statement = conn.createStatement();
            statement.executeUpdate(createTableQuery);

            String insertQuery = "INSERT INTO payment (card, holder, cvv, exp) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, card);
            preparedStatement.setString(2, holder);
            preparedStatement.setString(3, cvv);
            preparedStatement.setString(4, exp);

            int addedRows = preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

            return addedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Payment();

            }
        });
    }
}