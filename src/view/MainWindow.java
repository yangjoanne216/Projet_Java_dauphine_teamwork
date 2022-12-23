package view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    JButton[] buttons = new JButton[5];
    String[] labels = new String[]{"Transport", "Logement", "Bien conso", "Alimentation", "Service"};

    public MainWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,400);
//        this.setLayout(new GridLayout(5,1,10,5));
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        for(int i=0; i<5; i++) {
            buttons[i] = new JButton(labels[i]);
            buttons[i].setSize(100,50);
            panel.add(buttons[i]);
        }
        this.add(panel, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        (new MainWindow()).setVisible(true);
    }
}
