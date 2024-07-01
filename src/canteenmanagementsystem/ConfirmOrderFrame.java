package canteenmanagementsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ConfirmOrderFrame extends JFrame {
    private Map<String, Integer> orderDetails;
    private int totalCost;

    public ConfirmOrderFrame(Map<String, Integer> orderDetails, int totalCost) {
        this.orderDetails = orderDetails;
        this.totalCost = totalCost;
        setTitle("Confirm Order");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel confirmLabel = new JLabel("Confirm Order:");
        confirmLabel.setBounds(20, 20, 200, 25);
        add(confirmLabel);

        JTextArea orderSummary = new JTextArea();
        orderSummary.setBounds(20, 50, 350, 150);
        StringBuilder summary = new StringBuilder();
        for (Map.Entry<String, Integer> entry : orderDetails.entrySet()) {
            summary.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        summary.append("\nTotal Cost: ").append(totalCost);
        orderSummary.setText(summary.toString());
        orderSummary.setEditable(false);
        add(orderSummary);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(150, 220, 100, 30);
        add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderHistoryFrame.addOrder(orderDetails, totalCost);
                OrderHistoryFrame orderHistoryFrame = new OrderHistoryFrame(); // Create an instance of OrderHistoryFrame
                orderHistoryFrame.setVisible(true); // Make the OrderHistoryFrame visible
                dispose();
            }
        });

        setVisible(true);
    }
}