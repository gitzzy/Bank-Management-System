package Project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class aHome {
    public static void main(String[] args) {
        JFrame frm = new JFrame("Admin's Login");
        frm.setSize(500, 500);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(350, 100);

        // Set the background image
        BackgroundPanel backgroundPanel = new BackgroundPanel(new ImageIcon("Media/plainbg2.jpg").getImage());
        backgroundPanel.setLayout(null);
        frm.add(backgroundPanel);
        backgroundPanel.setBounds(0,0,500,500);

        // Create button1
        JButton button1 = new JButton("Manage Users");
        button1.setBackground(Color.PINK);
        button1.setBounds(150, 320, 200, 50);
        backgroundPanel.add(button1);
        button1.setFont(new Font("American Typewriter",Font.PLAIN,20));

        // Create button2
        JButton button2 = new JButton("View Applications");
        button2.setBackground(Color.PINK);
        button2.setBounds(150, 380, 200, 50);
        backgroundPanel.add(button2);
        button2.setFont(new Font("American Typewriter",Font.PLAIN,20));
        button2.addActionListener(e->{
            uVerification.main(args);
            frm.dispose();
        });

        // Add useronadmin image at the center
        ImageIcon img2 = new ImageIcon("Media/useronadmin.png");
        JLabel l2 = new JLabel(img2);
        l2.setBounds(100, 0, 300, 300);
        backgroundPanel.add(l2);

        // Add the background panel to the frame

        ImageIcon exitIcon = new ImageIcon("Media/Exit.png");
        JButton exitButton = new JButton(exitIcon);
        backgroundPanel.add(exitButton);
        exitButton.setBounds(420, 10, 50, 50);
        exitButton.addActionListener(e -> {
            index.main(args);
            frm.dispose();
        });

        frm.setVisible(true);
    }

    // BackgroundPanel class for setting background image
    static class BackgroundPanel extends JPanel {
        private final Image backgroundImage;

        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500); // Set preferred size
        }
    }
}
