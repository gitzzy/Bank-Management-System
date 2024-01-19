package Project;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChngPin {

    static String fullName;
    static long Balance;
    static String Pin;
    static String nPin;
    static String nPin2;
    static DataBase conn;

    public static void main(String[] args) {
        // JDBC Work
        String Account = Login.AccNum;
        Pin = Login.Pin;

        try {
            conn = new DataBase();
            String q1 = "select * from protb2 where acc=?";
            PreparedStatement pt = conn.con.prepareStatement(q1);
            pt.setString(1, Account);
            ResultSet res = pt.executeQuery();
            res.next();
            fullName = res.getString("fullname");
            Balance = res.getLong("balance");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JFrame frm = new JFrame("Change Pin");
        frm.setSize(1000, 700);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(200, 50);
        frm.setLayout(null);

        // ATM Wallpaper
        ImageIcon logo = new ImageIcon("Media/Bank.jpg");
        JLabel atmLabel = new JLabel(logo);
        atmLabel.setBounds(0, 0, 1000, 700);

        // Main Panel

        JPanel p1 = new JPanel();
        frm.add(p1);
        p1.setBackground(Color.black);
        p1.setLayout(null);
        p1.setBounds(138, 90, 690, 370);

        ImageIcon exitIcon = new ImageIcon("Media/Exit2.png");
        JButton exiButton = new JButton(exitIcon);
        p1.add(exiButton);
        exiButton.setBounds(450, 300, 200, 50);
        exiButton.addActionListener(e -> {
            frm.dispose();
            Bank.main(args);
        });

        // Display Name
        JLabel Name = new JLabel("Welcome!!  " + fullName);
        frm.add(Name);
        Name.setFont(new Font("Montserrat", Font.PLAIN, 24));
        Name.setBounds(140, 0, 500, 50);
        Name.setForeground(Color.orange);

        // Balance
        JLabel Bal = new JLabel("Balance : ₹" + Balance);
        frm.add(Bal);
        Bal.setFont(new Font("Montserrat", Font.PLAIN, 20));
        Bal.setBounds(Name.getX(), 30, 500, 50);
        Bal.setForeground(Color.green);

        JLabel cgPin = new JLabel("Change Pin");
        p1.add(cgPin);
        cgPin.setBounds(250, 0, 300, 50);
        cgPin.setForeground(Color.white);
        cgPin.setFont(new Font("Montserrat", Font.PLAIN, 32));

        JLabel l1 = new JLabel("Enter New Pin : ");
        p1.add(l1);
        l1.setBounds(50, 75, 300, 50);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Montserrat", Font.PLAIN, 18));

        JTextField tf1 = new JTextField();
        p1.add(tf1);
        tf1.setBounds(50, 125, 300, 50);
        tf1.setBackground(Color.red);
        tf1.setForeground(Color.white);
        tf1.setFont(new Font("Montserrat", Font.PLAIN, 18));

        JLabel l2 = new JLabel("Re-Enter Pin : ");
        p1.add(l2);
        l2.setBounds(50, 175, 300, 50);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Montserrat", Font.PLAIN, 18));

        JTextField tf2 = new JTextField();
        p1.add(tf2);
        tf2.setBounds(50, 225, 300, 50);
        tf2.setBackground(Color.red);
        tf2.setForeground(Color.white);
        tf2.setFont(new Font("Montserrat", Font.PLAIN, 18));

        JButton chngButton = new JButton("Change Pin");
        p1.add(chngButton);
        chngButton.setBounds(50, 300, 200, 50);
        chngButton.setFont(new Font("Montserrat", Font.PLAIN, 18));

        chngButton.addActionListener(e -> {
            nPin = tf1.getText();
            nPin2 = tf2.getText();

            if (!nPin.equals(nPin2)) {
                JOptionPane.showMessageDialog(null, "Pin doesn't Match");
            } else if (nPin.equals("")) {
                JOptionPane.showMessageDialog(null, "You can't leave fields empty.");
            } else if (nPin.equals("")) {
                JOptionPane.showMessageDialog(null, "You can't leave fields empty.");
            } else if (nPin.equals(Pin)) {
                JOptionPane.showMessageDialog(null, "Error : Pin is already in use.\nChoose different Pin");
            } else {
                try {
                    String q2 = "update protb1 set pin =? where acc=?";
                    String q3 = "update protb2 set pin =? where acc=?";
                    PreparedStatement pt1 = conn.con.prepareStatement(q2);
                    PreparedStatement pt2 = conn.con.prepareStatement(q3);
                    pt1.setString(1, nPin);
                    pt1.setString(2, Account);
                    pt2.setString(1, nPin);
                    pt2.setString(2, Account);
                    pt1.executeUpdate();
                    pt2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Pin successfully changed.");
                    frm.dispose();
                    Login.main(args);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to change Pin.");
                }
            }
        });

        frm.add(atmLabel);
        frm.setVisible(true);
    }
}
