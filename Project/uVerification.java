package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class uVerification {
    static boolean check;
    static int ii;
    static int a;

    public static void main(String[] args) {

        JFrame frm = new JFrame("User's Application");
        frm.setSize(500, 530);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(350, 100);
        int Count = 0;

        JLabel text = new JLabel("Pending Applications");
        text.setFont(new Font("American Typewriter",Font.PLAIN,26));
        frm.add(text);
        text.setBounds(10,20,300,50);

        ImageIcon exitIcon = new ImageIcon("Media/Exit.png");
        JButton exitButton = new JButton(exitIcon);
        frm.add(exitButton);
        exitButton.setBounds(420, 25, 50, 50);
        exitButton.addActionListener(e -> {
            aHome.main(args);
            frm.dispose();
        });

        JPanel frm1 = new JPanel();
        frm1.setLayout(new BorderLayout());
        frm.add(frm1);
        frm1.setBounds(0,100,500,400);
        JScrollPane sPane = new JScrollPane();
        sPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel sPanel = new JPanel(new GridLayout(Count, 1, 0, 5));
        sPane.setViewportView(sPanel);

        ArrayList<String> ar1 = new ArrayList<>();
        ArrayList<String> phn = new ArrayList<>();
        ArrayList<String> mail = new ArrayList<>();
        ArrayList<String> sDob = new ArrayList<>();
        ArrayList<String> acc = new ArrayList<>();
        ArrayList<String> pin = new ArrayList<>();

        DataBase obj = new DataBase();
        try {
            String q1 = "select * from admin1";
            PreparedStatement pt0 = obj.con.prepareStatement(q1);
            ResultSet rs = pt0.executeQuery();
            while (rs.next()) {
                Count += 1;
                ar1.add(rs.getString("full_Name"));
                phn.add(rs.getString("Phone"));
                mail.add(rs.getString("mail"));
                sDob.add(rs.getString("dob"));
                acc.add(rs.getString("acc"));
                pin.add(rs.getString("pin"));


            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JButton[] btn = new JButton[Count];
        JPanel[] pnl = new JPanel[Count];
        JButton[] btns = new JButton[Count];
        JLabel[] lbl = new JLabel[Count];
        JLabel[] Name = new JLabel[Count];
        JLabel[] Phone = new JLabel[Count];
        JLabel[] Mail = new JLabel[Count];

        JLabel[] Dob = new JLabel[Count];

        // String[] acc = new String[Count];

        for (int i = 0; i < Count; i++) {

            a=i;
            pnl[i] = new JPanel();
            pnl[i].setPreferredSize(new Dimension(100, 100));
            sPanel.add(pnl[i]);
            pnl[i].setLayout(null);

            btn[i] = new JButton("Approve");
            pnl[i].add(btn[i]);
            btn[i].setBounds(400, 0, 80, 50);

            btns[i] = new JButton("Deny");
            pnl[i].add(btns[i]);
            btns[i].setBounds(400, 50, 80, 50);

            lbl[i] = new JLabel("Application : " + (i + 1));
            pnl[i].add(lbl[i]);
            lbl[i].setBounds(5, -10, 100, 50);
            lbl[i].setForeground(Color.white);

            Name[i] = new JLabel("Name : " + ar1.get(i));
            // ar1.removeFirst();
            pnl[i].add(Name[i]);
            Name[i].setBounds(5, 10, 300, 50);
            Name[i].setForeground(Color.green);

            Phone[i] = new JLabel("Phone : " + phn.get(i));
            pnl[i].add(Phone[i]);
            Phone[i].setBounds(5, 25, 300, 50);
            Phone[i].setForeground(Color.green);

            Mail[i] = new JLabel("Mail : " + mail.get(i));
            pnl[i].add(Mail[i]);
            Mail[i].setBounds(5, 40, 300, 50);
            Mail[i].setForeground(Color.green);

            Dob[i] = new JLabel("DOB : " + sDob.get(i));
            pnl[i].add(Dob[i]);
            Dob[i].setBounds(5, 55, 300, 50);
            Dob[i].setForeground(Color.green);

            if (i % 2 == 0) {
                pnl[i].setBackground(Color.black);
            } else {
                pnl[i].setBackground(Color.black);
            }

        }
       if(Count>0){
        ii = 0;
        btn[ii].addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "You Have Approved : "+ar1.get(ii));
            String q2 = "delete from admin1 where acc=?";
            String q3 = "insert into protb2 (fullname, acc, pin, balance, status)values(?,?,?,?,?)";
            try{
                PreparedStatement pt = obj.con.prepareStatement(q2);
                PreparedStatement pt1 = obj.con.prepareStatement(q3);
                pt.setString(1, acc.get(ii));
                pt1.setString(1, ar1.get(ii));
                pt1.setString(2, acc.get(ii));
                pt1.setString(3, pin.get(ii));
                pt1.setString(4, "0");
                pt1.setString(5, "Active");
                pt.executeUpdate();
                pt1.executeUpdate();
                
            }
            catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "There was error while Approving User.");
            }
            frm.dispose();
                uVerification.main(args);
        });
        btns[ii].addActionListener(e -> {
            JOptionPane.showMessageDialog(null, ar1.get(ii)+" is Rejected.");
            String q2 = "delete from admin1 where acc=?";
            String q3 = "delete from protb1 where acc=?";
            try{
                PreparedStatement pt = obj.con.prepareStatement(q2);
                pt.setString(1, acc.get(ii));
                pt.executeUpdate();
                PreparedStatement pt00 = obj.con.prepareStatement(q3);
                pt.setString(1, acc.get(ii));
                pt00.executeUpdate();
                
            }
            catch(Exception ex){
                ex.printStackTrace();
                // JOptionPane.showMessageDialog(null, "There was error while Approving User.");
            }
            frm.dispose();
                uVerification.main(args);
        });
       }
       

        frm1.add(sPane, BorderLayout.CENTER);

        frm.setVisible(true);
    }
}
