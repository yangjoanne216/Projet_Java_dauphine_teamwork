package utilisateur_trice;

import consoCarbone.*;

public class Utilisateur {
    private Alimentation alimentation;
    private BienConso bienConso;
    private Logement logement;
    private Transport transport;
    private ServicesPublics servicesPublics;

    private Habillement habillement;

    public Utilisateur(Alimentation a,BienConso b,Logement l, Transport t,ServicesPublics s,Habillement h){
        this.alimentation=a;
        this.bienConso=b;
        this.logement=l;
        this.transport=t;
        this.servicesPublics=s;
        this.habillement=h;
    }
    public double calculerEmpreinte(){
        return alimentation.getImpact()+bienConso.getImpact()+ logement.getImpact()+ transport.getImpact()+servicesPublics.getImpact()+habillement.getImpact();
    }
    public void detaillerEmpreinte(){
        System.out.println("Volià des informations sur votre empreinte carbon");
        System.out.println("-------------------------------------------------");
        System.out.println("--------------1.Alimentation---------------------");
        System.out.println(alimentation);
        System.out.println("--------------2.BienConsommé---------------------");
        System.out.println(bienConso);
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

}
