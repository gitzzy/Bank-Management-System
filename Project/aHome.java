package Project;

import java.awt.Color;
import java.awt.Dimension;
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
        backgroundPanel.setSize(500, 500);

        // Create button1
        JButton button1 = new JButton("Button 1");
        button1.setBackground(Color.PINK);
        button1.setBounds(50, 300, 100, 40);
        backgroundPanel.add(button1);

        // Create button2
        JButton button2 = new JButton("Button 2");
        button2.setBackground(Color.PINK);
        button2.setBounds(350, 300, 100, 40);
        backgroundPanel.add(button2);

        // Add useronadmin image at the center
        ImageIcon img2 = new ImageIcon("Media/useronadmin.webp");
        JLabel l2 = new JLabel(img2);
        l2.setBounds(200, 200, 100, 100);
        backgroundPanel.add(l2);

        // Add the background panel to the frame
        frm.add(backgroundPanel);

        ImageIcon exitIcon = new ImageIcon("Media/Exit.png");
        JButton exitButton = new JButton(exitIcon);
        frm.add(exitButton);
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
