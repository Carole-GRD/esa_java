package Bases;

public class Fonctions {
    public static void main(String[] args) {
        System.out.println( somme(1, 2) );
        System.out.println( somme(1L, 2L) );
        System.out.printf( "estPaire(11) = %b%n", estPaire(11) );
        afficher(7);

        sauter1Ligne();
        int nombre1 = 10, nombre2 = 20;
        swapNumbers(nombre1, nombre2);
        System.out.printf("Main: nombre1 = %d, nombre2 = %d%n", nombre1, nombre2);
    }


    /*
     * Ce qui distingue deux méthodes, c’est leur signature :
     *   nom + types et ordre des paramètres (les noms ne comptent pas).
     * En Java, le type de retour et les exceptions ne font pas partie de la signature.
     * Deux méthodes ayant le même nom mais des paramètres différents constituent une surcharge.
     */
    public static int somme(int a, int b) {
        return a + b;
    }

    public static long somme(long a, long b) {
        return a + b;
    }

    public static int somme(int a, int b, int c) {
        return a + b + c;
    }

    public static boolean estPaire(int a) {
        return a % 2 == 0;
    }

    public static void afficher(int a) {
        System.out.println(a);
    }

    public static void sauter1Ligne() {
        System.out.println();
    }


    /*
     * En Java, les paramètres sont passés par valeur :
     * une copie de la valeur est transmise à la méthode.
     * Pour les types primitifs, la valeur elle-même est copiée.
     * Pour les objets, c’est la référence qui est copiée (on peut modifier l’objet, mais pas la référence d’origine).
     */
    private static void swapNumbers(int nombre1, int nombre2) {
        int temp = nombre1;
        nombre1 = nombre2;
        nombre2 = temp;
        System.out.printf("Function: nombre1 = %d, nombre2 = %d%n", nombre1, nombre2);
    }

}
