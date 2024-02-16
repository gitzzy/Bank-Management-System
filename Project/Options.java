package Project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Options {

    static boolean AccExists;
    static long sendAmount;
    static long bal;

    public static void main(String[] args) {

        JFrame frm = new JFrame();
        frm.setSize(1000, 700);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(200, 50);
        frm.setLayout(null);

        ImageIcon logo = new ImageIcon("Media/Bank.jpg");
        JLabel atmLabel = new JLabel(logo);
        frm.add(atmLabel);
        atmLabel.setBounds(0, 0, 1000, 700);

        CardLayout crd = new CardLayout();
        // Main Panel
        JPanel mainPanel = new JPanel();
        frm.add(mainPanel);
        mainPanel.setBounds(138, 90, 690, 370);
        mainPanel.setBackground(Color.red);
        mainPanel.setLayout(crd);

        // Marks
        // the
        // Begning

        // Money Sending Panel

        JPanel p1 = new JPanel();
        mainPanel.add(p1, "crd1");
        JTextField tf1 = new JTextField();
        p1.setBackground(Color.black);
        p1.setLayout(null);
        p1.add(tf1);
        tf1.setBounds(50, 75, 300, 50);
        tf1.setBackground(Color.red);
        tf1.setForeground(Color.white);

        JLabel l1 = new JLabel("Enter the Receiver's \nAccount Number : ");
        l1.setBounds(50, 25, 350, 50);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Arial", Font.PLAIN, 18));
        p1.add(l1);

        JLabel l2 = new JLabel("Enter Amount :");
        p1.add(l2);
        l2.setBounds(50, 150, 350, 50);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Arial", Font.PLAIN, 18));

        JTextField tf2 = new JTextField();
        p1.add(tf2);
        tf2.setBounds(50, 200, 300, 50);
        tf2.setBackground(Color.red);
        tf2.setForeground(Color.white);
        tf1.setFont(new Font("Arial", Font.PLAIN, 18));
        tf2.setFont(new Font("Arial", Font.PLAIN, 18));
        tf2.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ignore the input if it's not a digit or backspace
                    JOptionPane.showMessageDialog(null, "Please enter Valid Amount.");
                }
            }

        });

        JButton sendButton = new JButton("Send Money");
        p1.add(sendButton);
        sendButton.setBounds(50, 300, 200, 50);
        sendButton.setFont(new Font("Arial", Font.BOLD, 18));

        ImageIcon exitIcon = new ImageIcon("Media/Exit2.png");
        JButton exiButton = new JButton(exitIcon);
        p1.add(exiButton);
        exiButton.setBounds(450, 300, 200, 50);
        exiButton.addActionListener(e -> {
            frm.dispose();
            Bank.main(args);
        });

        // Displaying Balance
        bal = Bank.Balance;
        JLabel balLabel = new JLabel("Balance :");
        p1.add(balLabel);
        balLabel.setBounds(520, 25, 150, 50);
        balLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        balLabel.setForeground(Color.green);

        JLabel balLabel2 = new JLabel("₹ " + bal);
        p1.add(balLabel2);
        balLabel2.setBounds(540, 50, 150, 50);
        balLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        balLabel2.setForeground(Color.green);

        // JDBC Part
        DataBase obj = new DataBase();

        // Receiver's Balance INC
        String q1 = "update protb2 SET balance = balance + ? WHERE acc = ?";
        // Sender's Balance DEC
        String q2 = "update protb2 SET balance = balance - ? WHERE acc = ?";

        // Account Exists or not
        String q3 = "select * from protb2 where acc = ?";
        sendButton.addActionListener(e -> {
            String sndAccount = tf1.getText();
            String sendAmountStr = tf2.getText();

            // Additional check for numeric amount
            if (!isNumeric(sendAmountStr)) {
                JOptionPane.showMessageDialog(null, "Please enter a valid Amount.");
                return;
            }

            sendAmount = Long.parseLong(sendAmountStr);
            String sender = Login.AccNum;

            if (sndAccount.equals(sender)) {
                JOptionPane.showMessageDialog(null, "You Cannot send Money to your own Account.");
            } else if (sndAccount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the Receiver's Account Number.");
            } else if (sendAmount <= 0) {
                JOptionPane.showMessageDialog(null, "Please enter Amount more than 0.\n:(");
            } else if (sendAmount > bal) {
                JOptionPane.showMessageDialog(null, "You don't have sufficient balance.");
            } else {
                try {
                    // Check if the account exists
                    PreparedStatement pt0 = obj.con.prepareStatement(q3);
                    pt0.setString(1, sndAccount);
                    ResultSet res = pt0.executeQuery();
                    AccExists = res.next();

                    if (!AccExists) {
                        JOptionPane.showMessageDialog(null, sndAccount + "'s Account Does not Exist");
                        return;
                    }

                    // Update the sender's and receiver's balances
                    PreparedStatement pt1 = obj.con.prepareStatement(q1);
                    pt1.setLong(1, sendAmount); // Use setLong for balance update
                    pt1.setString(2, sndAccount);
                    pt1.executeUpdate();

                    PreparedStatement pt2 = obj.con.prepareStatement(q2);
                    pt2.setLong(1, sendAmount);
                    pt2.setString(2, sender);
                    pt2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Money Sent Successfully.");
                    bal = bal - sendAmount;
                    balLabel2.setText("₹ " + bal);
                    p1.repaint();
                    tf1.setText("");
                    tf2.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Failed to Send Money.");
                    ex.printStackTrace();
                }
            }

        });

        frm.add(atmLabel);
        frm.setVisible(true);
    }

    private static boolean isNumeric(String str) {
        try {
            // Invert the logic: return false if the string is numeric
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
