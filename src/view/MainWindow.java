package view;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    JButton[] buttons = new JButton[5];
    String[] labels = new String[]{"Transport", "Logement", "Bien conso", "Alimentation", "Service"};
    public MainWindow() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLayout(new GridLayout(5,1));
        for(int i=0; i<5; i++) {
            buttons[i] = new JButton(labels[i]);
            this.add(buttons[i]);
        }



    }

    public static void main(String[] args) {
        (new MainWindow()).setVisible(true);
    }
}
