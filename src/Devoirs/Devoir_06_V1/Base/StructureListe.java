package Devoirs.Devoir_06_V1.Base;

import Devoirs.Devoir_06_V1.Interfaces.IFilePile;

import java.util.Optional;

/**
 * Structure de données basée sur une liste chaînée simple,
 * utilisée comme base pour implémenter une Pile (LIFO) ou une File (FIFO).
 *
 * @author Carole Gérard
 */
public abstract class StructureListe<T> extends ListeElement<T> implements IFilePile<T> {

    // =====================================================================================
    //                                  VARIABLE
    // =====================================================================================
    private ListeElement<T> head = null;


    // =====================================================================================
    //                                  CONSTRUCTEUR
    // =====================================================================================
    public StructureListe() {
        super();
    }


    // =====================================================================================
    //                                   FONCTIONS
    //                      push / pop / clear / size / estVide
    //                        trouveDernier / trouveLeReferent
    // =====================================================================================

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(T donnee) {
        if (donnee != null) {
            ListeElement<T> element = new ListeElement<>();
            element.setInfo(donnee);

            if (head == null) {
                head = element;
            } else {
                ListeElement<T> dernier = trouveDernier();
                dernier.setSuivant(element);
            }
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public abstract Optional<T> pop();

    /**
     * {@inheritDoc}
     *
     * Réinitialise la tête (head) à null.
     * Tous les maillons deviennent inaccessibles et seront libérés par le GC,
     * lorsque le système commecera à manquer de place mémoire.
     */
    @Override
    public void clear() { head = null; }


    /**
     * {@inheritDoc}
     *
     *  Le nombre d’éléments est calculé en parcourant la liste
     *  depuis la tête jusqu’au dernier maillon.
     */
    @Override
    public int size() {
        var nombre = 0;
        if (head == null) return nombre;
        else nombre++;
        ListeElement<T> el = head;
        while (el.getSuivant() != null) {
            el = el.getSuivant();
            nombre++;
        }
        return nombre;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean estVide() { return head == null; }


    /**
     * Retourne le dernier maillon de la liste.
     *
     * @return ListeElement dernier de la liste
     * @throws IllegalArgumentException si la liste est vide
     */
    public ListeElement<T> trouveDernier() {
        ListeElement<T> el = head;
        if (el == null) {
            throw new IllegalArgumentException("Liste vide");
        }
        while (el.getSuivant() != null) {
            el = el.getSuivant();
        }
        return el;
    }


    /**
     * Retourne le maillon précédent d'un élément (son référent) dans la liste.
     *
     * @param element le maillon dont on cherche le prédécesseur
     * @return le maillon précédent l'élément fourni en paramètre
     * @throws IllegalArgumentException si l'élément n'est pas trouvé dans la liste
     *                                  (ou si l'élément est la tête (head))
     */
    public ListeElement<T> trouveLeReferent(ListeElement<T> element) {
        ListeElement<T> el = head;
        while (el != null && el.getSuivant() != element) {
            el = el.getSuivant();
        }
        if (el == null) {
            throw new IllegalArgumentException("Element not found");
        }
        return el;
    }


    /**
     * Avance la tête de liste sur le maillon suivant.
     * Si la liste est vide, ne fait rien.
     */
    public void avanceHead() {
        if (head != null) head = head.getSuivant();
    }


    // =====================================================================================
    //                                Getters
    // =====================================================================================
    public ListeElement<T> getHead() {
        return head;
    }


    // =====================================================================================
    //                                     toString
    // =====================================================================================

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (head == null) {
            sb.append("]");
        } else {
            ListeElement<T> element = head;
            sb.append(element.getInfo());
            while (element.getSuivant() != null) {
                element = element.getSuivant();
                sb.append(", ").append(element.getInfo());
            }
            sb.append("]");
        }
        return sb.toString();
//        StringBuilder sb = new StringBuilder();
//        sb.append("\n======   État de la structure   ======\n");
//        sb.append("  🖼️ Contenu de la liste : ");
//        sb.append("[");
//        if (head == null) {
//            sb.append("]");
//        } else {
//            ListeElement<T> element = head;
//            sb.append(element.getInfo());
//            while (element.getSuivant() != null) {
//                element = element.getSuivant();
//                sb.append(", ").append(element.getInfo());
//            }
//            sb.append("]");
//            sb.append("\n      🗨️ Première donnée : ").append(head.getInfo());
//            sb.append("\n      🗨️ Dernière donnée : ").append(trouveDernier().getInfo());
//        }
//        sb.append("\n  👉 Nombre d'éléments : ").append(size());
//        sb.append("\n  🫗 VIDE ? ").append(estVide());
//        sb.append("\n=======================================\n");
//        return sb.toString();
    }
}