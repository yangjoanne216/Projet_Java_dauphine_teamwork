package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MessageBox extends JDialog {

    JTextArea text = new JTextArea();

    public MessageBox(String title, String msg){
        super();
        this.setSize(500, 400);
        this.setTitle(title);
        this.setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        text.setText(msg);
        text.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setContentPane(scrollPane);
        this.setVisible(true);
    }
}
