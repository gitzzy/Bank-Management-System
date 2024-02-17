package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class History {

    public static int Count;

    public static void main(String[] args) {
        JFrame frm = new JFrame("Bank");
        frm.setSize(1000, 700);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(200, 50);
        frm.setLayout(null);

        // Main Frame
        JPanel mainPanel = new JPanel();
        ImageIcon logo = new ImageIcon("Media/Bank.jpg");
        JLabel atmLabel = new JLabel(logo);

        mainPanel.setBounds(0, 0, 1000, 700);
        mainPanel.setLayout(null);
        atmLabel.setBounds(0, 0, 1000, 700);
        mainPanel.add(atmLabel);

        String Acc1 = Login.AccNum;
        String q1 = "select * from history where user1=?";

        ArrayList<String> usr1 = new ArrayList<>();
        ArrayList<String> usr2 = new ArrayList<>();
        ArrayList<Long> Amnt = new ArrayList<>();
        ArrayList<String> Act = new ArrayList<>();
        ArrayList<String> dates = new ArrayList<>();
        try {
            DataBase obj = new DataBase();
            PreparedStatement pt0 = obj.con.prepareStatement(q1);
            pt0.setString(1, "vishal");
            // pt0.setString(2, Acc1);
            ResultSet rs = pt0.executeQuery();

            while (rs.next()) {
                Count += 1;
                usr1.add(rs.getString("user1"));
                usr2.add(rs.getString("user2"));
                Amnt.add(rs.getLong("amount"));
                Act.add(rs.getString("action"));
                dates.add(rs.getString("date_added"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "There Was Problem in fetching " + Acc1 + " Details");
        }

        JScrollPane sPane = new JScrollPane();
        sPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel p1 = new JPanel(new GridLayout(Count, 1, 0, 5));
        sPane.setViewportView(p1);
        sPane.setBounds(137, 87 + 75, 690, 300);
        p1.setBackground(Color.white);

        JPanel[] pnl = new JPanel[Count];

        for (int i = 0; i < Count; i++) {
            pnl[i] = new JPanel();
            pnl[i].setPreferredSize(new Dimension(100, 50));
            p1.add(pnl[i]);
            pnl[i].setLayout(null);
            pnl[i].setBackground(Color.green);

            JLabel label = new JLabel();
            label.setBounds(10, 15, 490, 25);
            pnl[i].add(label);
            label.setFont(new Font("Signboard",Font.PLAIN,15));

            JLabel dLab = new JLabel();
            dLab.setBounds(500, 10, 200, 20);
            pnl[i].add(dLab);
            dLab.setText(dates.get(i));
            dLab.setFont(new Font("Signboard",Font.PLAIN,15));

            if (Act.get(i).equals("Deposited")) {
                label.setText("You Deposited ₹" + Amnt.get(i) + " via Cash");

            } else if (Act.get(i).equals("Withdrawn")) {
                label.setText("You Withdrawn ₹" + Amnt.get(i) + " via Cash");

            } else if (Act.get(i).equals("Sent")) {
                label.setText(usr1.get(i) + " " + Act.get(i)
                        + " ₹" + Amnt.get(i) + " to " + usr2.get(i));
            }

            else {
                label.setText(usr1.get(i) + " " + Act.get(i)
                        + " ₹" + Amnt.get(i) + " from " + usr2.get(i));
            }


        }

        frm.add(sPane);
        frm.add(mainPanel);
        frm.setVisible(true);
    }
}
