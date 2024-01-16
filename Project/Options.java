package Project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Options {
    public static void main(String[] args) {

        JFrame frm = new JFrame();
        frm.setSize(1000, 700);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocation(200, 50);
        frm.setLayout(null);

        ImageIcon logo = new ImageIcon("Media/Bank.jpg");
        JLabel atmLabel = new JLabel(logo);
        frm.add(atmLabel);
        atmLabel.setBounds(0, 0, 1000, 700);

        CardLayout crd = new CardLayout();
        // Main Panel
        JPanel mainPanel = new JPanel();
        frm.add(mainPanel);
        mainPanel.setBounds(138, 90, 690, 370);
        mainPanel.setBackground(Color.red);
        mainPanel.setLayout(crd);

        // Money Sending Panel

        JPanel p1 = new JPanel();
        mainPanel.add(p1, "crd1");
        JTextField tf1 = new JTextField();
        p1.setBackground(Color.black);
        p1.setLayout(null);
        p1.add(tf1);
        tf1.setBounds(50, 75, 300, 50);
        tf1.setBackground(Color.red);
        tf1.setForeground(Color.white);

        JLabel l1 = new JLabel("Enter the Receiver's \nAccount Number : ");
        l1.setBounds(50, 25, 350, 50);
        l1.setForeground(Color.white);
        l1.setFont(new Font("Arial", Font.PLAIN, 18));
        p1.add(l1);

        JLabel l2 = new JLabel("Enter Amount :");
        p1.add(l2);
        l2.setBounds(50, 150, 350, 50);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Arial", Font.PLAIN, 18));

        JTextField tf2 = new JTextField();
        p1.add(tf2);
        tf2.setBounds(50, 200, 300, 50);
        tf2.setBackground(Color.red);
        tf2.setForeground(Color.white);
        tf1.setFont(new Font("Arial", Font.PLAIN, 18));
        tf2.setFont(new Font("Arial", Font.PLAIN, 18));
        tf2.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume(); // Ignore the input if it's not a digit or backspace
                    JOptionPane.showMessageDialog(null, "Please enter Valid Amount.");
                }
            }

        });

        JButton sendButton = new JButton("Send Money");
        p1.add(sendButton);
        sendButton.setBounds(50, 300, 200, 50);
        sendButton.setFont(new Font("Arial", Font.BOLD, 18));

        // Displaying Balance
        long bal = Bank.Balance;
        JLabel balLabel = new JLabel("Balance :");
        p1.add(balLabel);
        balLabel.setBounds(520, 25, 150, 50);
        balLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        balLabel.setForeground(Color.green);

        JLabel balLabel2 = new JLabel("₹ " + bal);
        p1.add(balLabel2);
        balLabel2.setBounds(540, 50, 150, 50);
        balLabel2.setFont(new Font("Arial", Font.PLAIN, 18));
        balLabel2.setForeground(Color.green);

        sendButton.addActionListener(e -> {

            long sendAmount = Long.parseLong(tf2.getText());
            if (isNumeric(tf2.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter valid Amount.");
            } else if (tf1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter the Receiver's\nAccount Number.");
            } else if (tf2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter Amount.");
            } else if (sendAmount > bal) {
                JOptionPane.showMessageDialog(null, "You dont Have Sufficient Balance.");
            }
        });

        frm.add(atmLabel);
        frm.setVisible(true);
    }

    private static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}
