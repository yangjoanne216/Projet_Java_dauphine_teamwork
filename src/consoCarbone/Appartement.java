package consoCarbone;

public class Appartement extends ConsoCarbone{
    private int superficie;
    private CE ce;
    public Appartement(){
        super();
        this.ce = CE.A;
        this.superficie=0;
        this.impact=0;
    }

    public Appartement(int superficie, CE ce) {
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
    @Override
    public double getImpact() {
        return this.ce.getAlpha()*superficie;
    }

    public String toString() {
        return "Logement : id =" + id +"\n"+"La superficie de votre logement : "+ superficie+" mètres carrés" +"\n" +
                "La class énergique du logement est "+ce+"\n"+
                "l'impact de votre logement en terme d'émissions de GES :  "+String.format("%.6f",impact)+" TCO2eq."+"\n";
    }

}
