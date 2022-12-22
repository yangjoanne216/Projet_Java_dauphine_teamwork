package utilisateur_trice;

import consoCarbone.*;

import java.util.*;

public class Utilisateur {
    private Alimentation alimentation;
    private AutreBien autreBien;
    private List<Logement>  logements;
    /*private Logement logement;*/
    /*private Transport transport;*/
    private List<Transport> transports;
    private ServicesPublics servicesPublics;

    private Habillement habillement;

    private BienNumerique bienNumerique;

    //默认的值为0
    public Utilisateur(){
        this.alimentation =  new Alimentation(0,1);
        this.autreBien = new AutreBien();
        this.logements = new ArrayList<>();
        this.transports = new ArrayList<>();
        /*this.logement = new Logement();
        this.transport=new Transport();*/
        this.servicesPublics = ServicesPublics.getServicesPublics();
        this.habillement = new Habillement();
        this.bienNumerique = new BienNumerique();
    }

    public Utilisateur(Alimentation a, AutreBien b, List<Logement> l, List<Transport> t, ServicesPublics s, Habillement h, BienNumerique bn){
        this.alimentation=a;
        this.autreBien =b;
        this.logements=l;
        this.transports=t;
        this.servicesPublics=s;
        this.habillement=h;
        this.bienNumerique=bn;
    }

    public double calculerEmpreinte(){
        return alimentation.getImpact()+ autreBien.getImpact()+ this.calculerImpactDeLogementsTotal()+ this.calculerImpactDeTransportTotal()+servicesPublics.getImpact()+habillement.getImpact();
    }
    public void detaillerEmpreinte(){
        System.out.println("Volià des informations sur votre empreinte carbon");
        System.out.println("-------------------------------------------------");
        System.out.println("--------------1.Alimentation---------------------");
        System.out.println(alimentation);
        System.out.println("--------------2.BienConsommé---------------------");
        System.out.println(bienNumerique);
        System.out.println(habillement);
        System.out.println(autreBien);
        System.out.println("----------------3.logement------------------------");
        for(Logement logement: this.logements){
            System.out.println(logement);
        }
        System.out.println("----------------4.transport------------------------");
        for(Transport transport: this.transports){
            System.out.println(transport);
        }
        System.out.println("----------------5.service public-------------------");
        System.out.println(servicesPublics);
        System.out.println("----------------7.habillement-------------------");
        System.out.println(habillement);
        System.out.println("----------------Total-------------------");
        System.out.println("Au total, vous avez une empreinte carbone de "+String.format("%.6f",this.calculerEmpreinte())+" TCO2eq."+"\n");
        System.out.println("--------------getRecommantation----------------");
        System.out.println(getRecommandation());
    }

    public double calculerImpactDeLogementsTotal(){
        double impactLogements = 0;
        for(Logement logement: this.logements){
            impactLogements = impactLogements+logement.getImpact();
        }
        return impactLogements;
    }

    public double calculerImpactDeTransportTotal(){
        double impactTransports = 0;
        for(Transport transport: this.transports){
            impactTransports = impactTransports+transport.getImpact();
        }
        return impactTransports;
    }

    public double comparerAvecMoyenLogements(){
        return calculerImpactDeLogementsTotal()-Logement.getInfoMoyenne();
    }

    public double comparerAvecMoyenTransports(){
        return  calculerImpactDeTransportTotal()-Transport.getInfoMoyenne();
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

    public Logement[] getLogements() {
        return logements.toArray(new Logement[0]);
    }

    public void addLogement(Logement logement) {
        this.logements.add(logement);
    }

    public Transport[] getTransports() {
        return transports.toArray(new Transport[0]);
    }

    public void addTransport(Transport transport) {
        this.transports.add(transport);
    }

    public  String  getRecommandation(){
        List<String> superieurAMoyen=new ArrayList<>();
        if(alimentation.comparerAvecMoyen()>0){
            superieurAMoyen.add("alimentation");
        }
        if(autreBien.comparerAvecMoyen()>0){
            superieurAMoyen.add("autreBien");
        }
        if(bienNumerique.comparerAvecMoyen()>0){
            superieurAMoyen.add("bienNumerique");
        }
        if(habillement.comparerAvecMoyen()>0){
            superieurAMoyen.add("habillement");
        }
        if(comparerAvecMoyenTransports()>0){
            superieurAMoyen.add("Transports");
        }
        if(comparerAvecMoyenLogements()>0){
            superieurAMoyen.add("Logements");
        }


        return "L'ordre de vos plusieurs Poste de cosommations est :" +this.getListMiseEnOrder()+"\n"+
                "Dans les aspects suivants, votre émission dépasse le niveau moyen des Français : " + superieurAMoyen + " ,j'espère que vous pourrez y prêter attention!";
    }

    public List getListMiseEnOrder(){
        List<ConsoCarbone> posteDeConsomation = new ArrayList<ConsoCarbone>();
        posteDeConsomation.add(habillement);
        posteDeConsomation.add(bienNumerique);
        //posteDeConsomation.add(transports);
        posteDeConsomation.add(servicesPublics);
        posteDeConsomation.add(autreBien);
        posteDeConsomation.add(alimentation);
        Collections.sort(posteDeConsomation);
        List<String> listMiseEnOrder = new ArrayList<>();
        for(ConsoCarbone consoCarbone : posteDeConsomation){
            listMiseEnOrder.add(consoCarbone.getClass().getName().substring(13));
        }
        return listMiseEnOrder;
    }
}
