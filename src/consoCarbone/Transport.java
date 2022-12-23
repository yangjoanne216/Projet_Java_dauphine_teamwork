package consoCarbone;

import java.util.ArrayList;
import java.util.List;

public class Transport extends ConsoCarbone {

    List<Voiture> voitures;

    public Transport(){
        voitures = new ArrayList<>();
    }
    public void addVoiture(Voiture v) {
        this.voitures.add(v);
    }

    public int nbVoiture() {
        return this.voitures.size();
    }
    public static double getInfoMoyenne() {
        return 1.972;
    }
    public double comparerAvecMoyen() {
        return getImpact()-getInfoMoyenne();
    }
    @Override
    public double getImpact() {
        double res = 0;
        for(Voiture v : this.voitures) {
            res += v.getImpact();
        }
        return res;
    }

    public List<Voiture> getVoitures(){
        return this.voitures;
    }

    @Override
    public String toString() {
        if(nbVoiture()==0) {
            return "Vous possédez aucune voiture\n";
        }
        String res = "";
        for (Voiture voiture : voitures) {
            res += voiture.toString();
        }
        return res;
    }
}
