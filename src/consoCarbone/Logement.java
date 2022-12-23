package consoCarbone;

import java.util.ArrayList;
import java.util.List;

public class Logement extends ConsoCarbone{
    List<Appartement> appartements;

    public Logement(){
        appartements = new ArrayList<>();
    }

    public static double getInfoMoyenne() {
        return 2.706;
    }

    public double comparerAvecMoyen() {
        return getImpact()-getInfoMoyenne();
    }

    public static void printInfoMoyen(){
        System.out.println( "l'empreinte carbone moyenne d'un.e français.e\n"+
                "pour les equipements des logements : 335 kg eq CO2/an\n" +
                "pour les constructions et les gros entretiens : 675 kg eq CO2/an\n"+
                "pour les énergies et les utilités : 1696 kg eq CO2/an\n");
    }
    public void addAppartement(Appartement a){ this.appartements.add(a);}

    public int nbAppartement(){return this.appartements.size();}

    public double getImpact(){
        double res = 0;
        for(Appartement a : this.appartements){
            res+=a.getImpact();
        }
        return res;
    }

    public String toString(){
        if(nbAppartement()==0){
            return "Vous possédez aucun appartement\n";
        }
        String res="";
        for (Appartement appartement : appartements) {
            res+=appartement.toString();
        }
        return res;
    }

    public List<Appartement> getAppartements(){
        return this.appartements;
    }

}
