package consoCarbone;
public class Alimentation extends ConsoCarbone {
    private double txBoeuf;
    private double txVege;
    private static final double COEF_BOEUF = 8.0;
    private static final double COEF_VOLAILLE = 1.6;
    private static final double COEF_VEGE = 0.9;
    public Alimentation(double txBoeuf, double txVege) {
        super();
        if(txBoeuf<0 || txBoeuf>1||txVege<0||txVege>1||(1-txBoeuf-txVege)<0||(1-txBoeuf-txVege)>1)
        {
            throw new RuntimeException("txVege,txBeuf et txVolaille=(1-txBoeuf-txVege) doivent être compris entre 0 et 1");
        }
        this.txBoeuf = txBoeuf;
        this.txVege = txVege;
        this.impact = COEF_BOEUF * txBoeuf + COEF_VOLAILLE * (1 - txVege - txBoeuf) + COEF_VEGE * txVege;
    }
    public Alimentation(){
        super();
        this.txVege=0.5;
        this.txBoeuf=0.5;
        this.impact=COEF_BOEUF * txBoeuf + COEF_VOLAILLE * (1 - txVege - txBoeuf) + COEF_VEGE * txVege;;
    }
    public double getTxBoeuf() {
        return txBoeuf;
    }
    public void setTxBoeuf(double txBoeuf) {
        this.txBoeuf = txBoeuf;
    }
    public double getTxVege() {
        return txVege;
    }
    public void setTxVege(double txVege) {
        this.txVege = txVege;
    }
    public static void printInfoMoyen(){
        System.out.println(
                "l'empreinte carbone moyenne d'un.e français.e \n"+
                "pour les Boissons : 263 kg eq CO2/an\n" +
                "pour les produits laitiers et oeufs : 408 kg eq CO2/an\n"+
                "pour les Viandes et Poissons : 1144 kg eq CO2/an\n"+
                "pour les autres : 538 kg eq CO2/an\n");
    }
    @Override
    public String toString() {
        return "Alimentation : id =" + id +"\n"+"Le pourcentage de bœuf dans votre alimentation : " + txBoeuf+"\n" +
                "Le pourcentage de légumes dans votre alimentation : "+txVege+"\n"+
                "l'impact de votre alimentation en terme d'émissions de GES : "+String.format("%.6f",impact)+" TCO2eq."+"\n";
    }
}
