import consoCarbone.*;
import utilisateur_trice.Utilisateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {
//        System.out.println("\n" +"Test Class Logement");
//        Appartement a1 = new Appartement(20, CE.A);
//        Appartement a2 = new Appartement(10,CE.B);
//        Logement logement = new Logement();
//        logement.addAppartement(a1);
//        logement.addAppartement(a2);
//        System.out.println(logement);
//
//        System.out.println("\n" +"Test Class Alimentation");
//        Alimentation al = new Alimentation(0.5, 0.3);
//        System.out.println(al.getImpact());
//        Alimentation.printInfoMoyen();
//
//        int difference = al.compareTo(al);
//        System.out.println("Écart d'émissions de carbone entre le logement et l'alimentation : "+difference);
//        System.out.println("\n" +"Test Class BienConso");
//        AutreBien b1 = new AutreBien(100);
//        System.out.println(b1);
//
//        System.out.println("\n" +"Test Class Transport");
//        Voiture t1 = new Voiture(true, Taille.P, 100000000, 3);
//        Transport transport = new Transport();
//        transport.addVoiture(t1);
//        System.out.println(transport);
//
//        System.out.println("\n"+"Test Class ServicesPublics");
//        ServicesPublics sv = ServicesPublics.getServicesPublics();
//        System.out.println(sv);
//
//        int[][] nombre_habillement={{10,5},{5},{20,5,3},{2,2,2,3},{2,1,1},{2,2},{2,1,1}};
//        Habillement h1 = new Habillement();
//        List<Appartement> appartements = new ArrayList<>();
//        List<Voiture> transports = new ArrayList<>();
//
//
//        BienNumerique bn= new BienNumerique();
//        System.out.println("\n"+"Test Class utilisateur");
//        Utilisateur u1=new Utilisateur(al,b1, logement,transport,sv,h1,bn);
//        u1.addAppartement(a1);
//        u1.addAppartement(a2);
//        u1.addVoiture(t1);
//        u1.detaillerEmpreinte();
//        System.out.println("---------------------------------------------");
        Utilisateur utxt=new Utilisateur("/Users/yangyang/Program/IntelliJ_workspace/Projet/Projet_Java_dauphine_teamwork/Data/exemple1.txt");
        System.out.println(utxt);



    }
}
