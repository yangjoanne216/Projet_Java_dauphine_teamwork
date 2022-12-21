package view_console;

import consoCarbone.AutreBien;
import consoCarbone.BienConso;
import consoCarbone.BienNumerique;
import utilisateur_trice.Utilisateur;

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

    public void setBienNumerique() {
        // 玩电脑多不多
        System.out.print("你他妈老玩电脑吗(T ou F):\n> ");
        char intensif = Utils.getUpperCase(Utils.readKey());
        while(intensif != 'T' && intensif != 'F'){
            System.out.print("(T ou F)> ");
            intensif = Utils.getUpperCase(Utils.readKey());
        }
        // 设备高不高级
        System.out.print("你他妈电脑屌不屌(T ou F):\n> ");
        char high = Utils.getUpperCase(Utils.readKey());
        while(high != 'T' && high != 'F'){
            System.out.print("(T ou F)> ");
            high = Utils.getUpperCase(Utils.readKey());
        }
        // 新建BienConso
        BienNumerique bien = new BienNumerique(intensif=='T', high=='T');
        user.setBienNumerique(bien);
    }

    public void setAutreBien() {
        // 其他东西
        System.out.print("Le montant d'autre bien:\n> ");
        double montant = Utils.readDouble();
        while(montant < 0){
            System.out.print("(la valeur soit positive)> ");
            montant = Utils.readDouble();
        }
        // 新建BienConso
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
                    System.out.println("还没写");
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
