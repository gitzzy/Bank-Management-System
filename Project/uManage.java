package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class uManage {
    public static int Count;

    public static void main(String[] args) {
        Count = 0;
        JFrame frm = new JFrame("Manage Users");
        frm.setSize(600, 630);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(350, 100);

        ImageIcon exitIcon = new ImageIcon("Media/Exit.png");
        JButton exitButton = new JButton(exitIcon);
        frm.add(exitButton);
        exitButton.setBounds(520, 10, 50, 50);
        exitButton.addActionListener(e -> {
            aHome.main(args);
            frm.dispose();
        });

        // COunt Value
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> acc = new ArrayList<>();
        ArrayList<String> pin = new ArrayList<>();
        ArrayList<Long> bal = new ArrayList<>();
        ArrayList<String> stats = new ArrayList<>();

        DataBase obj = new DataBase();
        try {
            String q1 = "select * from protb2";
            PreparedStatement pt = obj.con.prepareStatement(q1);
            ResultSet res = pt.executeQuery();

            while (res.next()) {
                Count += 1;
                name.add(res.getString("fullname"));
                acc.add(res.getString("acc"));
                pin.add(res.getString("pin"));
                bal.add(res.getLong("balance"));
                stats.add(res.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel frm1 = new JPanel();
        frm1.setLayout(new BorderLayout());
        frm.add(frm1);
        frm1.setBounds(0, 70, 600, 400);
        JScrollPane sPane = new JScrollPane();
        sPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JPanel sPanel = new JPanel(new GridLayout(Count, 1, 0, 5));
        sPane.setViewportView(sPanel);

        // Diplay part
        JLabel[] lbl = new JLabel[Count];
        JPanel[] pnl = new JPanel[Count];
        JLabel[] lbal = new JLabel[Count];
        JLabel[] lacc = new JLabel[Count];
        JLabel[] lpin = new JLabel[Count];
        JPanel[] pstat = new JPanel[Count];
        for (int i = 0; i < Count; i++) {
            pnl[i] = new JPanel();
            pnl[i].setPreferredSize(new Dimension(100, 110));
            sPanel.add(pnl[i]);
            pnl[i].setLayout(null);
            pnl[i].setBackground(Color.darkGray);

            lbl[i] = new JLabel("Name      :  " + name.get(i));
            pnl[i].add(lbl[i]);
            lbl[i].setForeground(Color.white);
            lbl[i].setFont(new Font("American Typewriter", Font.PLAIN, 18));
            lbl[i].setBounds(10, 0, 500, 30);

            lbal[i] = new JLabel("Balance   :  " + bal.get(i));
            pnl[i].add(lbal[i]);
            lbal[i].setForeground(Color.white);
            lbal[i].setFont(new Font("American Typewriter", Font.PLAIN, 18));
            lbal[i].setBounds(10, 25, 500, 30);

            lacc[i] = new JLabel("Account   :  " + acc.get(i));
            pnl[i].add(lacc[i]);
            lacc[i].setForeground(Color.white);
            lacc[i].setFont(new Font("American Typewriter", Font.PLAIN, 18));
            lacc[i].setBounds(10, 50, 500, 30);

            lpin[i] = new JLabel("Passcode :  " + pin.get(i));
            pnl[i].add(lpin[i]);
            lpin[i].setForeground(Color.white);
            lpin[i].setFont(new Font("American Typewriter", Font.PLAIN, 18));
            lpin[i].setBounds(10, 75, 500, 30);

            pstat[i] = new JPanel();
            pnl[i].add(pstat[i]);
            pstat[i].setForeground(Color.white);
            pstat[i].setFont(new Font("American Typewriter", Font.PLAIN, 18));
            pstat[i].setBounds(520, 40, 30, 30);

            if (stats.get(i).equals("Active")) {
                pstat[i].setBackground(Color.green);
            } else if (stats.get(i).equals("Blocked")) {
                pstat[i].setBackground(Color.red);
            } else if (stats.get(i).equals("InActive")) {
                pstat[i].setBackground(Color.black);
            } else {
                pstat[i].setBackground(Color.black);
            }
        }

        JLabel head = new JLabel("Manage Users");
        frm.add(head);
        head.setBounds(20, 10, 250, 50);
        head.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        JLabel lbl2 = new JLabel("Select User : ");
        frm.add(lbl2);
        lbl2.setBounds(20, 470, 200, 50);

        JComboBox<String> cb1 = new JComboBox<>();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (String element : acc) {
            model.addElement(element);
        }

        cb1.setModel(model);
        frm.add(cb1);
        cb1.setBounds(10, 500, 200, 50);
        cb1.setFont(new Font("American Typewriter", Font.PLAIN, 18));

        JLabel lbl3 = new JLabel("Choose Action : ");
        frm.add(lbl3);
        lbl3.setBounds(250, 470, 200, 50);
        lbl3.setFont(new Font("American Typewriter", Font.PLAIN, 18));
        lbl2.setFont(new Font("American Typewriter", Font.PLAIN, 18));

        String[] ele = { "Active", "InActive", "Blocked" };
        JComboBox<String> cb2 = new JComboBox<>(ele);
        frm.add(cb2);
        cb2.setBounds(250, 500, 200, 50);
        cb2.setFont(new Font("American Typewriter", Font.PLAIN, 18));
        lbl2.setForeground(Color.red);
        lbl3.setForeground(Color.red);
        cb2.setForeground(Color.red);
        cb1.setForeground(Color.red);

        JButton commit = new JButton("Commit");
        frm.add(commit);
        commit.setBounds(20, 540, 100, 50);
        commit.addActionListener(e -> {
            String q0 = "UPDATE protb2 SET status = ? WHERE acc =?;";

            try {
                PreparedStatement pt0 = obj.con.prepareStatement(q0);
                pt0.setString(1, (String) cb2.getSelectedItem());
                pt0.setString(2, (String) cb1.getSelectedItem());
                pt0.executeUpdate();
                JOptionPane.showMessageDialog(null,
                        (String) cb1.getSelectedItem() + " is " + (String) cb2.getSelectedItem() + " now.");
                        uManage.main(args);
                        frm.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        frm1.add(sPane, BorderLayout.CENTER);
        frm.setVisible(true);
    }
}
