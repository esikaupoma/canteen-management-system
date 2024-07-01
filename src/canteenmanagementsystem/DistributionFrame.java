package canteenmanagementsystem;

import javax.swing.*;

public class DistributionFrame extends JFrame {
    public DistributionFrame() {
        setTitle("Distribution");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel distributionLabel = new JLabel("Distribution:");
        distributionLabel.setBounds(20, 20, 200, 25);
        add(distributionLabel);

        JTextArea distributionArea = new JTextArea(
            "Eggs to Chef 1: 20\n" +
            "Flour to Chef 2: 50\n" +
            "Sugar to Chef 3: 30"
        );
        distributionArea.setBounds(20, 50, 550, 300);
        distributionArea.setEditable(false);
        add(distributionArea);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DistributionFrame();
    }
}
