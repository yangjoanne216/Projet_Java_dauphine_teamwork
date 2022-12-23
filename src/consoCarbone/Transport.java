package consoCarbone;

import java.util.List;

public class Transport extends ConsoCarbone {

    List<Voiture> voitures;
    
    public void addVoiture(Voiture v) {
        this.voitures.add(v);
    }

    public int nbVoiture() {
        return this.voitures.size();
    }
    
    @Override
    public double getImpact() {
        double res = 0;
        for(Voiture v : this.voitures) {
            res += v.getImpact();
        }
        return res / voitures.size();
    }

    @Override
    public String toString() {
        if(nbVoiture()==0) {
            return "Vous possede aucun transport\n";
        }
        String res = "";
        for (Voiture voiture : voitures) {
            res += voiture.toString();
        }
        return res;
    }
}
