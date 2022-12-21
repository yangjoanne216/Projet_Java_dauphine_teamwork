package utilisateur_trice;

import consoCarbone.*;

public class Utilisateur {
    private Alimentation alimentation;
    private AutreBien autreBien;
    private Logement logement;
    private Transport transport;
    private ServicesPublics servicesPublics;

    private Habillement habillement;

    private BienNumerique bienNumerique;


    //默认的值为0
    private Utilisateur(){
        this.alimentation =  new Alimentation(0,1);
        this.autreBien = new AutreBien();
        this.logement = new Logement();
        this.transport=new Transport();
        this.servicesPublics = ServicesPublics.getServicesPublics();
        this.habillement = new Habillement();
        this.bienNumerique = new BienNumerique();
    }

    public Utilisateur(Alimentation a, AutreBien b, Logement l, Transport t, ServicesPublics s, Habillement h, BienNumerique bn){
        this.alimentation=a;
        this.autreBien =b;
        this.logement=l;
        this.transport=t;
        this.servicesPublics=s;
        this.habillement=h;
        this.bienNumerique=bn;
    }

    public double calculerEmpreinte(){
        return alimentation.getImpact()+ autreBien.getImpact()+ logement.getImpact()+ transport.getImpact()+servicesPublics.getImpact()+habillement.getImpact();
    }
    public void detaillerEmpreinte(){
        System.out.println("Volià des informations sur votre empreinte carbon");
        System.out.println("-------------------------------------------------");
        System.out.println("--------------1.Alimentation---------------------");
        System.out.println(alimentation);
        System.out.println("--------------2.BienConsommé---------------------");
        System.out.println(autreBien);
        System.out.println("----------------3.logement------------------------");
        System.out.println(logement);
        System.out.println("----------------4.transport------------------------");
        System.out.println(transport);
        System.out.println("----------------5.service public-------------------");
        System.out.println(servicesPublics);
        System.out.println("----------------7.habillement-------------------");
        System.out.println(habillement);
        System.out.println("----------------Total-------------------");
        System.out.println("Au total, vous avez une empreinte carbone de "+String.format("%.6f",this.calculerEmpreinte())+" TCO2eq."+"\n");
    }

    public Alimentation getAlimentation() {
        return alimentation;
    }

    public void setAlimentation(Alimentation alimentation) {
        this.alimentation = alimentation;
    }

    public AutreBien getAutreBien() {
        return autreBien;
    }

    public void setAutreBien(AutreBien autreBien) {
        this.autreBien = autreBien;
    }

    public Logement getLogement() {
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public ServicesPublics getServicesPublics() {
        return servicesPublics;
    }

    public void setServicesPublics(ServicesPublics servicesPublics) {
        this.servicesPublics = servicesPublics;
    }

    public Habillement getHabillement() {
        return habillement;
    }

    public void setHabillement(Habillement habillement) {
        this.habillement = habillement;
    }

    public BienNumerique getBienNumerique() {
        return bienNumerique;
    }

    public void setBienNumerique(BienNumerique bienNumerique) {
        this.bienNumerique = bienNumerique;
    }
}
