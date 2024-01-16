package Project;

import java.awt.CardLayout;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bank {

    static String fullName;
    static long Balance;
    public static void main(String[] args) {

        //JDBC Work
        String Account = Login.AccNum;
        String pin = Login.Pin;
    
        try{
            DataBase conn = new DataBase();
            String q1 = "select * from protb2 where acc=?";
                PreparedStatement pt = conn.con.prepareStatement(q1);
                pt.setString(1, Account);
                ResultSet res = pt.executeQuery();
                res.next();
                fullName = res.getString("fullname");
                Balance = res.getLong("balance");

                System.out.println(fullName+" You have "+Balance);

        }catch(Exception ex){
            ex.printStackTrace();
        }


        JFrame frm = new JFrame("Bank");
        // CardLayout cards = new CardLayout();
        // frm.setLayout(cards);
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
        JLabel Name = new JLabel("Welcome "+fullName);
        mainPanel.add(Name);
        Name.setFont(new Font("Montserrat", Font.PLAIN, 24));
        Name.setBounds(140, 0, 500, 50);

        //Balance 
        JLabel Bal = new JLabel("Balance : "+Balance);
        mainPanel.add(Bal);
        Bal.setFont(new Font("Montserrat", Font.PLAIN, 20));
        Bal.setBounds(Name.getX(),30,200,50);

        mainPanel.add(wallLabel);
        mainPanel.add(atmLabel);
        frm.setVisible(true);

    }
}
