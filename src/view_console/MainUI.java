package view_console;

import java.util.Scanner;

public class MainUI {
    public String Menu() {
        String res = "===============================\n";
        res += "0. Afficher empreinte;\n";
        res += "1. Ajouter un transport;\n";
        res += "2. Ajouter un logement;\n";
        res += "3. Ajouter un bien conso;\n";
        res += "4. Ajouter une alimentation;\n";
        res += "5. Ajouter une service;\n";
        res += "q pour quiter;";
        return res;
    }

    public char getOneChar() {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()) {
            return sc.next().charAt(0);
        }
        return ' ';
    }

    public void start() {
        char choise = ' ';
        while(choise != 'q') {
            System.out.println();
            System.out.println(Menu());
            System.out.print("> ");
            choise = getOneChar();
        }
    }

    public static void main(String[] args) {
        new MainUI().start();
    }
}
