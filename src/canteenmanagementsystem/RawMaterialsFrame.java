package canteenmanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RawMaterialsFrame extends JFrame {
    public RawMaterialsFrame() {
        setTitle("Raw Materials");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel rawMaterialsLabel = new JLabel("Raw Materials:");
        rawMaterialsLabel.setBounds(20, 20, 200, 25);
        add(rawMaterialsLabel);

        JTextArea rawMaterialsArea = new JTextArea(
            "Eggs: 100 (Total Cost: 50)\n" +
            "Flour: 200 (Total Cost: 100)\n" +
            "Sugar: 150 (Total Cost: 75)\n" +
            "Butter: 80 (Total Cost: 40)\n" +
            "Milk: 60 (Total Cost: 30)"
        );
        rawMaterialsArea.setBounds(20, 50, 550, 200);
        rawMaterialsArea.setEditable(false);
        add(rawMaterialsArea);

        JButton distributeButton = new JButton("Distribute to Chefs");
        distributeButton.setBounds(20, 270, 200, 30);
        add(distributeButton);

        distributeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DistributionFrame();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new RawMaterialsFrame();
    }
}
