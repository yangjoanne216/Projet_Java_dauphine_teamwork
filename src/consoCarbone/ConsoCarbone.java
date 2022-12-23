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

    @Override
    public int compareTo(ConsoCarbone o) {
        if(this.getImpact()<o.getImpact())
            return -1;
        return this.getImpact()>o.getImpact() ? 1 : 0;

    }

}
