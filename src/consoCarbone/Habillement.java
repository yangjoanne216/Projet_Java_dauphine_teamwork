package consoCarbone;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Habillement extends BienConso{
    List<Integer>[] nombre_habillement;

    public Habillement(){
        nombre_habillement = new List[7];
        for(int i=0;i<nombre_habillement.length;i++){
            nombre_habillement[i] = new ArrayList<>();
        }
        for(Categorie categorie : Categorie.values()){
            int i=categorie.getId();
            for(int j=0;j<categorie.getLength();j++){
                nombre_habillement[i].add(0);
            }
        }
    }

    public double getImpact(){
        impact=0;
        for(Categorie categorie: Categorie.values()){
            impact+=getImpact(categorie);
        }
        return impact;
    }
    public static double getInfoMoyenne() {
        return 763;
    }
    public double comparerAvecMoyen(){
        return this.impact-getInfoMoyenne();
    };

    public double getImpact(Categorie categorie){
        return multiplicationDeuxTableaux(categorie.getCat_coeff(),nombre_habillement[categorie.getId()]);
    }

    public void  setCat(Categorie categorie, int[] nombre_cat){
        //TODO 如果nombre_cat的长度与cat长度不同报错
        if(nombre_cat.length!=categorie.getLength()){
            throw new RuntimeException("vous devez entrer "+nombre_cat.length+" chiffres，pour le catégorie "+categorie.getCat_name());
        }
    nombre_habillement[categorie.getId()]= Arrays.stream(nombre_cat).boxed().collect(Collectors.toList());
       }

    public void  setCat(Categorie categorie, List<Integer> nombre_cat){
        //TODO 如果nombre_cat的长度与cat长度不同报错
        if(nombre_cat.size()!=categorie.getLength()){
            throw new RuntimeException("vous devez entrer "+nombre_cat.size()+" chiffres，pour le catégorie "+categorie.getCat_name());
        }
        nombre_habillement[categorie.getId()]= nombre_cat;

    }
    private static int multiplicationDeuxTableaux(int[] tableau1, List<Integer> list){
        int resultat=0;
        for(int i = 0; i< tableau1.length; i++){
            resultat+= tableau1[i]* list.get(i);
        }
        return resultat;
    }

    public int getNombreCat(Categorie categorie){
        return getSommeTableau(nombre_habillement[categorie.getId()]);
    }

    private static int getSommeTableau(List<Integer> list1){
        int somme =0;
        for(int element : list1){
            somme +=element;
        }
        return somme;
    }

    public String stringBycat(Categorie categorie){
        return "vous avez "+ getNombreCat(categorie)+" "+ categorie.getCat_name()+", l'impact est : "+ getImpact(categorie)+"\n";

    }

    public String toString(){
        String result =  "Habillement : id =" + id +"\n"+"Votre impact sur habillement : "+ this.getImpact()+"\n";
        for(Categorie categorie: Categorie.values()){
            result+=stringBycat(categorie);
        }
        return result;
    }

    public static void main(String[] args) {
        Habillement h1= new Habillement();
        System.out.println(h1);
        h1.setCat(Categorie.CHAUSSURE,new int[]{2,3,3});
        h1.setCat(Categorie.CHEMISE,new int[]{3,4});
        System.out.println(h1);
    }





}
