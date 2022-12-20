package consoCarbone;

public enum Taille {
    P ("Petite Voiture",4.2), // petite voiture - 4.2t
    G  ("Grosse Voiture",19)// grosse voiture - 19
    ;
    private String tailleName ;
    private double emissionFabrication;
    Taille(String tailleName, double emissionProduction) {
        this.tailleName = tailleName;
        this.emissionFabrication = emissionProduction;
    }
    public double getEmissionFabrication() {
        return this.emissionFabrication;
    }
    public String getTailleName(){
        return this.tailleName;
    }
}
