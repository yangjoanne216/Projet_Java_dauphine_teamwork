package consoCarbone;
public class BienConso extends ConsoCarbone{
    private double montant;
    private static final int DEPENSE_CO2=1750;
    public BienConso(){
        this.montant=0;
        this.impact=0;
    }

    public BienConso(double montant){
        if(montant<0){
            throw new RuntimeException("Montant doit être un nombre non négatif");
        }
        this.montant=montant;
        this.impact=montant/DEPENSE_CO2;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant){
        if(montant<0){
            throw new RuntimeException("Montant doit être un nombre non négatif");
        }
        this.montant=montant;
    }

    @Override
    public String toString() {
        return "BienConso : id =" + id +"\n"+"Votre montant des dépenses annuelles : "+ montant+" euros" +"\n" +
                "l'impact de votre montant des dépenses annuelles en terme d'émissions de GES : "+ String.format("%.6f",impact)+" TCO2eq"+"\n";
    }

}
