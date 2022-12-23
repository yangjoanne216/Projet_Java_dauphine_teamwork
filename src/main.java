import consoCarbone.*;
import utilisateur_trice.Utilisateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
        System.out.println("\n" +"Test Class Logement");
        Logement l1 = new Logement(20, CE.A);
        Logement l2 = new Logement(10,CE.B);
        System.out.println(l1);

        System.out.println("\n" +"Test Class Alimentation");
        Alimentation a1 = new Alimentation(0.5, 0.3);
        System.out.println(a1.getImpact());
        Alimentation.printInfoMoyen();

        int difference = a1.compareTo(l1);
        System.out.println("Écart d'émissions de carbone entre le logement et l'alimentation : "+difference);
        System.out.println("\n" +"Test Class BienConso");
        AutreBien b1 = new AutreBien(100);
        System.out.println(b1);

        System.out.println("\n" +"Test Class Transport");
        Voiture t1 = new Voiture(true, Taille.P, 100000000, 3);
        System.out.println(t1);

        System.out.println("\n"+"Test Class ServicesPublics");
        ServicesPublics sv = ServicesPublics.getServicesPublics();
        System.out.println(sv);

        int[][] nombre_habillement={{10,5},{5},{20,5,3},{2,2,2,3},{2,1,1},{2,2},{2,1,1}};
        Habillement h1 = new Habillement();
        List<Logement> logements= new ArrayList<>();
        List<Voiture> transports = new ArrayList<>();


        BienNumerique bn= new BienNumerique();
        System.out.println("\n"+"Test Class utilisateur");
        Utilisateur u1=new Utilisateur(a1,b1,logements,transports,sv,h1,bn);
        u1.addLogement(l1);
        u1.addLogement(l2);
        u1.addTransport(t1);
        u1.detaillerEmpreinte();
        System.out.println("---------------------------------------------");



    }
}
