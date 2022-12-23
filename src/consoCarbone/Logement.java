package consoCarbone;

import java.util.ArrayList;
import java.util.List;

public class Logement extends ConsoCarbone{
    List<Appartement> appartements;

    public Logement(){
        appartements = new ArrayList<>();
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
            return "Vous possede aucun appartement ";
        }
        String res="";
        for (Appartement appartement : appartements) {
            res+=appartement.toString();
        }
        return res;
    }
}
