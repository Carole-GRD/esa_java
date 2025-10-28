package Devoirs.Devoir_03;

/**
 * MaClassePile — implémentation d’une pile d’entiers.
 * Objet : opérations de base d’une pile (empiler, dépiler, estVide, estPleine).
 * Auteur : Carole Gérard
 * Date : 13/10/2025
 * IA : aide uniquement pour les commentaires
 */
public class MaClassePile {
    // TODO : mettre le tableau en "public" pour afficher les éléments de la pile,
    //  ainsi que toutes les cases du tableau, utilisées ou non
    //  et décommenter les parties de code pour l'affichage des cases
    //  dans le fichier DevoirTestPile.java (lignes 96 à 99 et 102 à 105)
    public int[] tableau = new int[3];
    //private int[] tableau = new int[3];

    private int taille = 0;

    final int STEP = 1;

    /*
     * Changer la méthode "empiler" pour que si le tableau est plein,
     * vous agrandissiez le tableau à partir d'une constante que vous appellerez 'step'
     */

    /**
     * Empile une valeur au sommet de la pile.
     * @param valeur valeur à empiler
     */
    public void empiler(int valeur) {
        if (taille < tableau.length) {
            tableau[taille++] = valeur;
            System.out.printf("valeur AJOUTÉ sur la pile : %d %n", valeur);
        } else {
            int[] tableauCopy = tableau;
            tableau = new int[taille + STEP];
            //System.arraycopy(tableauCopy, 0, tableau, 0, tableauCopy.length);
            for (int i = 0; i < tableauCopy.length; i++) {
                tableau[i] = tableauCopy[i];
            }
            tableau[taille++] = valeur;
            System.out.printf("valeur AJOUTÉ sur la pile : %d %n", valeur);
        }
    }


    /*
     * Changer la méthode "depiler" pour que :
     *      a. Si le nombre d'élément est plus petit que la moitié du tableau,
     *         vous réduisez la taille du tableau d'un quart
     *      b. La méthode doit retourner un booléen pour indiquer
     *         si il y avait bien une donnée à dépiler
     */

    /**
     * Dépile la valeur au sommet de la pile.
     * @return false s'il n'y avait pas de valeur à dépiler ou true s'il y avait bien une valeur à dépiler
     */
    public boolean depiler() {
        if (taille > 0) {
            System.out.printf("valeur SUPPRIMÉ de la pile : %d %n", tableau[--taille]);
            tableau[taille] = 0;

            if (taille < tableau.length/2) {
                int[] tableauCopy = tableau;
                int longueur = tableau.length * 3 / 4;
                tableau = new int[longueur];
                for (int i = 0; i < longueur; i++) {
                    tableau[i] = tableauCopy[i];
                }
            }

            return true;
        } else {
            System.out.println("La pile est vide !");
            return false;
        }
    }

    /**
     * Renvoie la taille logique (nombre d’éléments présents).
     * @return taille actuelle de la pile
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Indique si la pile a atteint sa capacité.
     * @return true si taille == tableau.length, sinon false
     */
    public boolean estPleine() {
        return taille == tableau.length;
    }

    /**
     * Indique si la pile ne contient aucun élément.
     * @return true si taille == 0, sinon false
     */
    public boolean estVide() {
        return taille == 0;
    }
}
