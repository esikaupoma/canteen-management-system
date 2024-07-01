package canteenmanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageFrame extends JFrame {
    private String username;

    public HomePageFrame(String username) {
        this.username = username;
        setTitle("Home Page");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome " + username + "! Choose an option below:");
        welcomeLabel.setBounds(50, 20, 300, 30);
        add(welcomeLabel);

        JButton stockUpdateButton = new JButton("Stock Update");
        JButton takeOrderButton = new JButton("Take Order");
        JButton orderHistoryButton = new JButton("Order History");
        JButton rawMaterialsButton = new JButton("Raw Materials");
        JButton distributionButton = new JButton("Distribution");

        stockUpdateButton.setBounds(100, 70, 200, 30);
        takeOrderButton.setBounds(100, 120, 200, 30);
        orderHistoryButton.setBounds(100, 170, 200, 30);
        rawMaterialsButton.setBounds(100, 220, 200, 30);
        distributionButton.setBounds(100, 270, 200, 30);

        add(stockUpdateButton);
        add(takeOrderButton);
        add(orderHistoryButton);
        add(rawMaterialsButton);
        add(distributionButton);

        stockUpdateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StockUpdateFrame();
            }
        });

        takeOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TakeOrderFrame();
            }
        });

        orderHistoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new OrderHistoryFrame();
            }
        });

        rawMaterialsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RawMaterialsFrame();
            }
        });

        distributionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DistributionFrame();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePageFrame("User");
    }
}
