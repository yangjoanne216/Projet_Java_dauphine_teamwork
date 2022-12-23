package view_console;

import consoCarbone.*;
import utilisateur_trice.*;

public class MainUI {

    Utilisateur user;
    String[] menuTitle;
    BienConsoUI bienConsoUI;

    public MainUI(Utilisateur user) {
        this.user = user;
        menuTitle = new String[] {
                "Afficher empreinte",
                "Afficher les transports",
                "Ajouter un transport",
                "Affichier tous les logement",
                "Ajouter le logement",
                "Afficher bien conso",
                "Ajouter un bien conso",
                "Affichier l'alimentation",
                "Modifier l'alimentation"
        };
        bienConsoUI = new BienConsoUI(user);
    }

    public String Menu() {
        String res = "===============================\n";
        for(int i=0; i<menuTitle.length; i++) {
            res += i+". " + menuTitle[i] + ";\n";
        }
        res += "q pour quiter;";
        return res;
    }


    public void showCars() {
        Voiture[] allTransports = user.getVoitures();
        if(allTransports.length==0){
            System.out.println("Vous n'avez pas de voiture.");
            return;
        }
        System.out.println("Vous avez en total "+allTransports.length+" voiture(s):\n");
        for(Voiture t : allTransports){
            System.out.println(t);
        }
        Utils.pressToContinue();
    }

    public void addCar() {
        // taille
        System.out.print("La taille de votre voiture (P ou G):\n> ");
        char taille = Utils.readKey();
        while(taille != 'P' && taille != 'p' && taille != 'G' && taille != 'g'){
            System.out.print("(P ou G)> ");
            taille = Utils.readKey();
        }
        // to upper case
        if(taille >= 97) {taille -= 32;}
        // amortissement
        System.out.print("L'amortissement de votre voiture:\n> ");
        int amorti = Utils.readInt();
        while(amorti<0){
            System.out.print("(la valeur soit positive)> ");
            amorti = Utils.readInt();
        }
        // kilomAnnee
        System.out.print("Le kilo d'année de votre voiture:\n> ");
        int kilomAnnee = Utils.readInt();
        while(kilomAnnee<0){
            System.out.print("(la valeur soit positive)> ");
            kilomAnnee = Utils.readInt();
        }
        // add into user
        Voiture transport = new Voiture(true, taille=='P'? Taille.P:Taille.G, kilomAnnee, amorti);
        user.addVoiture(transport);
    }

    public void showAllLogement() {
        Appartement[] allAppartements = user.getAppartements();
        if(allAppartements.length==0){
            System.out.println("Vous n'avez pas encore déclarer votre logement.");
            return;
        }
        System.out.println("Vous avez en total "+ allAppartements.length+" logement(s):\n");
        for(Appartement appartement : allAppartements){
            System.out.println(appartement);
        }
        Utils.pressToContinue();
    }

    public void addLogement() {
        // surface
        System.out.print("La superfice de votre logement:\n> ");
        int s = Utils.readInt();
        while(s<0){
            System.out.print("(la valeur soit positive)> ");
            s = Utils.readInt();
        }
        // CE
        System.out.print("Le CE de votre logement (A-G):\n> ");
        char ce = Utils.readKey();
        if(ce >= 97) {ce -= 32;} // to upper case
        while(ce<65 || ce >=65+7){
            System.out.print("(A-G)> ");
            ce = Utils.readKey();
            if(ce >= 97) {ce -= 32;} // to upper case
        }
        Appartement appartement = new Appartement(s, CE.getCEFromChar(ce));
        user.addAppartement(appartement);
    }

    public void showBienConso() {
        System.out.print(user.getHabillement());
        System.out.print(user.getBienNumerique());
        System.out.print(user.getAutreBien());
        Utils.pressToContinue();
    }

    public void showAlimentation() {
        System.out.println(user.getAlimentation());
        Utils.pressToContinue();
    }

    public void setAlimentation() {
        // Le taux de boeuf
        System.out.print("Le taux de boeuf(0~1):\n> ");
        double txBoeuf = Utils.readDouble();
        while(txBoeuf < 0){
            System.out.print("(la valeur soit positive)> ");
            txBoeuf = Utils.readDouble();
        }
        // Le taux de Vege
        System.out.print("Le taux de Vege(0~1):\n> ");
        double txVege = Utils.readDouble();
        while(txVege < 0){
            System.out.print("(la valeur soit positive)> ");
            txVege = Utils.readDouble();
        }
        // créer Alimentation
        Alimentation alimentation = new Alimentation(txBoeuf,txVege);
        user.setAlimentation(alimentation);
    }

    public void start() {
        System.out.println(Menu());
        System.out.print("> ");
        char choise = Utils.readKey();
        boolean invalideInput = false;
        while(choise != 'q') {
            switch (choise){
                case '0':
                    user.detaillerEmpreinte();
                    Utils.pressToContinue();
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
                    showBienConso();
                    break;
                case '6':
                    bienConsoUI.start();
                    break;
                case '7':
                    showAlimentation();
                    break;
                case '8':
                    setAlimentation();
                    System.out.println("Succeed");
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
            choise = Utils.readKey();
        }
    }

    public static void main(String[] args) {
        new MainUI(new Utilisateur()).start();
    }
}
