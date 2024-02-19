package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class aLogin {
    public static void main(String[] args) {
        JFrame frm = new JFrame("Admin's Login");
        frm.setSize(500, 500);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(350, 100);

        //Wallpaper
        ImageIcon wIcon = new ImageIcon("Media/plainbg2.jpg");
        JLabel wall = new JLabel(wIcon);
        wall.setBounds(0,0,500,500);

        JLabel lbl1 = new JLabel("Admin's");
        lbl1.setFont(new Font("Futura",Font.PLAIN,26));
        frm.add(lbl1);
        lbl1.setBounds(50,50,200,50);
        lbl1.setForeground(Color.white);

        JLabel lbl2 = new JLabel("Login");
        lbl2.setFont(new Font("Futura",Font.PLAIN,26));
        frm.add(lbl2);
        lbl2.setBounds(75,85,200,50);
        lbl2.setForeground(Color.white);

        JLabel username = new JLabel("Username : ");
        frm.add(username);
        username.setBounds(50,200,200,50);
        username.setFont(new Font("American Typewriter",Font.PLAIN,30));
        username.setForeground(Color.white);

        JTextField tf1 = new JTextField("admin");
        frm.add(tf1);
        tf1.setBounds(250,200,200,50);
        tf1.setFont(new Font("American Typewriter",Font.PLAIN,30));

        JLabel pass = new JLabel("Passcode   : ");
        frm.add(pass);
        pass.setBounds(50,250,200,50);
        pass.setFont(new Font("American Typewriter",Font.PLAIN,30));
        pass.setForeground(Color.white);

        JPasswordField pf = new JPasswordField();
        frm.add(pf);
        pf.setBounds(250,250,200,50);
        pf.setFont(new Font("American Typewriter",Font.PLAIN,30));

        ImageIcon log = new ImageIcon("Media/login.png");
        JButton login = new JButton(log);
        frm.add(login);
        login.setBounds(250,300,100,50);
        login.addActionListener(e->{
            if(tf1.getText().equals("admin") && pf.getText().equals("admin")){
                JOptionPane.showMessageDialog(null, "Login successfull");
                aHome.main(args);
                frm.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Passcode or Username ");
            }
        });

        ImageIcon exitIcon = new ImageIcon("Media/Exit.png");
        JButton exitButton = new JButton(exitIcon);
        frm.add(exitButton);
        exitButton.setBounds(420,10,50,50);
        exitButton.addActionListener(e->{
            index.main(args);
            frm.dispose();
        });

        frm.add(wall);
        frm.setVisible(true);
    }
}
