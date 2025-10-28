package Bases;

/*
IntelliCode, IntelliSense
Version Ultimate ?
 */

public class ClassWithoutStatic {
    private int valeur;

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

}

class ClassWithStatic {
    static private int valeur;
    private int nombre = 42;
    static final public double pi = 3.1415;

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    static public void afficher() {
        System.out.println("coucou");
        System.out.println(valeur);
        //System.out.println(nombre);

    }
}

class TestStaticOrNot {
    public static void main(String[] args) {
        ClassWithoutStatic t1 = new ClassWithoutStatic();
        t1.setValeur(10);
        System.out.println(t1.getValeur());
        ClassWithoutStatic t2 = new ClassWithoutStatic();
        t2.setValeur(20);
        System.out.println(t2.getValeur());
        System.out.println();
        ClassWithStatic t3 = new ClassWithStatic();
        t3.setValeur(10);
        System.out.println(t3.getValeur());
        ClassWithStatic t4 = new ClassWithStatic();
        t4.setValeur(20);
        System.out.println(t4.getValeur());

        ClassWithStatic.afficher();
        //ClassWithStatic.pi;

    }
}