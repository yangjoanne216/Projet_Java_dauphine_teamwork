package consoCarbone;

public class BienNumerique extends BienConso{
    private boolean usage_intensif;
    private boolean hautNiveau_Equipement;

    private static final double  IMPACT_USAGE_INTENSIF=0.7;

    private static final double IMPACT_USAGE_SOBRE=0.04;

    private static final double IMPACT_NIVEAU_HAUT =0.5;

    private static final double IMPACT_NIVEAU_SOBRE =0.04;


    public BienNumerique(){
        super();
        usage_intensif =false;
        hautNiveau_Equipement=false;
        this.impact=IMPACT_USAGE_SOBRE+ IMPACT_NIVEAU_SOBRE;
    }

    public BienNumerique(boolean usage_intensif, boolean hautNiveau_Equipement) {
        this.usage_intensif = usage_intensif;
        this.hautNiveau_Equipement = hautNiveau_Equipement;
        this.impact=(usage_intensif ?IMPACT_USAGE_INTENSIF:IMPACT_USAGE_SOBRE)+(hautNiveau_Equipement? IMPACT_NIVEAU_HAUT : IMPACT_NIVEAU_SOBRE);
    }

    @Override
    public String toString() {
        return " BienNumerique : id =" + id +"\n"+"vous avez un usage intensif numérigue : " + this.usage_intensif +"\n" +
                "vous avez un haut niveau d'équipement : "+this.hautNiveau_Equipement+"\n"+
                "l'impact de votre Bien Numérique est : "+String.format("%.6f",impact)+" TCO2eq."+"\n";

    }

    /*public static void main(String[] args) {
        BienNumerique bn = new BienNumerique(false,false);
        System.out.println(bn);
    }*/
}
