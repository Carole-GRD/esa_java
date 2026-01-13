package Devoirs.Devoir_06_V1.Base;

import Devoirs.Devoir_06_V1.Interfaces.IFilePile;

import java.util.Arrays;
import java.util.Optional;

/**
 * Structure de données basée sur un tableau redimensionnable,
 * utilisée comme base pour implémenter une Pile (LIFO) ou une File (FIFO).
 *
 * @author Carole Gérard
 */
public abstract class StructureTableau<T> implements IFilePile<T> {

    // =====================================================================================
    //                                  VARIABLES
    // =====================================================================================
    static private final int tailleDepart = 4;

    private Object[] tableau;
    private int nbElement = 0;
    private int pointeurPush = 0;
    private int pointeurPop = 0;


    // =====================================================================================
    //                                  CONSTRUCTEUR
    // =====================================================================================
    public StructureTableau() {
        tableau = new Object[tailleDepart];
    }


    // =====================================================================================
    //                                  FONCTIONS
    //                         push / pop / clear / size
    //                           estVide / estPleine
    // =====================================================================================

    /**
     * {@inheritDoc}
     *
     *  Pour une file, si l'on arrive en fin de tableau et qu'il reste de la place en début,
     *  les éléments sont compactés au début (décalage) afin de continuer les insertions.
     */
    @Override
    public void push(T donnee) {
        if (donnee == null) return;
        if (estPleine()) {
            tableau = Arrays.copyOf(tableau, tableau.length + tailleDepart);
        } else {
            // Spécifique FILE
            if (pointeurPush == tableau.length) {
                System.arraycopy(tableau, pointeurPop, tableau, 0, nbElement);
                pointeurPush = nbElement;
                pointeurPop = 0;
            }
        }
        tableau[pointeurPush++] = donnee;
        nbElement++;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public abstract Optional<T> pop();


    /**
     * {@inheritDoc}
     *
     * Dans cette implémentation basée sur un tableau, le tableau interne est
     * recréé avec sa taille initiale et les index internes sont réinitialisés.
     */
    @Override
    public void clear() {
        tableau = new Object[tailleDepart];
        nbElement = 0;
        pointeurPush = 0;
        pointeurPop = 0;
    }


    /**
     * {@inheritDoc}
     *
     * Cette implémentation retourne la valeur du compteur interne.
     */
    @Override
    public int size() { return nbElement; }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean estVide() {
        return nbElement == 0;
    }


    /**
     * Indique si la structure est pleine.
     * Compare le nombre d'éléments stockés dans le tableau au nombre de cases du tableau.
     *
     * @return true si toutes les cases du tableau sont allouées à un élément,
     *         false sinon.
     */
    public boolean estPleine() {
        return (nbElement == tableau.length);
    }


    /**
     * Incrémente un compteur interne de la structure.
     *
     * Cette méthode modifie l'une des variables suivantes selon la valeur de {@code variable} :
     *   _ nbElement : nombre d'éléments stockés
     *   _ pointeurPush : position d'insertion dans le tableau
     *   _ pointeurPop : position de suppression dans le tableau
     *
     * @param variable nom de la variable interne à incrémenter (nbElement, pointeurPush, pointeurPop)
     * @param increment valeur (positive ou négative) à ajouter à la variable
     */
    public void increment(String variable, int increment) {
        switch (variable) {
            case "nbElement":
                nbElement += increment;
                break;
            case "pointeurPush":
                pointeurPush += increment;
                break;
            case "pointeurPop":
                pointeurPop += increment;
                break;
        }
    }


    /**
     * Réduit la capacité du tableau interne si la structure est suffisamment peu remplie,
     * tout en conservant l'ordre des éléments restants.
     *
     * La réduction s'effectue uniquement si :
     *  - moins de la moitié du tableau utilisée
     *  - la nouvelle capacité reste supérieure ou égale à la taille de départ
     *
     * @param oldTableau ancien tableau contenant les éléments avant réduction
     */
    public void reduireTableau(Object[] oldTableau) {
        if (nbElement < (oldTableau.length + 1) / 2
                && (int) Math.round((double) oldTableau.length * 3 / 4) >= tailleDepart) {
            int nouvelleLongueur = (int) Math.round((double) oldTableau.length * 3 / 4);
            tableau = new Object[nouvelleLongueur];
            System.arraycopy(oldTableau, pointeurPop, tableau, 0, nbElement);

            pointeurPop = 0;
            pointeurPush = nbElement;
        }
    }


    // =====================================================================================
    //                                       Getters
    // =====================================================================================

    public Object[] getTableau() {
        return tableau;
    }

    public int getNbElement() { return nbElement; }

    public int getPointeurPush() { return pointeurPush; }

    public int getPointeurPop() { return pointeurPop; }



    // =====================================================================================
    //                                      toString
    // =====================================================================================
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nbElement; i++) {
            sb.append(tableau[pointeurPush - nbElement + i]).append(", ");
        }
        if (nbElement > 0)
            sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
//        StringBuilder sb = new StringBuilder();
//        sb.append("\n======   État de la structure   ======\n");
//        sb.append("🖼️ Contenu du tableau : ");
//        sb.append("[");
//        for (int i = 0; i < nbElement; i++) {
//            sb.append(tableau[pointeurPush - nbElement + i]).append(", ");
//        }
//        if (nbElement > 0)
//            sb.delete(sb.length() - 2, sb.length());
//        sb.append("]");
//        sb.append("\n  👉 Nombre d'éléments : ").append(nbElement);
//        sb.append("\n  👉 Taille du tableau : ").append(tableau.length);
//        sb.append("\n     🫗 VIDE ? ").append(estVide());
//        sb.append("\n     🥛 PLEINE ? ").append(estPleine());
//        sb.append("\n        🅿️ Pointeur Pop : ").append(pointeurPop);
//        sb.append("\n        🅿️ Pointeur Push : ").append(pointeurPush);
//        sb.append("\n=====================================\n");
//        return sb.toString();
    }
}
