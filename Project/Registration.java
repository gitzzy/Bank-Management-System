package Project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import java.awt.event.*;

// last Updated 16Jan

public class Registration {
    static String fDate;

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

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth : ");
        p1.add(dob);
        dob.setBounds(400, 420, 200, 50);
        dob.setFont(f1);

        JDateChooser cal = new JDateChooser();
        p1.add(cal);
        cal.setBounds(600, 420, 250, 40);

        // Calendar
        JLabel rPhone = new JLabel("Phone : ");
        p1.add(rPhone);
        rPhone.setBounds(400, 460, 200, 50);
        rPhone.setFont(f1);

        JTextField tf4 = new JTextField(10);
        p1.add(tf4);
        tf4.setBounds(600, 460, 250, 40);
        tf4.setFont(f2);
        tf4.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Please enter Valid Number.");
                }
            }

        });
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

        ImageIcon exitIcon = new ImageIcon("Media/Exit.png");
        JButton exitButton = new JButton(exitIcon);
        p2.add(exitButton);
        exitButton.setBounds(310, 455, 50, 50);
        exitButton.addActionListener(e -> {
            index.main(args);
            frm.dispose();
        });

        // Blanc Checker

        // Register Button
        ImageIcon regImg = new ImageIcon("Media/register3.png");
        JButton mainReg = new JButton(regImg);
        p2.add(mainReg);
        mainReg.setBounds(50, 450, 250, 60);

        mainReg.addActionListener(e -> {
            // Get data from fields
            String firstName = tf1.getText();
            String lastName = tf2.getText();
            String dob1 = ((JTextField) cal.getDateEditor().getUiComponent()).getText();
            String phone = tf4.getText();
            String income = tf5.getText();
            String email = maField.getText();
            String assets = assField.getText();
            String occupation = (String) occBox.getSelectedItem();
            String accNumber = accField.getText();
            String pin = pinField.getText();
            String fullName = firstName + " " + lastName;
            // long bal = 0;
            String dt = dob1;
            int len = dt.length();
            System.out.println(LocalDate.now());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            fDate = LocalDate.now().format(formatter);

            if (len == 11) {
                if (dt.charAt(2) == '-' && dt.charAt(len - 5) == '-') {
                    // System.out.println(dt.charAt(2));
                    // System.out.println(dt.charAt(len-5));
                    // System.out.println("valid date");
                    StringBuilder dob0 = new StringBuilder();
                    StringBuilder tdat = new StringBuilder();
                    for (int i = 4; i > 0; i--) {
                        dob0.append(dt.charAt(len - i));
                        tdat.append(fDate.charAt(fDate.length() - i));
                    }
                    System.out.println("dob : " + dob0.toString());
                    System.out.println("today : " + tdat.toString());
                    int age = Integer.parseInt(tdat.toString()) - Integer.parseInt(dob0.toString());
                    if (age >= 18) {
                        // System.out.println("You are Eligible : "+age);
                    } else {
                        // System.out.println("Not Eligible : "+age);
                        JOptionPane.showMessageDialog(null, "Not Eligible : \nReason : Under Age");
                        frm.dispose();
                        Registration.main(args);
                        return;

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Date Format");
                    frm.dispose();
                    Registration.main(args);
                    return;

                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Date");
                frm.dispose();
                Registration.main(args);
                return;
            }

            if (firstName.equals("")) {
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
            } else if (!cb1.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please read our Terms & Condition.");
            } else if (!cb2.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please accept our Terms & Condition.");
            } else if (phone.length() != 10) {
                JOptionPane.showMessageDialog(null, "Phone Number Should be of 10 Digit.");
                cards.next(cardPanel);
                // }else if(!DateChecker.Checking(dob1)){
                // JOptionPane.showMessageDialog(null, "Not Eligible.");
            } else {
                try {
                    // JDBC connection
                    DataBase obj = new DataBase();

                    // SQL query to insert data
                    String insertQuery = "INSERT INTO protb1 (fname, name, birth, phone, income, mail, assests, occ, acc, pin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    String mainQuery = "insert into admin1 (full_name, Phone, mail, dob, acc, pin) values (?,?,?,?,?,?)";
                    // Creating PreparedStatement
                    PreparedStatement preparedStatement = obj.con.prepareStatement(insertQuery);
                    PreparedStatement mainSt = obj.con.prepareStatement(mainQuery);

                    // Setting parameters
                    preparedStatement.setString(1, firstName);
                    preparedStatement.setString(2, lastName);
                    preparedStatement.setString(3, dob1);
                    preparedStatement.setString(4, phone);
                    preparedStatement.setString(5, income);
                    preparedStatement.setString(6, email);
                    preparedStatement.setString(7, assets);
                    preparedStatement.setString(8, occupation);
                    preparedStatement.setString(9, accNumber);
                    preparedStatement.setString(10, pin);

                    // Paramters for protb2
                    mainSt.setString(1, fullName);
                    mainSt.setString(2, phone);
                    mainSt.setString(3, email);
                    mainSt.setString(4, dob1);
                    mainSt.setString(5, accNumber);
                    mainSt.setString(6, pin);

                    // Execute the query
                    preparedStatement.executeUpdate();
                    mainSt.executeUpdate();

                    // Close the connection
                    obj.con.close();

                    // Show success message
                    JOptionPane.showMessageDialog(null, "Registration successful");
                    frm.dispose();
                    Login.main(args);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Handle database errors
                    JOptionPane.showMessageDialog(null,
                            "Error while saving data to the database. \nOr\nAccount number already Exits");
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
