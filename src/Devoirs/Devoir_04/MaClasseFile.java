package Devoirs.Devoir_04;

import java.util.Arrays;

/**
 * MaClasseFile is a data structure that models a dynamic queue-like behavior with an
 * internal array for storing integers. It supports operations for adding elements,
 * removing elements, and checking the structure's status.
 *
 * Author  : Geoffroy Malherbe
 * Date    : 14/10/2025
 * Version : 1.0
 * IA      : Documentation writer
 */
public class MaClasseFile {
    private int[] tableau;
    private int nbElement = 0;
    private int pointeurPush = 0;
    private int pointeurPop = 0;
    private final int tailleDepart;
    private static final int step = 3;

    /**
     * Constructs a new instance of the MaClasseFile class with a specified initial array size.
     * If the specified size is less than or equal to 0, a default size is used.
     *
     * @param tailleTableau the initial size of the internal array. If this value is less than
     *                      or equal to 0, a default step size is used instead.
     */
    public MaClasseFile(int tailleTableau) {
        if (tailleTableau <= 0) {
            tailleTableau = step;
        }
        tableau = new int[tailleTableau];
        tailleDepart = tailleTableau;
    }

    /**
     * Constructs a new instance of the MaClasseFile class with a default initial array size.
     * The default size is determined by the value of the static constant `step`.
     * This constructor delegates to the parameterized constructor with the default size.
     */
    public MaClasseFile() {
        this(step);
    }

    /**
     * Adds a new element to the data structure. If the internal array is full, the array
     * will be resized to accommodate the new element. If necessary, elements in the
     * array will be shifted to ensure space is effectively utilized.
     *
     * @param valeur the integer value to be added to the data structure
     */
    public void push(int valeur) {
        System.out.println("=================================");    
        // Si tableau plein -> on agrandit le tableau
        if (estPleine()) {
            tableau = Arrays.copyOf(tableau, tableau.length + step);
        }

        // Si on est à la fin du tableau -> on décale vers la gauche
        if (pointeurPush == tableau.length) {
            System.arraycopy(tableau, pointeurPop, tableau, 0, nbElement);
            pointeurPop = 0;
            pointeurPush = nbElement;
        }

        // Ajout de l'élément dans le tableau
        tableau[pointeurPush++] = valeur;
        System.out.printf("Valeur ajoutée = %d%n", valeur);
        nbElement++;

        afficherFile();
    }

    /**
     * Removes the first element from the data structure, if present, and adjusts the
     * internal array size if necessary. The method also resets pointers and handles
     * internal resizing when required.
     *
     * @return {@code true} if an element was successfully removed; {@code false} if
     * the data structure was empty.
     */
    public boolean pop() {
        System.out.println("=================================");
        // Test si la file est vide
        if (estVide()) {
            System.out.println("La file est vide");
            pointeurPop = pointeurPush = 0;
            afficherFile();
            return false;
        }

        // Retrait de l'élément du tableau
        System.out.printf("Valeur supprimée = %d%n", tableau[pointeurPop++]);
        //tableau[pointeurPop - 1] = 0;
        nbElement--;

        // Si Pas beaucoup d'élément dans le tableau -> réduction taille tableau
        if (nbElement < tableau.length / 2 && tableau.length > tailleDepart) {
            var tempTableau = new int[tableau.length / 4 * 3];
            System.arraycopy(tableau, pointeurPop, tempTableau, 0, nbElement);
            tableau = tempTableau;
            pointeurPop = 0;
            pointeurPush = nbElement;
        }

        afficherFile();

        return true;
    }

    /**
     * Retrieves the current size of the internal array.
     *
     * @return the size of the array `tableau`.
     */
    public int getTailleTableau() {
        return tableau.length;
    }

    /**
     * Checks if the data structure is empty.
     *
     * @return {@code true} if the structure contains no elements, {@code false} otherwise.
     */
    public boolean estVide() {
        return nbElement == 0;
    }

    /**
     * Checks if the data structure is currently full.
     *
     * @return {@code true} if the number of elements in the structure is equal to the capacity
     *         of the internal array; {@code false} otherwise.
     */
    public boolean estPleine() {
        return nbElement == tableau.length;
    }

    /**
     * Retrieves the number of elements currently stored in the data structure.
     *
     * @return the number of elements in the structure.
     */
    public int getNbElement() {
        return nbElement;
    }


    public void afficherFile() {
        System.out.println("🖼️ Contenu du tableau : ");
        for (int i = 0; i < this.getTailleTableau(); i++) {
            System.out.printf("Case %d => Element : %d%n", i, this.tableau[i]);
        }
        System.out.println("-> Nombre d'éléments de la file : " + this.getNbElement());
        System.out.println("-> Taille du tableau : " + this.getTailleTableau());
    }
}
