package view_console;

import consoCarbone.Taille;
import consoCarbone.Transport;
import utilisateur_trice.*;

import java.util.Scanner;

public class MainUI {

    User user;

    public MainUI() {
        user = new User();
    }

    public String Menu() {
        String res = "===============================\n";
        res += "0. Afficher empreinte;\n";
        res += "1. Ajouter un transport;\n";
        res += "2. Ajouter le logement;\n";
        res += "3. Affichier tous les logement\n";
        res += "4. Ajouter un bien conso;\n";
        res += "5. Ajouter une alimentation;\n";
//        res += "5. Ajouter une service;\n";
        res += "q pour quiter;";
        return res;
    }

    public void showAllLogement() {

    }

    public void addCar() {
        // taille
        System.out.print("La taille de votre voiture (P ou G):\n> ");
        char taille = readKey();
        while(taille != 'P' && taille != 'p' && taille != 'G' && taille != 'g'){
            System.out.print("(P ou G)> ");
            taille = readKey();
        }
        // to upper case
        if(taille > 97) {taille -= 32;}
        // amortissement
        System.out.print("L'amortissement de votre voiture:\n> ");
        int amorti = readInt();
        while(amorti<0){
            System.out.print("(la valeur soit positive)> ");
            amorti = readInt();
        }
        // kilomAnnee
        System.out.print("Le kilo d'année de votre voiture:\n> ");
        int kilomAnnee = readInt();
        while(kilomAnnee<0){
            System.out.print("(la valeur soit positive)> ");
            kilomAnnee = readInt();
        }
        Transport transport = new Transport(true, taille=='P'? Taille.P:Taille.G, kilomAnnee, amorti);
        System.out.println(transport);
    }

    public char readKey() {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()) {
            return sc.next().charAt(0);
        }
        return ' ';
    }

    public int readInt() {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()) {
            return sc.nextInt();
        }
        return 0;
    }

    public void start() {
        char choise = ' ';
        while(choise != 'q') {
            System.out.println();
            System.out.println(Menu());
            System.out.print("> ");
            choise = readKey();
            switch (choise){
                case '0':
                    System.out.println("show info");
                    System.out.println("-------------");
                    System.out.print("c to continue\n> ");
                    while(this.readKey() != 'c'){
                        System.out.print("(c to continue)> ");
                    }
                    break;
                case '1':
                    System.out.println("Add 1");
                    break;
                case '2':
                    System.out.println("Add 2");
                    break;
                case '3':
                    System.out.println("Add 3");
                    break;
                case '4':
                    System.out.println("Add 4");
                    break;
                case '5':
                    System.out.println("Add 5");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new MainUI().start();
    }
}
