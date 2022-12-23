package utilisateur_trice;

import consoCarbone.*;

import java.util.*;

public class Utilisateur {
    private Alimentation alimentation;
    private AutreBien autreBien;
    private Logement logement;
    /*private Logement logement;*/
    /*private Transport transport;*/
    private Transport transport;
    private ServicesPublics servicesPublics;

    private Habillement habillement;

    private BienNumerique bienNumerique;

    //默认的值为0
    public Utilisateur(){
        this.alimentation =  new Alimentation(0,1);
        this.autreBien = new AutreBien();
        this.logement = new Logement();
        this.transport = new Transport();
        /*this.logement = new Logement();
        this.transport=new Transport();*/
        this.servicesPublics = ServicesPublics.getServicesPublics();
        this.habillement = new Habillement();
        this.bienNumerique = new BienNumerique();
    }

    public Utilisateur(Alimentation a, AutreBien b, Logement l, Transport t, ServicesPublics s, Habillement h, BienNumerique bn){
        this.alimentation=a;
        this.autreBien =b;
        this.logement =l;
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
        System.out.println(bienNumerique);
        System.out.println(habillement);
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
        System.out.println("--------------getRecommantation----------------");
        System.out.println(getRecommandation());
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

    public Logement getLogement() {
        return logement;
    }

    public Appartement[] getAppartements(){
        return logement.getAppartements().toArray(new Appartement[0]);
    }

    public void addAppartement(Appartement appartement) {
        logement.addAppartement(appartement);
    }
    public Transport getTransport() {
        return transport;
    }

    public Voiture[] getVoitures(){
        return transport.getVoitures().toArray(new Voiture[0]);
    }

    public void addVoiture(Voiture voiture) {
        transport.addVoiture(voiture);
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
        if(transport.comparerAvecMoyen()>0){
            superieurAMoyen.add("Transports");
        }
        if(logement.comparerAvecMoyen()>0){
            superieurAMoyen.add("Logements");
        }

        return "L'ordre de vos plusieurs Poste de cosommations est :" +this.getListMiseEnOrder()+"\n"+
                "Dans les aspects suivants, votre émission dépasse le niveau moyen des Français : " + superieurAMoyen + " ,j'espère que vous pourrez y prêter attention!";
    }

    public List getListMiseEnOrder(){
        List<ConsoCarbone> posteDeConsomation = new ArrayList<ConsoCarbone>();
        posteDeConsomation.add(habillement);
        posteDeConsomation.add(bienNumerique);
        posteDeConsomation.add(logement);
        posteDeConsomation.add(servicesPublics);
        posteDeConsomation.add(autreBien);
        posteDeConsomation.add(alimentation);
        posteDeConsomation.add(transport);
        Collections.sort(posteDeConsomation);
        List<String> listMiseEnOrder = new ArrayList<>();
        for(ConsoCarbone consoCarbone : posteDeConsomation){
            listMiseEnOrder.add(consoCarbone.getClass().getName().substring(13));
        }
        return listMiseEnOrder;
    }
}
