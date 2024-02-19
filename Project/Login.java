package Project;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class Login {
    static String AccNum;
    static String Pin;
    public static void main(String[] args) {
        JFrame frm = new JFrame("Bank");
        frm.setSize(800, 600);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(200, 100);
        frm.setLayout(null);

        ImageIcon img1 = new ImageIcon("Media/Bank.png");
        // Image img11 = img1.getImage().getScaledInstance(300, 200,
        // Image.SCALE_DEFAULT);
        JLabel l1 = new JLabel(img1);
        l1.setBounds(0, 50, 300, 200);
        frm.add(l1);

        // welcome Text
        JLabel txt1 = new JLabel("Welcome");
        JLabel txt2 = new JLabel("To");
        txt1.setFont(new Font("Montserrat", Font.BOLD, 40));
        txt2.setFont(new Font("Montserrat", Font.BOLD, 36));
        txt1.setForeground(Color.red);
        txt2.setForeground(Color.BLACK);

        // Monopoly Image
        ImageIcon monoIcon = new ImageIcon("Media/Mono2.png");
        JLabel txt3 = new JLabel(monoIcon);
        frm.add(txt3);
        frm.add(txt1);
        frm.add(txt2);
        txt1.setBounds(455, 10, 500, 50);
        txt2.setBounds(520, 55, 500, 50);
        txt3.setBounds(300, 90, 500, 133);

        // Login Credentials

        // Fonts
        Font f1 = new Font("Times New Roman", Font.BOLD, 26);
        Font f2 = new Font("Arial", Font.PLAIN, 18);
        // Account Number
        JLabel accLabel = new JLabel("Account Number ");
        JTextField accField = new JTextField();
        accField.setBounds(470, 300, 300, 50);
        accLabel.setBounds(250, 300, 300, 50);
        accLabel.setFont(f1);
        accField.setFont(f2);
        accField.setForeground(Color.red);
        frm.add(accLabel);
        frm.add(accField);

        // Account Pin

        JLabel pinLabel = new JLabel("Account Pin ");
        JPasswordField pinPass = new JPasswordField();
        pinLabel.setBounds(250, 350, 300, 50);
        pinPass.setBounds(470, 350, 300, 50);
        pinLabel.setFont(f1);
        pinPass.setFont(f2);
        pinPass.setForeground(Color.red);
        frm.add(pinPass);
        frm.add(pinLabel);

        // Login Button

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(470, 410, 150, 50);
        loginBtn.setBackground(Color.black);
        loginBtn.setForeground(Color.green);
        loginBtn.setFont(new Font("American Typewriter",Font.PLAIN,20));
        // loginBtn.setOpaque(true);

        loginBtn.addActionListener(e -> {

            String accGet = accField.getText();
            String pinGet = pinPass.getText();
            char[] pinGet2 = pinPass.getPassword();
            String q1 = "select acc,pin from protb2 where acc=? and pin=? ";

            try {
                DataBase conn = new DataBase();
                PreparedStatement pt = conn.con.prepareStatement(q1);
                pt.setString(1, accGet);
                pt.setString(2, pinGet);
                ResultSet res = pt.executeQuery();

                if (accGet.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter Account Number.");
                } else if (pinPass.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter Account Pin.");
                } else {
                    if (res.next()) {

                        // Login Passed
                        frm.setVisible(false);
                        AccNum = res.getString("acc");
                        Pin = res.getString("pin");
                        Bank.main(args);
                    } else {

                        // Login Fail
                        JOptionPane.showMessageDialog(null, "Incorrect Account Number or Pin ");
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        // Clear Button

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(620, 410, 150, 50);
        clearBtn.setForeground(Color.red);
        clearBtn.setFont(new Font("American Typewriter",Font.PLAIN,20));
        frm.add(clearBtn);
        frm.add(loginBtn);

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                pinPass.setText("");
                accField.setText("");
            }
        });
        // Registration Button

        JButton regBtn = new JButton("Register Now!");
        regBtn.setBounds(470, 460, 300, 50);
        regBtn.setForeground(Color.black);
        regBtn.setFont(new Font("American Typewriter",Font.PLAIN,20));
        frm.add(regBtn);

        regBtn.addActionListener(e -> {
            frm.dispose();
            Registration.main(args);
        });

        ImageIcon exitIcon = new ImageIcon("Media/Exit.png");
        JButton exitButton = new JButton(exitIcon);
        frm.add(exitButton);
        exitButton.setBounds(20,10,50,50);
        exitButton.addActionListener(e->{
            index.main(args);
            frm.dispose();
        });

        frm.setVisible(true);
    }
}