package consoCarbone;

public enum CE {
    A(0.005),
    B(0.01),
    C(0.02),
    D(0.035),
    E(0.055),
    F(0.08),
    G(0.1);
    private double alpha;
    CE(double alpha) {
        this.alpha=alpha;
    }
    public double getAlpha(){
        return this.alpha;
    }

    public static CE getCEFromChar(char c) {
        // to upper case
        if(c >= 97)
            c -= 32;
        switch (c){
            case 'A': return CE.A;
            case 'B': return CE.B;
            case 'C': return CE.C;
            case 'D': return CE.D;
            case 'E': return CE.E;
            case 'F': return CE.F;
            case 'G': return CE.G;
        }
        return CE.A;
    }
}
