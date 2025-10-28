package Bases;

public class MaClassePile {
    // visibilité des attributs : private, protected, [package-level], public
    // ne pas mettre de visibilité revient à mettre "package-level" que l'éditeur ne connait pas
    // pour les "package-level" dans le "package Bases" par exemple,
    // tous les attributs seront accessible dans tout le dossier "Bases"

    int[] tableau = new int[3];
//    private int[] tableau = new int[3];
    private int taille = 0;

    // boite noir, encapsulation
    public void empiler(int valeur) {
        if (taille < tableau.length) {
            tableau[taille++] = valeur;
            System.out.printf("valeur AJOUTÉ sur la pile : %d %n", valeur);
        } else {
            System.out.println("La pile est pleine !");
        }
    }
    /*
     * Changer la méthode "empiler" pour que si le tableau est plein,
     * vous agrandissiez le tableau à partir d'une constante que vous appellerez 'step'
     */

    //public int depiler() {
    //    if (taille > 0) {
    //        return tableau[--taille];
    //    }
    //    return -1;
    //}
    public void depiler() {
        if (taille > 0) {
            System.out.printf("valeur SUPPRIMÉ de la pile : %d %n", tableau[--taille]);
        } else {
            System.out.println("La pile est vide !");
        }
    }
    /*
     * Changer la méthode "depiler" pour que :
     *      a. Si le nombre d'élément est plus petit que la moitié du tableau,
     *         vous réduisez la taille du tableau d'un quart
     *      b. La méthode doit retourner un booléen pour indiquer
     *         si il y avait bien une donnée à dépiler
     */

    public int getTaille() {
        return taille;
    }

    public int[] getTableau() {
        return tableau;
    }

    public boolean estPleine() {
        return taille == tableau.length;
    }

    public boolean estVide() {
        return taille == 0;
    }
}