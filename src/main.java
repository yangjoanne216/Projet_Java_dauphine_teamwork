import consoCarbone.*;
import utilisateur_trice.Utilisateur;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        System.out.println("\n" +"Test Class Logement");
        Logement l1 = new Logement(20, CE.A);
        System.out.println(l1);

        System.out.println("\n" +"Test Class Alimentation");
        Alimentation a1 = new Alimentation(0.5, 0.3);
        System.out.println(a1.getImpact());
        Alimentation.getInfoAverage();

        int difference = a1.compareTo(l1);
        System.out.println("Écart d'émissions de carbone entre le logement et l'alimentation : "+difference);
        System.out.println("\n" +"Test Class BienConso");
        BienConso b1 = new BienConso(100);
        System.out.println(b1);

        System.out.println("\n" +"Test Class Transport");
        Transport t1 = new Transport(true, Taille.P, 10, 3);
        System.out.println(t1);

        System.out.println("\n"+"Test Class ServicesPublics");
        ServicesPublics sv = ServicesPublics.getServicesPublics();
        System.out.println(sv);

        int[][] nombre_habillement={{10,5},{5},{20,5,3},{2,2,2,3},{2,1,1},{2,2},{2,1,1}};
        Habillement h1 = new Habillement();

        System.out.println("\n"+"Test Class utilisateur");
        Utilisateur u1=new Utilisateur(a1,b1,l1,t1,sv,h1);
        u1.detaillerEmpreinte();
    }
}
