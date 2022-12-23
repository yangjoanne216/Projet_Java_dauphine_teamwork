package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {

    JButton[] buttons = new JButton[5];
    String[] labels = new String[]{"Transport", "Logement", "Bien conso", "Alimentation", "Service"};

    public MainWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300,300);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2, 3, 2, 3));
        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel btnPanel = new JPanel(new GridLayout(5, 1, 10, 5));
        for(int i=0; i<5; i++) {
            buttons[i] = new JButton(labels[i]);
            btnPanel.add(buttons[i]);
        }
        layout.add(btnPanel);
        panel.add(layout, BorderLayout.CENTER);
        this.add(panel);
    }

    public static void main(String[] args) {
        (new MainWindow()).setVisible(true);
    }
}
