import javax.swing.*;
import java.awt.*;


public class Okno extends JFrame {
    public Okno() {
        setTitle("Okno");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label1 = new JLabel("label");
        label1.setBackground(Color.RED);
        label1.setOpaque(true);
        label1.setBounds(10,20,800,800);
        add(label1);
    }

    public static void main(String[] args) {
        new Okno().setVisible(true);
    }
}
