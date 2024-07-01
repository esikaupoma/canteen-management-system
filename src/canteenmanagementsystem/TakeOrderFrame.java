package canteenmanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TakeOrderFrame extends JFrame {
    private Map<String, Integer> prices;
    private Map<String, Integer> quantities;
    private Map<String, JCheckBox> itemCheckboxes;
    private Map<String, JTextField> quantityFields;
    private JLabel totalCostLabel;
    private int totalCost;
    private Map<String, Integer> stock;

    public TakeOrderFrame() {
        setTitle("Take Order");
        setSize(600, 700); // Increased size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        prices = new HashMap<>();
        quantities = new HashMap<>();
        itemCheckboxes = new HashMap<>();
        quantityFields = new HashMap<>();
        stock = new HashMap<>();

        loadStock();

        // Food items and their prices
        prices.put("Burger", 50);
        prices.put("Pizza", 100);
        prices.put("Chicken Roll", 70);
        prices.put("Noodles", 60);
        prices.put("Cake", 80);
        prices.put("Pudding", 40);
        prices.put("Pasta", 120);
        prices.put("Sandwich", 50);
        prices.put("Chicken fry", 90);
        prices.put("Fried Rice", 140);
        prices.put("Tea", 10);
        prices.put("Coffee", 20);
        prices.put("CocaCola", 20);

        int yPosition = 20;

        // Add checkboxes and quantity fields for each item
        for (String item : prices.keySet()) {
            JCheckBox checkBox = new JCheckBox(item);
            checkBox.setBounds(20, yPosition, 150, 25);
            JTextField quantityField = new JTextField("0");
            quantityField.setBounds(200, yPosition, 50, 25);

            checkBox.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        quantityField.setText("1");
                    } else {
                        quantityField.setText("0");
                    }
                    updateTotalCost();
                }
            });

            quantityField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    updateTotalCost();
                }
            });

            add(checkBox);
            add(quantityField);

            itemCheckboxes.put(item, checkBox);
            quantityFields.put(item, quantityField);
            quantities.put(item, 0);

            yPosition += 30;
        }

        totalCostLabel = new JLabel("Total Cost: 0");
        totalCostLabel.setBounds(20, yPosition, 200, 25);
        add(totalCostLabel);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(150, yPosition + 30, 100, 30);
        add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkStock()) {
                    updateStock();
                    new ConfirmOrderFrame(getOrderDetails(), totalCost);
                    dispose();
                }
            }
        });

        setVisible(true);
    }

    private void loadStock() {
        try (BufferedReader reader = new BufferedReader(new FileReader("stock.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                stock.put(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void saveStock() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("stock.txt"))) {
            for (Map.Entry<String, Integer> entry : stock.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void updateTotalCost() {
        totalCost = 0;
        for (String item : prices.keySet()) {
            int quantity = Integer.parseInt(quantityFields.get(item).getText());
            quantities.put(item, quantity);
            totalCost += prices.get(item) * quantity;
        }
        totalCostLabel.setText("Total Cost: " + totalCost);
    }

    private Map<String, Integer> getOrderDetails() {
        Map<String, Integer> orderDetails = new HashMap<>();
        for (String item : quantities.keySet()) {
            if (quantities.get(item) > 0) {
                orderDetails.put(item, quantities.get(item));
            }
        }
        return orderDetails;
    }

    private boolean checkStock() {
        for (String item : quantities.keySet()) {
            if (quantities.get(item) > stock.get(item)) {
                JOptionPane.showMessageDialog(this, "Out of stock: " + item, "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private void updateStock() {
        for (String item : quantities.keySet()) {
            int newStock = stock.get(item) - quantities.get(item);
            stock.put(item, newStock);
        }
        saveStock();
    }
}
