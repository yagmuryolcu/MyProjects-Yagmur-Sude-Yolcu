import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MovieDetail extends JFrame {
    private JPanel MovieD;
    private JButton CONTINUEButton;
    private JTextField tfMovies;
    private JTextField tfTimeDate;
    private JTextField tfNumbOfTickets;

    public MovieDetail() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 490));
        setResizable(false);

        setContentPane(MovieD);

        CONTINUEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movieUser();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void movieUser() {
        String movie = tfMovies.getText();
        String datetime1 = tfTimeDate.getText();
        String tickets = tfNumbOfTickets.getText();

        if (movie.isEmpty() || datetime1.isEmpty() || tickets.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all fields",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (addMovieToDatabase(movie, datetime1, tickets)) {
            JOptionPane.showMessageDialog(this,
                    "Movie registered successfully",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            Payment payment = new Payment();
            payment.setVisible(true);
            dispose();

        } else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register the movie",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean addMovieToDatabase(String movie, String datetime1, String tickets) {
        final String DB_URL = "jdbc:mysql://localhost:3306/20200305036?useSSL=false";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS movies (id INT AUTO_INCREMENT PRIMARY KEY, movie VARCHAR(100), datetime1 VARCHAR(100), tickets VARCHAR(50))";
            try (Statement statement = conn.createStatement()) {
                statement.executeUpdate(createTableQuery);
            }

            String insertQuery = "INSERT INTO movies (movie, datetime1, tickets) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, movie);
                preparedStatement.setString(2, datetime1);
                preparedStatement.setString(3, tickets);

                int addedRows = preparedStatement.executeUpdate();
                return addedRows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MovieDetail();
            }
        });
    }
}