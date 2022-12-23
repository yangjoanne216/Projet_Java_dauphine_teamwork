package view_console;

import consoCarbone.AutreBien;
import consoCarbone.BienConso;
import consoCarbone.BienNumerique;
import consoCarbone.Habillement;
import utilisateur_trice.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class BienConsoUI {

    private Utilisateur user;
    private String[] menuTitle;

    public BienConsoUI(Utilisateur user) {
        this.user = user;
        menuTitle = new String[]{
                "habillement",
                "Bien numérique",
                "Autre bien"
        };
    }

    public String Menu(){
        String res = "========Bien conso=========\n";
        for(int i=0; i<menuTitle.length; i++) {
            res += i+". " + menuTitle[i] + ";\n";
        }
        res += "r pour retourner";
        return res;
    }

    public int getAnIntValue(String question) {
        System.out.print(question);
        int value = Utils.readInt();
        while(value<0){
            System.out.print("(la valeur soit un entier positif)> ");
            value = Utils.readInt();
        }
        return value;
    }

    public void setHabillement() {
        System.out.println("接下来你会输入一大堆数字，很长很长的输入过程。我觉得这样的输入非常的蠢，但是杨洋老师一定要我写出来，那我就这么写吧");
        // 首先创造一个数据结构，用来存储这些数
        List<Integer>[] data = new List[7];
        for(int i=0; i<7; i++){
            data[i] = new ArrayList<>();
        }
        // Chemise
        data[0].add(getAnIntValue("Nombre de chemise coton : "));
        data[0].add(getAnIntValue("Nombre de chemise viscose : "));
        // Jean
        data[1].add(getAnIntValue("Nombre de jean coton : "));
        // T-short
        data[2].add(getAnIntValue("Nombre de T-shirt coton : "));
        data[2].add(getAnIntValue("Nombre de polo : "));
        data[2].add(getAnIntValue("Nombre de T-shirt polyster à usage sportif : "));
        // Pull
        data[3].add(getAnIntValue("Nombre de Pull acrylique : "));
        data[3].add(getAnIntValue("Nombre de Polaisre en polyester recyclé : "));
        data[3].add(getAnIntValue("Nombre de sweat en coton : "));
        data[3].add(getAnIntValue("Nombre de pull en laine : "));
        // Manteau
        data[4].add(getAnIntValue("Nombre de manteau : "));
        data[4].add(getAnIntValue("Nombre de veste impre-respirantex : "));
        data[4].add(getAnIntValue("Nombre de veste simili cuir : "));
        // Robe
        data[5].add(getAnIntValue("Nombre de robe en polyester : "));
        data[5].add(getAnIntValue("Nombre de robe en coton : "));
        // Chaussures
        data[6].add(getAnIntValue("Nombre de Chaussures cuir : "));
        data[6].add(getAnIntValue("Nombre de Chaussures tissu : "));
        data[6].add(getAnIntValue("Nombre de Chaussures de sport : "));
        // 创建Habillement
        Habillement habillement = new Habillement(data);
        user.setHabillement(habillement);
    }

    public void setBienNumerique() {
        System.out.print("Vous utilisez souvent l'ordinateur? (T ou F):\n> ");
        char intensif = Utils.getUpperCase(Utils.readKey());
        while(intensif != 'T' && intensif != 'F'){
            System.out.print("(T ou F)> ");
            intensif = Utils.getUpperCase(Utils.readKey());
        }
        System.out.print("Votre Ordinateur est-il de haut gamme? (T ou F):\n> ");
        char high = Utils.getUpperCase(Utils.readKey());
        while(high != 'T' && high != 'F'){
            System.out.print("(T ou F)> ");
            high = Utils.getUpperCase(Utils.readKey());
        }
        BienNumerique bien = new BienNumerique(intensif=='T', high=='T');
        user.setBienNumerique(bien);
    }

    public void setAutreBien() {
        System.out.print("Le montant d'autre bien:\n> ");
        double montant = Utils.readDouble();
        while(montant < 0){
            System.out.print("(la valeur soit positive)> ");
            montant = Utils.readDouble();
        }
        // créer BienConso
        AutreBien bien = new AutreBien(montant);
        user.setAutreBien(bien);
    }


    public void start() {
        System.out.println(Menu());
        System.out.print("> ");
        char choise = Utils.readKey();
        boolean invalideInput = false;
        while(choise != 'r') {
            switch (choise){
                case '0':
                    setHabillement();
                    System.out.println("Succeed");
                    break;
                case '1':
                    setBienNumerique();
                    System.out.println("Succeed");
                    break;
                case '2':
                    setAutreBien();
                    System.out.println("Succeed");
                    break;
                default:
                    invalideInput = true;

            }
            if(invalideInput) {
                invalideInput = false;
            }else {
                System.out.println();
                System.out.println(Menu());
            }
            System.out.print("> ");
            choise = Utils.readKey();
        }
    }


}
