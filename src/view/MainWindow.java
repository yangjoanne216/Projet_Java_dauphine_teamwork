package view;

import org.w3c.dom.events.Event;
import utilisateur_trice.Utilisateur;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class MainWindow extends JFrame {

    JButton[] buttons = new JButton[6];
    String[] labels = new String[]{
            "Télécharger un fichier",
            "Transport",
            "Logement",
            "Bien conso",
            "Alimentation",
            "Empreinte et Résumé",};

    Utilisateur utilisateur = new Utilisateur();

    public MainWindow() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300,300);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(2, 3, 2, 3));
        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel btnPanel = new JPanel(new GridLayout(buttons.length, 1, 10, 5));
        for(int i=0; i<buttons.length; i++) {
            buttons[i] = new JButton(labels[i]);
            btnPanel.add(buttons[i]);
        }
        layout.add(btnPanel);
        panel.add(layout, BorderLayout.CENTER);
        this.add(panel);

        buttons[0].addActionListener(this::loadFile);
        buttons[5].addActionListener(this::showEmpreinte);
    }

    public void loadFile(ActionEvent e) {
        FileDialog fd = new FileDialog(this, "Choose a file", FileDialog.LOAD);
        fd.setFile("*.txt");
        fd.setVisible(true);
        String filename = fd.getDirectory() + fd.getFile();
        System.out.println(filename);
        if (filename != null) {
            try {
                utilisateur = new Utilisateur(filename);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }
    }

    public void showEmpreinte(ActionEvent e) {
//        JOptionPane.showMessageDialog(null, utilisateur, "Résumé", JOptionPane.INFORMATION_MESSAGE);
        new MessageBox("Résumé",utilisateur.toString());
    }

    public static void main(String[] args) {
        (new MainWindow()).setVisible(true);
    }
}
