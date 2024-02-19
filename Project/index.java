package Project;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class index {
    public static void main(String[] args) {
        JFrame frm = new JFrame("Main Screen");
        frm.setSize(300, 300);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(500, 200);
        frm.setBackground(Color.gray);

        JButton btn1 = new JButton("User's Portal");
        frm.add(btn1);
        btn1.setBounds(50,50,200,50);
        btn1.addActionListener(e->{
            Login.main(args);
            frm.dispose();
        });

        JButton btn2 = new JButton("Admin's Portal");
        btn2.setBounds(50,100,200,50);
        frm.add(btn2);
        btn2.addActionListener(e->{
            aLogin.main(args);
            frm.dispose();
        });

        ImageIcon exit = new ImageIcon("Media/Exit2.png");
        JButton btn3 = new JButton(exit);
        btn3.setBounds(50,210,200,50);
        frm.add(btn3);
        btn3.addActionListener(e->{
            frm.dispose();
        });

        frm.setVisible(true);
    }
}
