package canteenmanagementsystem;
import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Canteen Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        new WelcomeFrame();
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
