package view_console;

import consoCarbone.CE;
import consoCarbone.Logement;
import consoCarbone.Taille;
import consoCarbone.Transport;
import utilisateur_trice.*;

import java.util.Scanner;

public class MainUI {

    Utilisateur user;
    String[] menuTitle;

    public MainUI() {
        user = new Utilisateur();
        menuTitle = new String[] {
            "Afficher empreinte",
            "Afficher les transports",
            "Ajouter un transport",
            "Affichier tous les logement",
            "Ajouter le logement",
            "Ajouter un bien conso",
            "Ajouter une alimentation"
        };
    }

    public String Menu() {
        String res = "===============================\n";
        for(int i=0; i<menuTitle.length; i++) {
            res += i+". " + menuTitle[i] + ";\n";
        }
//        res += "0. Afficher empreinte;\n";
//        res += "1. Ajouter un transport;\n";
//        res += "2. Ajouter le logement;\n";
//        res += "3. Affichier tous les logement\n";
//        res += "4. Ajouter un bien conso;\n";
//        res += "5. Ajouter une alimentation;\n";
//        res += "5. Ajouter une service;\n";
        res += "q pour quiter;";
        return res;
    }



    public void showCars() {
        Transport[] allTransports = user.getTransports();
        if(allTransports.length==0){
            System.out.println("Vous n'avez pas de voiture.");
            return;
        }
        System.out.println("Vous avez en total "+allTransports.length+" voiture(s):\n");
        for(Transport t : allTransports){
            System.out.println(t);
        }
        this.pressToContinue();
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
        if(taille >= 97) {taille -= 32;}
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
        // add into user
        Transport transport = new Transport(true, taille=='P'? Taille.P:Taille.G, kilomAnnee, amorti);
        user.addTransport(transport);
    }

    public void showAllLogement() {
        Logement[] allLogements = user.getLogements();
        if(allLogements.length==0){
            System.out.println("Vous n'avez pas encore déclarer votre logement.");
            return;
        }
        System.out.println("Vous avez en total "+allLogements.length+" logement(s):\n");
        for(Logement logement : allLogements){
            System.out.println(logement);
        }
        this.pressToContinue();
    }

    public void addLogement() {
        // surface
        System.out.print("La superfice de votre logement:\n> ");
        int s = readInt();
        while(s<0){
            System.out.print("(la valeur soit positive)> ");
            s = readInt();
        }
        // CE
        System.out.print("Le CE de votre logement:\n> ");
        char ce = readKey();
        if(ce >= 97) {ce -= 32;} // to upper case
        while(ce<65 || ce >=65+7){
            System.out.print("(A-G)> ");
            ce = readKey();
            if(ce >= 97) {ce -= 32;} // to upper case
        }
        Logement logement = new Logement(s, CE.getCEFromChar(ce));
        user.addLogement(logement);
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
        return -1;
    }

    public double readDouble() {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextDouble()) {
            return sc.nextDouble();
        }
        return -1;
    }

    public void pressToContinue(){
        System.out.println("-------------");
        System.out.print("c to continue\n> ");
        while(this.readKey() != 'c'){
            System.out.print("(c to continue)> ");
        }
    }

    public void start() {
        System.out.println(Menu());
        System.out.print("> ");
        char choise = readKey();
        boolean invalideInput = false;
        while(choise != 'q') {
            switch (choise){
                case '0':
                    user.detaillerEmpreinte();
                    this.pressToContinue();
                    break;
                case '1':
                    this.showCars();
                    break;
                case '2':
                    this.addCar();
                    System.out.println("Succeed");
                    break;
                case '3':
                    showAllLogement();
                    break;
                case '4':
                    addLogement();
                    break;
                case '5':
                    System.out.println("Add 5");
                    break;
                case '6':
                    System.out.println("Add 6");
                    break;
                default:
                    invalideInput = true;

            }
            if(invalideInput) {
                invalideInput = false;
            }else {
                System.out.println();
                System.out.println(Menu());
            }
            System.out.print("> ");
            choise = readKey();
        }
    }

    public static void main(String[] args) {
        new MainUI().start();
    }
}
