package consoCarbone;

public class Logement extends ConsoCarbone{
    private int superficie;
    private CE ce;
    public Logement(int superficie, CE ce) {
        if(superficie<0){
            throw new RuntimeException("la superfices de logement ne doit pas être négative");
        }
        this.superficie = superficie;
        this.ce = ce;
        this.impact=this.ce.getAlpha()*superficie;
    }
    public int getSuperficie() {
        return superficie;
    }
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }
    public CE getCe() {
        return ce;
    }
    public void setCe(CE ce) {
        this.ce = ce;
    }
    public static void getInfoAverage(){
        System.out.println( "l'empreinte carbone moyenne d'un.e français.e\n"+
                "pour les equipements des logements : 335 kg eq CO2/an\n" +
                "pour les constructions et les gros entretiens : 675 kg eq CO2/an\n"+
                "pour les énergies et les utilités : 1696 kg eq CO2/an\n");
    }
    public String toString() {
        return "Logement : id =" + id +"\n"+"La superficie de votre logement : "+ superficie+" mètres carrés" +"\n" +
                "La class énergique du logement est "+ce+"\n"+
                "l'impact de votre logement en terme d'émissions de GES :  "+String.format("%.6f",impact)+" TCO2eq."+"\n";
    }
}