package consoCarbone;

public class ServicesPublics extends ConsoCarbone{
    private static ServicesPublics servicesPublics = new ServicesPublics();
    private ServicesPublics(){
        this.impact=1.5;
    }

    public static double getInfoMoyenne() {
        return 1.5;
    }
    public double comparerAvecMoyen(){
        return 0;
    };

    @Override
    public double getImpact() {
        return 1.5;
    }

    public static  ServicesPublics getServicesPublics(){
        return servicesPublics;
    }
    public String toString() {
        return "ServicesPublics : id =" + id +"\n"+
                "l'impact des servicesPublics en terme d'émissions de GES :  "+String.format("%.6f",impact)+" TCO2eq."+"\n";
    }
}