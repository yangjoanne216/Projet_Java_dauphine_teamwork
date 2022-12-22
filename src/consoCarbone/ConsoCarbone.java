package consoCarbone;

public abstract class ConsoCarbone implements Comparable<ConsoCarbone>   {
    protected static int nbConsoCarbone=0;
    protected int id;
    protected double impact;


    public ConsoCarbone() {
        this.id = nbConsoCarbone++;
    }

    public static int getNbConsoCarbone() {
        return nbConsoCarbone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getImpact(){
        return this.impact;
    }
//    public void setImpact(double impact){
//        this.impact=impact;
//    }


    @Override
    public int compareTo(ConsoCarbone o) {
        return (int)(this.impact-o.impact);
    }

}
