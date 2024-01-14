import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Registration {
    public static void main(String[] args) {
        
        JFrame frm = new JFrame("Registration Page");
        frm.setSize(900,700);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(200,100);
        frm.setLayout(null);

        Random regRandom = new Random();
        long reg = Math.abs((regRandom.nextLong() % 9000L)+1000L);
        System.out.println("Random Number Testing : "+reg);

        JLabel regNum = new JLabel("Registration Number : "+reg);
        frm.add(regNum);
        regNum.setBounds(630,0,300,50);
        regNum.setFont(new Font("Montserrat", Font.PLAIN, 18));
        regNum.setForeground(Color.red);

        ImageIcon MonoImg = new ImageIcon("Media/Mono1.png");
        JLabel monoImage1 = new JLabel(MonoImg);
        frm.add(monoImage1);
        monoImage1.setBounds(-20,0,600,700);

        ImageIcon regImageIcon = new ImageIcon("Media/Register.png");
        JLabel regImgJLabel = new JLabel(regImageIcon);
        frm.add(regImgJLabel);
        regImgJLabel.setBounds(570,50,300,300);

         // Fonts
         Font f1 = new Font("Times New Roman", Font.BOLD,26 );
         Font f2 = new Font("Arial", Font.PLAIN ,18);

        JLabel rFirstName = new JLabel("First Name : ");
        frm.add(rFirstName);
        rFirstName.setBounds(400,340,200,50);
        rFirstName.setFont(f1);

        JTextField tf1 = new JTextField();
        frm.add(tf1);
        tf1.setBounds(600,340,250,40);
        tf1.setFont(f2);

        JLabel rLastName = new JLabel("Last Name : ");
        frm.add(rLastName);
        rLastName.setBounds(400,380,200,50);
        rLastName.setFont(f1);

        JTextField tf2 = new JTextField();
        frm.add(tf2);
        tf2.setBounds(600,380,250,40);
        tf2.setFont(f2);

        
        JLabel dob = new JLabel("Date of Birth : ");
        frm.add(dob);
        dob.setBounds(400,420,200,50);
        dob.setFont(f1);

        JTextField tf3 = new JTextField();
        frm.add(tf3);
        tf3.setBounds(600,420,250,40);
        tf3.setFont(f2);

        JLabel rPhone = new JLabel("Phone : ");
        frm.add(rPhone);
        rPhone.setBounds(400,460,200,50);
        rPhone.setFont(f1);

        JTextField tf4 = new JTextField();
        frm.add(tf4);
        tf4.setBounds(600,460,250,40);
        tf4.setFont(f2);

        JLabel rIncome = new JLabel("Annual Income : ");
        frm.add(rIncome);
        rIncome.setFont(f1);
        rIncome.setBounds(400,500,200,50);

        JTextField tf5 = new JTextField();
        frm.add(tf5);
        tf5.setBounds(600,500,250,40);
        tf5.setFont(f2);

        frm.setVisible(true);

    }
}
