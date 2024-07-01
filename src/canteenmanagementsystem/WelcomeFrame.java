
package canteenmanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame {
    public WelcomeFrame() {
        setTitle("Welcome to Canteen Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to Canteen Management System");
        welcomeLabel.setBounds(50, 50, 300, 30);
        add(welcomeLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 150, 100, 30);
        add(loginButton);

        JButton adminButton = new JButton("Admin");
        adminButton.setBounds(250, 150, 100, 30);
        add(adminButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                dispose();
            }
        });

        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminFrame();
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new WelcomeFrame();
    }
}
