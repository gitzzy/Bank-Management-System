package Project;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bank {
    public static void main(String[] args) {
        JFrame frm = new JFrame("Bank");
        
        // CardLayout cards = new CardLayout();
        // frm.setLayout(cards);
        frm.setSize(1000, 700);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(100, 50);
        frm.setLayout(null);

        //Main Frame
        JPanel mainPanel = new JPanel();
        ImageIcon logo = new ImageIcon("Media/Bank.jpg");
        JLabel atmLabel = new JLabel(logo);
        frm.add(mainPanel);
        mainPanel.setBounds(0,0,1000,700);
        mainPanel.setLayout(null);
        atmLabel.setBounds(0,0,1000,700);
        mainPanel.add(atmLabel);



        frm.setUndecorated(true);
        frm.setVisible(true);

    }
}
