import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.Image.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Login{
    public static void main(String[] args) {
        JFrame frm = new JFrame("Bank");
        frm.setSize(800,600);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(200,100);
        frm.setLayout(null);
        

        ImageIcon img1 = new ImageIcon("Media/Bank.png");
        // Image img11 = img1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        JLabel l1 = new JLabel(img1);
        l1.setBounds(0,50,300,200);
        frm.add(l1);

        //welcome Text
        JLabel txt1 = new JLabel("Welcome");
        JLabel txt2 = new JLabel("To");
        txt1.setFont(new Font("Montserrat", Font.BOLD, 40));
        txt2.setFont(new Font("TMontserrat", Font.BOLD, 36));
        txt1.setForeground(Color.red);
        txt2.setForeground(Color.BLACK);
        
        //Monopoly Image 
        ImageIcon monoIcon = new ImageIcon("Media/Mono2.png");
        JLabel txt3 = new JLabel(monoIcon);
        frm.add(txt3);
        frm.add(txt1);
        frm.add(txt2);
        txt1.setBounds(455,10,500,50);
        txt2.setBounds(520,55,500,50);
        txt3.setBounds(300,90,500,133);

        //Login Credentials

          // Fonts
          Font f1 = new Font("Times New Roman", Font.BOLD,26 );

          // Account Number
        JLabel accLabel = new JLabel("Account Number : ");
        JTextField accField = new JTextField();
        accField.setBounds(470,300,300,50);
        accLabel.setBounds(250,300,300,50);
        accLabel.setFont(f1);
        frm.add(accLabel);
        frm.add(accField);

        // Account Pin

        JLabel pinLabel = new JLabel("Account Pin         : ");
        JPasswordField pinPass = new JPasswordField();
        pinLabel.setBounds(250,350,300,50);
        pinPass.setBounds(470,350,300,50);
        pinLabel.setFont(f1);
        frm.add(pinPass);
        frm.add(pinLabel);

        //Login Button

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(470,410,150,50);
        loginBtn.setBackground(Color.black);
        loginBtn.setForeground(Color.green);
        // loginBtn.setOpaque(true);

        //Clear Button

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(620,410,150,50);
        clearBtn.setForeground(Color.red);
        frm.add(clearBtn);
        frm.add(loginBtn);

        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                pinPass.setText("");
                accField.setText("");
            }
        });
        //Registration Button

        JButton regBtn = new JButton("Register Now!");
        regBtn.setBounds(470,460,300,50);
        regBtn.setForeground(Color.black);
        frm.add(regBtn);

        frm.setVisible(true);
    }
}