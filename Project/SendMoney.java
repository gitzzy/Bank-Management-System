package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Testing extends JFrame {
    private JTextField senderField, receiverField, amountField;
    private JButton sendMoneyButton;

    // JDBC database URL, username, and password of MySQL server
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ProDB";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public Testing() {
        setTitle("Money Transfer App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI();
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Sender accNo:"));
        senderField = new JTextField();
        add(senderField);

        add(new JLabel("Receiver accNo:"));
        receiverField = new JTextField();
        add(receiverField);

        add(new JLabel("Amount:"));
        amountField = new JTextField();
        add(amountField);

        sendMoneyButton = new JButton("Send Money");
        sendMoneyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMoney();
            }
        });
        add(sendMoneyButton);

        setVisible(true);
    }

    private void createUI() {
        // Set up your GUI components here
    }

    private void sendMoney() {
        String acc1 = senderField.getText();
        String acc2 = receiverField.getText();
        String amount = amountField.getText();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Update sender's balance
            String updateSenderQuery = "UPDATE protb1 SET income = income - ? WHERE acc = ?";
            try (PreparedStatement updateSenderStatement = connection.prepareStatement(updateSenderQuery)) {
                updateSenderStatement.setString(1, amount);
                updateSenderStatement.setString(2, acc1);
                updateSenderStatement.executeUpdate();
            }

            // Update receiver's balance
            String updateReceiverQuery = "UPDATE protb1 SET income = income + ? WHERE acc = ?";
            try (PreparedStatement updateReceiverStatement = connection.prepareStatement(updateReceiverQuery)) {
                updateReceiverStatement.setString(1, amount);
                updateReceiverStatement.setString(2, acc2);
                updateReceiverStatement.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Money sent successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while processing the transaction.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Testing();
            }
        });
    }
}

