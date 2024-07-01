package canteenmanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StockUpdateFrame extends JFrame {
    private JTextArea stockArea;
    private Map<String, JCheckBox> itemCheckBoxes;
    private Map<String, Integer> stock;

    public StockUpdateFrame() {
        setTitle("Stock Update");
        setSize(600, 500); // Increased size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel stockLabel = new JLabel("Stock Update:");
        stockLabel.setBounds(20, 20, 200, 25);
        add(stockLabel);

        itemCheckBoxes = new HashMap<>();
        stock = new HashMap<>();

        loadStock();

        stockArea = new JTextArea();
        updateStockArea();
        stockArea.setBounds(20, 50, 350, 350); // Adjusted size and position
        stockArea.setEditable(false);
        add(stockArea);

        int yPosition = 50;
        for (String item : stock.keySet()) {
            JCheckBox checkBox = new JCheckBox(item);
            checkBox.setBounds(400, yPosition, 150, 25);
            add(checkBox);
            itemCheckBoxes.put(item, checkBox);
            yPosition += 30;
        }

        JButton increaseButton = new JButton("Increase Stock");
        increaseButton.setBounds(20, 420, 150, 30); // Adjusted position
        increaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (String item : itemCheckBoxes.keySet()) {
                    if (itemCheckBoxes.get(item).isSelected()) {
                        increaseStock(item, 1); // Increase stock of checked items by 1
                    }
                }
                updateStockArea();
                saveStock();
            }
        });
        add(increaseButton);

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

    private void updateStockArea() {
        StringBuilder stockText = new StringBuilder();
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            stockText.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        stockArea.setText(stockText.toString());
    }

    private void increaseStock(String itemName, int amount) {
        int currentStock = stock.get(itemName);
        int newStock = currentStock + amount;
        stock.put(itemName, newStock);
    }
}
