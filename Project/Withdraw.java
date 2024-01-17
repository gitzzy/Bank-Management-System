package Project;

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
import javax.xml.crypto.Data;

public class Withdraw {

    static String fullName;
    static long Balance;
    static long amount;
    static String setAmnt;
    public static void main(String[] args) {



        //JDBC Work
        String Account = Login.AccNum;
    
        try{
            DataBase conn = new DataBase();
            String q1 = "select * from protb2 where acc=?";
                PreparedStatement pt = conn.con.prepareStatement(q1);
                pt.setString(1, Account);
                ResultSet res = pt.executeQuery();
                res.next();
                fullName = res.getString("fullname");
                Balance = res.getLong("balance");


        }catch(Exception ex){
            ex.printStackTrace();
        }

        
        JFrame frm = new JFrame("Withdraw Money");
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

        //Display Name
        JLabel Name = new JLabel("Welcome!!  "+fullName);
        frm.add(Name);
        Name.setFont(new Font("Montserrat", Font.PLAIN, 24));
        Name.setBounds(140, 0, 500, 50);
        Name.setForeground(Color.orange);

        //Balance 
        JLabel Bal = new JLabel("Balance : ₹"+Balance);
        frm.add(Bal);
        Bal.setFont(new Font("Montserrat", Font.PLAIN, 20));
        Bal.setBounds(Name.getX(),30,200,50);
        Bal.setForeground(Color.green);


        JLabel withAmount = new JLabel("Enter the Amount to Withdraw : ");
        withAmount.setBounds(50, 25, 350, 50);
        p1.add(withAmount);
        withAmount.setFont(new Font("Arial", Font.PLAIN, 18));
        withAmount.setForeground(Color.white);

     JTextField tf2 = new JTextField();
        p1.add(tf2);
        tf2.setBounds(50, 75, 300, 50);
        tf2.setBackground(Color.red);
        tf2.setForeground(Color.white);
        // tf1.setFont(new Font("Arial", Font.PLAIN, 18));
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
        tf2.setText("0");

        JButton btn1 = new JButton("₹100");
        JButton btn2 = new JButton("₹500");
        JButton btn3 = new JButton("₹1000");
        JButton btn4 = new JButton("₹5000");
        p1.add(btn4);
        btn4.setBounds(200,175,150,50);
        btn4.setFont(new Font("Arial", Font.BOLD, 18));
        p1.add(btn1);
        btn1.setBounds(50,125,150,50);
        btn1.setFont(new Font("Arial", Font.BOLD, 18));
        p1.add(btn2);
        btn2.setBounds(200,125,150,50);
        btn2.setFont(new Font("Arial", Font.BOLD, 18));
        p1.add(btn3);
        btn3.setBounds(50,175,150,50);
        btn3.setFont(new Font("Arial", Font.BOLD, 18));
        btn1.addActionListener(e->{
            amount = Long.parseLong(tf2.getText())+100;
            setAmnt = amount+"";
            tf2.setText(setAmnt);
        });
        btn2.addActionListener(e->{
            amount = Long.parseLong(tf2.getText())+500;
            setAmnt = amount+"";
            tf2.setText(setAmnt);
        });
        btn3.addActionListener(e->{
            amount = Long.parseLong(tf2.getText())+1000;
            setAmnt = amount+"";
            tf2.setText(setAmnt);
        });
        btn4.addActionListener(e->{
            amount = Long.parseLong(tf2.getText())+5000;
            setAmnt = amount+"";
            tf2.setText(setAmnt);
        });

        JButton withButton = new JButton("Cash Out");
        p1.add(withButton);
        withButton.setFont(new Font("Arial", Font.BOLD, 18));
        withButton.setBounds(50,250,300,50);

        //Main Working
        DataBase obj = new DataBase();
        String q1 = "update protb2 SET balance = balance - ? WHERE acc = ?";
        withButton.addActionListener(e->{
            Long Amt = Long.parseLong(tf2.getText());
           try {
            PreparedStatement pt1 = obj.con.prepareStatement(q1);
            pt1.setLong(1, Amt); // Use setLong for balance update
            pt1.setString(2, Account);
            pt1.executeUpdate();
            JOptionPane.showMessageDialog(null, "₹"+Amt+" Successfully Debited from your Account.");
           } catch (Exception ex) {
            JOptionPane.showMessageDialog(null , "Failed to Withdraw Money.");
           }
        });
        

        frm.add(atmLabel);
        frm.setVisible(true);
    }
}
