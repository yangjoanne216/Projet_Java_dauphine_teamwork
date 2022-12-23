package consoCarbone;

import my_exceptions.NoVehiculeException;

import java.io.IOException;

public class Voiture extends ConsoCarbone{
    private boolean possede;
    private Taille taille;
    private int kilomAnnee;
    private int amortissement;
    private static final double COEFF=0.000193;
    public Voiture(){
        super();
        this.possede=false;
        this.taille = null;
        this.kilomAnnee=0;
        this.amortissement=0;
    }

    public static double getInfoMoyenne() {
        return 1.972;
    }

    public Voiture(boolean possede) {
        super();
        //TODO 此处可以允许用户输入有车后面在输入具体参数
        /*if (possede) {
            throw new IOException("Si vous avez un véhicule, veuillez nous indiquer son modèle, la durée de conservation de ce véhicule et combien de kilomètres vous parcourez par an");
        }*/
        this.possede = possede;
        this.taille = null;
        this.kilomAnnee=0;
        this.amortissement=0;
    }
    public Voiture(boolean possede, Taille taille, int kilomAnnee, int amortissement) {
        //TODO 此处用户要是没车还输入了后面的参数，需要抛出异常
        if(!possede&&(taille!=null||kilomAnnee!=0||amortissement!=0))
        {
            throw new RuntimeException("Si vous n’avez pas de voiture, vous n’avez pas besoin d’entrer les paramètres de Taille, kiloAnnee, amortissement");
        }
        if(amortissement <= 0){
            throw new ArithmeticException("Le dénominateur est zéro ou la durée de conservation de votre véhicule ne peut pas être égal ou inférieur à 0");
        }
        this.possede = possede;
        this.taille = possede?taille:null;
        this.kilomAnnee = possede?kilomAnnee:0;
        this.amortissement = possede?amortissement:0;
        this.impact = possede?kilomAnnee*COEFF+taille.getEmissionFabrication()/amortissement:0;
    }
    public boolean isPossede() {
        return possede;
    }
    public void setPossede(boolean possede) {
        this.possede = possede;
        if(!possede){
            this.taille=null;
            this.kilomAnnee=0;
            this.amortissement=0;
            this.impact=0;
        }
    }
    public Taille getTaille() {
        return taille;
    }
    public void setTaille(Taille taille) throws Exception {
        //TODO 要有车才可以设置正数，否则抛出错误
        if(!possede && taille!=null){
            throw new NoVehiculeException();
            //throw new Exception("Vous ne pouvez pas entrer une Taille non nulle si vous n'avez pas de voiture");
        }

        this.taille = taille;
    }

    public int getKilomAnnee() {
        return kilomAnnee;
    }
    public void setKilomAnnee(int kilomAnnee) throws IOException {
        //TODO 要有车才可以设置正数，否则抛出错误
        if(!this.possede && kilomAnnee!=0) {
            throw new IOException("Vous ne pouvez pas entrer une  non nulle si vous n'avez pas de voiture");
        }
        this.kilomAnnee = kilomAnnee;
    }
    public int getAmortissement() {
        return amortissement;
    }

    public void setAmortissement(int amortissement) {
        //TODO 要有车才可以设置正数，否则抛出错误
        this.amortissement = amortissement;
    }

    @Override
    public double getImpact() {
        return this.impact = possede?kilomAnnee*COEFF+taille.getEmissionFabrication()/amortissement:0;
    }

    @Override
    public String toString() {
        if(possede)
            return "Transport : id =" + id +"\n"+
                    "vous possedez une "+ taille.getTailleName() +";\n" +
                    "Vous parcourez : "+kilomAnnee+" kilomètre par an;\n"+
                    "La durée de conservation de votre véhicule : "+amortissement+" ans"+";\n"+
                    "l'impact de votre transport en terme d'émissions de GES : "+String.format("%.6f",impact)+" TCO2eq."+"\n";
        else
            return  "Transport : id =" + id +"\n"+"vous ne possedez pas une voiture" +";\n" +
                    "l'impact de votre transport en terme d'émissions de GES : 0 TCO2eq."+"\n";

    }
}
