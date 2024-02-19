package Project;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class aHome {
    public static void main(String[] args) {
         JFrame frm = new JFrame("Admin's Login");
        frm.setSize(500, 500);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(350, 100);

        ImageIcon exitIcon = new ImageIcon("Media/Exit.png");
        JButton exitButton = new JButton(exitIcon);
        frm.add(exitButton);
        exitButton.setBounds(420,10,50,50);
        exitButton.addActionListener(e->{
            index.main(args);
            frm.dispose();
        });
        
        frm.setVisible(true);
    }
}
