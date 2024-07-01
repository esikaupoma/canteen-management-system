package canteenmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame {
    public AdminFrame() {
        setTitle("Admin Information");
        setSize(600, 500); // Increased size
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel adminLabel = new JLabel("Admin Information:");
        adminLabel.setBounds(20, 20, 200, 25);
        add(adminLabel);

        // Admin 1
        JLabel adminImage1 = new JLabel(resizeImageIcon("upoma.jpg", 70, 70));
        adminImage1.setBounds(20, 50, 70, 70);
        add(adminImage1);
        JTextArea adminDetails1 = createTextArea("ID: 101\nName: Upoma\nEmail: upoma@example.com\nPhone: 1234567890");
        adminDetails1.setBounds(100, 50, 250, 90);
        add(adminDetails1);

        // Admin 2
        JLabel adminImage2 = new JLabel(resizeImageIcon("Rafi.jpg", 70, 70));
        adminImage2.setBounds(20, 190, 70, 70);
        add(adminImage2);
        JTextArea adminDetails2 = createTextArea("ID: 102\nName: Rafi\nEmail: rafi@example.com\nPhone: 1234567899");
        adminDetails2.setBounds(100, 190, 250, 90);
        add(adminDetails2);

        // Admin 3
        JLabel adminImage3 = new JLabel(resizeImageIcon("zarin.jpg", 70, 70));
        adminImage3.setBounds(20, 330, 70, 70);
        add(adminImage3);
        JTextArea adminDetails3 = createTextArea("ID: 103\nName: Zarin\nEmail: zarin@example.com\nPhone: 1234567891");
        adminDetails3.setBounds(100, 330, 250, 90);
        add(adminDetails3);

        setVisible(true);
    }

    private JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea(text);
        textArea.setEditable(false);
        textArea.setBackground(null); // Makes the background color transparent
        textArea.setBorder(null); // Removes the border
        return textArea;
    }

    private ImageIcon resizeImageIcon(String path, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(path);
        Image img = originalIcon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}