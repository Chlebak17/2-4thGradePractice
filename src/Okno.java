import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Okno extends JFrame {
    public Okno() {
        setTitle("Okno");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        JLabel label1 = new JLabel("label");
        label1.setBackground(Color.RED);
        label1.setOpaque(true);

        add(label1,BorderLayout.CENTER);

        JButton button1 = new JButton("button1");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tlačítko bylo zmáčknuto");
                System.exit(0);
            }
        });

        add(button1,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new Okno().setVisible(true);
    }
}
