package consoCarbone;

public enum Categorie {
    CHEMISE(new int[]{13, 12},"chemise(s)",0),
    JEAN(new int[]{25},"jean(s)",1),
    TSHIRET(new int[]{7,10,6},"T-shirts",2),
    PULL(new int[]{28,26,31,56},"pulls",3),
    MANTEAU(new int[]{89,39,25},"manteau(x)",4),
    ROBE(new int[]{56,56}, "robe(s)",5),
    CHAUSSURE(new int[]{15,19,20},"chaussure(s)",6);

    private int[] cat_coeff;
    private String cat_name;
    private  int id;

    Categorie(int[] cat_coeff, String cat_name, int id){
        this.cat_coeff=cat_coeff;
        this.cat_name=cat_name;
        this.id=id;
    }

    public int[] getCat_coeff(){
        return this.cat_coeff;
    }

    public String getCat_name(){return this.cat_name;}

    public int getId(){return this.id;}

    public int getLength(){
        return cat_coeff.length;
    }



}
