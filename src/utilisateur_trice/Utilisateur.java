package utilisateur_trice;

import consoCarbone.*;

import java.io.FileNotFoundException;
import java.util.*;

public class Utilisateur {
    private Alimentation alimentation;
    private AutreBien autreBien;
    private Logement logement;
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

    public Utilisateur(String path) {
        this();
        int cursor = 0;
        try {
            String[] data = TextReader.readText(path);
            int nbVoiture = Integer.parseInt(data[cursor]);
            cursor += 1;
            for(int i=cursor; i<cursor+nbVoiture; i++) {
                String[] temp = data[i].split(",");
                Taille taille = temp[0]=="P" ? Taille.P : Taille.G;
                int amortissement = Integer.parseInt(temp[1]);
                int kiloAnnee = Integer.parseInt(temp[2]);
                transport.addVoiture(new Voiture(true, taille, kiloAnnee, amortissement));
            }
            cursor += nbVoiture;
            int nbAppart = Integer.parseInt(data[cursor]);
            cursor += 1;
            for(int i=cursor; i<cursor+nbAppart; i++) {
                String[] temp = data[i].split(",");
                int surface = Integer.parseInt(temp[0]);
                CE ce = CE.getCEFromChar(temp[1].charAt(0));
                logement.addAppartement(new Appartement(surface, ce));
            }
            cursor += nbAppart;
            String[] temp = data[cursor].split(";");
            int i=0;
            for(Categorie c : Categorie.values()) {
                String[] temp2 = temp[i].split(",");
                List<Integer> numbers = new ArrayList<>();
                for(String str : temp2) {
                    numbers.add(Integer.parseInt(str));
                }
                habillement.setCat(c, numbers);
                i++;
            }
            cursor += 1;
            this.autreBien.setMontant(Double.parseDouble(data[cursor]));
            cursor += 1;
            temp = data[cursor].split(",");
            alimentation.setTxBoeuf(Double.parseDouble(temp[0]));
            alimentation.setTxVege(Double.parseDouble(temp[1]));
        } catch (FileNotFoundException e) {
            System.out.println("Le chemin de la fichier n'est pas valide");
        } catch (Exception e) {
            System.out.println("Décoder erreur");
        }
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
