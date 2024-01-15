package Project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

// import com.toedter.calendar.JCalendar;

public class Registration {
    public static void main(String[] args) {

        ImageIcon logo = new ImageIcon("Media/Next.png");
        JFrame frm = new JFrame("Registration Page");
        frm.setIconImage(logo.getImage());
        frm.setSize(900, 700);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(200, 50);
        CardLayout cards = new CardLayout();
        JPanel cardPanel = new JPanel(cards);
        frm.setContentPane(cardPanel);

        JPanel p1 = new JPanel();
        p1.setLayout(null);

        Random regRandom = new Random();
        long reg = Math.abs((regRandom.nextLong() % 9000L) + 1000L);
        System.out.println("Random Number Testing : " + reg);

        JLabel regNum = new JLabel("Registration Number : " + reg);
        p1.add(regNum);
        regNum.setBounds(630, 0, 300, 50);
        regNum.setFont(new Font("Montserrat", Font.PLAIN, 18));
        regNum.setForeground(Color.red);

        ImageIcon MonoImg = new ImageIcon("Media/Mono1.png");
        JLabel monoImage1 = new JLabel(MonoImg);
        p1.add(monoImage1);
        monoImage1.setBounds(-20, -5, 600, 700);

        ImageIcon regImageIcon = new ImageIcon("Media/Register.png");
        JLabel regImgJLabel = new JLabel(regImageIcon);
        p1.add(regImgJLabel);
        regImgJLabel.setBounds(570, 50, 300, 300);

        // Fonts
        Font f1 = new Font("Times New Roman", Font.BOLD, 26);
        Font f2 = new Font("Arial", Font.PLAIN, 18);

        // First name
        JLabel rFirstName = new JLabel("First Name : ");
        p1.add(rFirstName);
        rFirstName.setBounds(400, 340, 200, 50);
        rFirstName.setFont(f1);

        JTextField tf1 = new JTextField();
        p1.add(tf1);
        tf1.setBounds(600, 340, 250, 40);
        tf1.setFont(f2);

        // Last Name
        JLabel rLastName = new JLabel("Last Name : ");
        p1.add(rLastName);
        rLastName.setBounds(400, 380, 200, 50);
        rLastName.setFont(f1);

        JTextField tf2 = new JTextField();
        p1.add(tf2);
        tf2.setBounds(600, 380, 250, 40);
        tf2.setFont(f2);

        JLabel dob = new JLabel("Date of Birth : ");
        p1.add(dob);
        dob.setBounds(400, 420, 200, 50);
        dob.setFont(f1);

        JDateChooser cal = new JDateChooser();
        p1.add(cal);
        cal.setBounds(600, 420, 250, 40);

        JLabel rPhone = new JLabel("Phone : ");
        p1.add(rPhone);
        rPhone.setBounds(400, 460, 200, 50);
        rPhone.setFont(f1);

        JTextField tf4 = new JTextField(10);
        p1.add(tf4);
        tf4.setBounds(600, 460, 250, 40);
        tf4.setFont(f2);
        // limitTextFieldToNCharacters(tf4, 10);

        JLabel rIncome = new JLabel("Annual Income : ");
        p1.add(rIncome);
        rIncome.setFont(f1);
        rIncome.setBounds(400, 500, 200, 50);

        JTextField tf5 = new JTextField();
        p1.add(tf5);
        tf5.setBounds(600, 500, 250, 40);
        tf5.setFont(f2);

        // Next Button
        ImageIcon nxtIcon = new ImageIcon("Media/Next.png");
        JButton nxtBtn = new JButton(nxtIcon);
        p1.add(nxtBtn);
        nxtBtn.setBounds(750, 555, 100, 100);
        nxtBtn.setOpaque(false);

        // Page 2

        JPanel p2 = new JPanel();
        ImageIcon img1 = new ImageIcon("Media/Mono3.png");
        JLabel mono3Label = new JLabel(img1);
        p2.add(mono3Label);
        p2.setLayout(null);
        mono3Label.setBounds(580, 0, 320, 550);

        cardPanel.add(p1, "cards1");
        cardPanel.add(p2, "cards2");
        cards.show(cardPanel, "cards1");

        ImageIcon bckIcon = new ImageIcon("Media/Back.png");
        JButton bckButton = new JButton(bckIcon);
        p2.add(bckButton);
        bckButton.setBounds(750, 555, 100, 100);

        JLabel regNum1 = new JLabel("Registration Number : " + reg);
        p2.add(regNum1);
        regNum1.setBounds(25, 0, 300, 50);
        regNum1.setFont(new Font("Montserrat", Font.PLAIN, 18));
        regNum1.setForeground(Color.red);

        // Mail
        JLabel maiLabel = new JLabel("Email Id : ");
        p2.add(maiLabel);
        maiLabel.setBounds(50, 100, 200, 50);
        maiLabel.setFont(f1);

        JTextField maField = new JTextField();
        p2.add(maField);
        maField.setBounds(250, 100, 250, 40);
        maField.setFont(f2);

        // Total assets
        JLabel assestLabel = new JLabel("Total Assets : ");
        p2.add(assestLabel);
        assestLabel.setBounds(50, 150, 200, 50);
        assestLabel.setFont(f1);

        JTextField assField = new JTextField();
        p2.add(assField);
        assField.setFont(f2);
        assField.setBounds(250, 150, 250, 40);

        JLabel occLabel = new JLabel("Occupation : ");
        p2.add(occLabel);
        occLabel.setBounds(50, 200, 200, 50);
        occLabel.setFont(f1);

        String[] items = { "Self-Empolyed", "Service", "Government", "Buisness" };
        JComboBox<String> occBox = new JComboBox<>(items);
        p2.add(occBox);
        occBox.setBounds(250, 200, 250, 40);
        occBox.setFont(f2);

        JLabel accLabel = new JLabel("Acc Number : ");
        p2.add(accLabel);
        accLabel.setBounds(50, 250, 200, 50);
        accLabel.setFont(f1);

        JTextField accField = new JTextField();
        p2.add(accField);
        accField.setBounds(250, 250, 250, 40);
        accField.setFont(f2);

        JLabel pinLabel = new JLabel("Setup Pin : ");
        p2.add(pinLabel);
        pinLabel.setBounds(50, 300, 200, 50);
        pinLabel.setFont(f1);

        JTextField pinField = new JTextField();
        p2.add(pinField);
        pinField.setFont(f2);
        pinField.setBounds(250, 300, 250, 40);

        // Terms & Condition

        JCheckBox cb1 = new JCheckBox("  I have Read all the Terms & Condition.");
        p2.add(cb1);
        cb1.setBounds(45, 350, 350, 50);

        JCheckBox cb2 = new JCheckBox("  I agree to all the Terms & Condition.");
        p2.add(cb2);
        cb2.setBounds(45, 380, 350, 50);

        // Blanc Checker

        // Register Button
        ImageIcon regImg = new ImageIcon("Media/register3.png");
        JButton mainReg = new JButton(regImg);
        p2.add(mainReg);
        mainReg.setBounds(50, 450, 250, 60);
        mainReg.addActionListener(e -> {
            if (tf1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Name Field Cannot be empty!!");
                cards.next(cardPanel);
            } else if (lastName.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Your Last Name!!");
                cards.next(cardPanel);
            } else if (dob1.equals("")) {
                JOptionPane.showMessageDialog(null, "Date of Birth Cannot be empty!!");
                cards.next(cardPanel);
            } else if (phone.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your Phone Number!");
                cards.next(cardPanel);
            } else if (income.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Your Annual Income!!");
                cards.next(cardPanel);
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter you mail!!");
            } else if (assets.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your total assets!!");
            } else if (accNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter your Account Number!!");
            } else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Setup your Pin!! ");
            } else {
                try {
                    // String q1 = "INSERT INTO protb1 (fname, name, birth, phone, income, mail, assests, occ, acc, pin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                   
                    DataBase obj = new DataBase();
                    // PreparedStatement pstmt = obj.con.prepareStatement(q1);
                    // pstmt.setString(1, tf1.getText());
                    // pstmt.setString(2, tf2.getText());
                    // pstmt.setString(3, ((JTextField) cal.getDateEditor().getUiComponent()).getText());
                    // pstmt.setString(4, tf4.getText());
                    // pstmt.setString(5, tf5.getText());
                    // pstmt.setString(6, maField.getText());
                    // pstmt.setString(7, assField.getText());
                    // pstmt.setString(8, (String) occBox.getSelectedItem());
                    // pstmt.setString(9, accField.getText());
                    // pstmt.setString(10, pinField.getText());
                    // pstmt.executeUpdate(q1);

                    String s1 = tf1.getText();
                    String s2 = tf2.getText();
                    String s3 = ((JTextField) cal.getDateEditor().getUiComponent()).getText();
                    String s4 = tf4.getText();
                    String s5 = tf5.getText();
                    String s6 = maField.getText();
                    String s7 = assField.getText();
                    String s8 = (String) occBox.getSelectedItem();
                    String s9 = accField.getText();
                    String s10 = pinField.getText();
                    String q1 = "INSERT INTO protb1('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"','"+s9+"','"+s10+"')";
                    obj.st.executeUpdate(q1);


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        });


        bckButton.addActionListener(e -> {
            cards.next(cardPanel);
        });

        nxtBtn.addActionListener(e -> {
            cards.next(cardPanel);
        });
        frm.setVisible(true);

    }
}
