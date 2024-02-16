package Project;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bank {

    static String fullName;
    static long Balance;
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


        JFrame frm = new JFrame("Bank");
        frm.setSize(1000, 700);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(200, 50);
        frm.setLayout(null);

        // Main Frame
        JPanel mainPanel = new JPanel();
        ImageIcon logo = new ImageIcon("Media/Bank.jpg");
        JLabel atmLabel = new JLabel(logo);
        frm.add(mainPanel);
        mainPanel.setBounds(0, 0, 1000, 700);
        mainPanel.setLayout(null);
        atmLabel.setBounds(0, 0, 1000, 700);

        // Mid WallPaper
        ImageIcon wallIcon = new ImageIcon("Media/wall1.jpg");
        JLabel wallLabel = new JLabel(wallIcon);
        wallLabel.setBounds(140, 90, 690, 370);


        // Name
        JLabel Name = new JLabel("Welcome!!  "+fullName);
        mainPanel.add(Name);
        Name.setFont(new Font("Montserrat", Font.PLAIN, 24));
        Name.setBounds(140, 0, 500, 50);
        Name.setForeground(Color.orange);

        //Balance 
        JLabel Bal = new JLabel("Balance : ₹"+Balance);
        mainPanel.add(Bal);
        Bal.setFont(new Font("Montserrat", Font.PLAIN, 20));
        Bal.setBounds(Name.getX(),30,500,50);
        Bal.setForeground(Color.green);

        //Send Money
        JButton sndMoney = new JButton("Send Money");
        mainPanel.add(sndMoney);
        sndMoney.setBounds(200,150,200,50);
        sndMoney.addActionListener(e->{
            frm.dispose();
            Options.main(args);
        });

        //Withdraw
        JButton drawButton = new JButton("Withdraw");
        mainPanel.add(drawButton);
        drawButton.setBounds(200,225,200,50);
        drawButton.addActionListener(e->{
            frm.dispose();
            Withdraw.main(args);
        });

        //Deposit 
        JButton depositBtn = new JButton("Deposit");
        mainPanel.add(depositBtn);
        depositBtn.setBounds(200,300,200,50);
        depositBtn.addActionListener(e ->{
            frm.dispose();
            Deposit.main(args);
        });

        //Balance
        JButton balButton = new JButton("History");
        mainPanel.add(balButton);
        balButton.setBounds(500,150,200,50);

        //Change Pin
        JButton cngPin = new JButton("Change Pin");
        mainPanel.add(cngPin);
        cngPin.setBounds(500,225,200,50);
        cngPin.addActionListener(e ->{
            frm.dispose();
            ChngPin.main(args);
        });

        //Exit Button
        ImageIcon exitIcon = new ImageIcon("Media/Exit2.png");
        JButton exiButton = new JButton(exitIcon);
        mainPanel.add(exiButton);
        exiButton.setBounds(500,375,200,50);
        exiButton.addActionListener(e ->{
            frm.dispose();
            Login.main(args);
        });


        // mainPanel.add(wallLabel);
        mainPanel.add(atmLabel);
        frm.setVisible(true);

    }
}
