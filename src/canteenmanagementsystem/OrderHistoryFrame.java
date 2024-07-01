package canteenmanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderHistoryFrame extends JFrame {
    private static List<String[]> orderHistory = new ArrayList<>();
    private JTable orderTable;
    private JLabel totalCostLabel;
    private int totalOrderCost;

    public OrderHistoryFrame() {
        setTitle("Order History");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel historyLabel = new JLabel("Order History:");
        historyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(historyLabel, BorderLayout.NORTH);

        // Table to display order history
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Item");
        model.addColumn("Quantity");
        model.addColumn("Total Cost");

        orderTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(orderTable);
        add(scrollPane, BorderLayout.CENTER);

        // Display total order cost
        totalCostLabel = new JLabel("Total Order Cost: 0");
        totalCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(totalCostLabel, BorderLayout.SOUTH);

        // Populate the table with order history
        populateTable();
        updateTotalOrderCost();

        setVisible(true);
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        for (String[] order : orderHistory) {
            model.addRow(order);
        }
    }

    private void updateTotalOrderCost() {
        totalOrderCost = 0;
        for (String[] order : orderHistory) {
            totalOrderCost += Integer.parseInt(order[2]);
        }
        totalCostLabel.setText("Total Order Cost: " + totalOrderCost);
    }

    public static void addOrder(Map<String, Integer> orderDetails, int totalCost) {
        String[] order = new String[3];
        StringBuilder items = new StringBuilder();
        int totalQuantity = 0;

        for (Map.Entry<String, Integer> entry : orderDetails.entrySet()) {
            items.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
            totalQuantity += entry.getValue();
        }

        order[0] = items.toString();
        order[1] = String.valueOf(totalQuantity); // Total quantity of items in the order
        order[2] = String.valueOf(totalCost);

        orderHistory.add(order);
    }
}
