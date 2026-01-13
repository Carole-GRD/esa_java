package Devoirs.Devoir_05.Parent;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Classe abstraite FilePile
 * -
 * Cette classe gère une structure de données basée sur un tableau dynamique d'entiers,
 * permettant une gestion efficace des opérations de pile ou file par pointeurs.
 * La classe fournit des fonctions d'agrandissement, de réduction, de réorganisation.
 * -
 * Auteur  : Carole Gérard
 * Date    : 29/10/2025
 * IA      : Documentation générée par chatGPT, Grok et Perplexity
 */
public abstract class FilePile {
    protected int[] tableau;
    protected int nbElement = 0;
    protected int pointeurPush = 0;
    protected int pointeurPop = 0;
    private final int tailleDepart;
    protected static final int step = 3;

    /**
     * Constructeur avec taille initiale personnalisée.
     * Initialise le tableau interne avec la taille spécifiée
     * (ou une valeur par défaut si la taille n'est pas correcte).
     *
     * @param tailleTableau la taille initiale du tableau interne ;
     *                      si cette valeur est <= 0, STEP est utilisé.
     */
    public FilePile(int tailleTableau) {
        if (tailleTableau <= 0) {
            tailleTableau = step;
        }
        tableau = new int[tailleTableau];
        tailleDepart = tailleTableau;
    }

    /**
     * Constructeur utilisant la taille par défaut.
     * Initialise le tableau avec la taille STEP.
     * Délègue au constructeur paramétré avec la valeur par défaut.
     */
    public FilePile() {
        this(step);
    }

    /**
     * Insère un nouvel élément dans la structure.
     * Méthode abstraite à définir dans la classe dérivée.
     * Peut agrandir ou réorganiser le tableau si nécessaire.
     *
     * @param valeur l'entier à insérer.
     */
    protected abstract void push(int valeur);

    /**
     * Agrandit la capacité du tableau interne si celui-ci est plein.
     * Recopie tous les éléments existants dans un nouveau tableau plus grand.
     * L'agrandissement se fait par pas fixe (step).
     * Ne fait rien si la structure n’est pas pleine.
     */
    public void agrandirTableau() {
        if (estPleine()) {
            tableau = Arrays.copyOf(tableau, tableau.length + step);
        }
    }

    /**
     * Décale les éléments valides vers la gauche du tableau.
     * Utilisé en cas de retrait multiple ou rotation.
     */
    public void decalageVersLaGauche() {
        if (!estPleine() && pointeurPush == tableau.length) {
            System.arraycopy(tableau, pointeurPop, tableau, 0, nbElement);
            pointeurPop = 0;
            pointeurPush = nbElement;
        }
    }

    /**
     * En cas de file avec rotation,
     * réorganise tous les éléments du tableau à partir des pointeurs internes.
     * Copie d'abord les éléments de la fin, puis ceux du début,
     * pour les ramener en continu au début du tableau.
     */
    public void reorganiserElements() {
        if (pointeurPop >= pointeurPush) {
            var tableauTemp = new int[tableau.length];
            var nbElementsDebutTableau = pointeurPush;
            var nbElementsFinTableau = nbElement - nbElementsDebutTableau;
            System.arraycopy(tableau, pointeurPop, tableauTemp, 0, nbElementsFinTableau);
            System.arraycopy(tableau, 0, tableauTemp, nbElementsFinTableau, nbElementsDebutTableau);
            tableau = tableauTemp;
            pointeurPop = 0;
            pointeurPush = nbElement;
        } else {
            decalageVersLaGauche();
        }
    }


    /**
     * Retire et retourne l'élément en tête de la structure.
     * Méthode abstraite à définir dans la classe dérivée.
     *
     * @return un OptionalInt contenant l'élément retiré, ou vide si la structure est vide.
     */
    public abstract OptionalInt pop();

    /**
     * Indique si le tableau est vide et réinitialise les pointeurs si tel est le cas.
     *
     * @param type nom de la structure pour les messages ( "file", "pile" ou "file avec rotation")
     * @return true si vide, false sinon.
     */
    public boolean tableauVide(String type) {
        if (estVide()) {
            //System.out.printf("La %s est vide ❗%n", type);
            pointeurPop = pointeurPush = 0;
            return true;
        }
        return false;
    }

    /**
     * Réduit la taille du tableau à 3/4 de sa taille actuelle si sous-utilisé.
     * Si l'argument passé est "file avec rotation", appelle la méthode reorganiserElements()} avant copie.
     *
     * @param type nom de la structure (utile en cas de rotation de file)
     */
    public void reductionTailleTableau(String type) {
        if (nbElement < (tableau.length + 1) / 2 && tableau.length > tailleDepart) {
            if (type.equals("file avec rotation")) {
                reorganiserElements();
            }
            var tempTableau = new int[tableau.length * 3 / 4];
            System.arraycopy(tableau, pointeurPop, tempTableau, 0, nbElement);
            tableau = tempTableau;
            pointeurPop = 0;
            pointeurPush = nbElement;
        }
    }

    /**
     * Vide complètement la structure : réinitialise le nombre d’éléments et les pointeurs,
     * et réalloue le tableau à la capacité de départ.
     */
    public void clear() {
        var tempTableau = new int[tailleDepart];
        System.arraycopy(tableau, 0, tempTableau, 0, 0);
        tableau = tempTableau;
        pointeurPop = pointeurPush = nbElement = 0;
        System.out.println("\n======   Le tableau a été vidé !   ======\n");
    }

    /**
     * Retourne la capacité actuelle (longueur) du tableau interne.
     *
     * @return la capacité du tableau (nombre de cases allouées)
     */
    public int getTailleTableau() {
        return tableau.length;
    }

    /**
     * Vérifie si la structure est vide (aucun élément présent).
     *
     * @return true si vide, false sinon.
     */
    public boolean estVide() {
        return nbElement == 0;
    }

    /**
     * Vérifie si la structure est pleine (aucune place restante).
     *
     * @return true si vide, false sinon.
     */
    public boolean estPleine() {
        return nbElement == tableau.length;
    }

    /**
     * Retourne le nombre d'éléments stockés dans la structure.
     *
     * @return le nombre d'éléments stockés.
     */
    public int size() {
        return nbElement;
    }

    /**
     * Fournit une représentation textuelle détaillée de l'état de la structure (utile pour le débogage).
     *
     * @return chaîne décrivant la structure et ses infos internes.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n======   État de la structure   ======\n");
        sb.append("🖼️ Contenu du tableau : ");
        for (int val : tableau) {
            sb.append(val).append(" ");
        }
        sb.append("\n  👉 Nombre d'éléments : ").append(nbElement);
        sb.append("\n  👉 Taille du tableau : ").append(tableau.length);
        sb.append("\n     🫗 VIDE ? ").append(estVide());
        sb.append("\n     🥛 PLEINE ? ").append(estPleine());
        sb.append("\n        🅿️ Pointeur Pop : ").append(pointeurPop);
        sb.append("\n        🅿️ Pointeur Push : ").append(pointeurPush);
        sb.append("\n=====================================\n");

        return sb.toString();
    }
}
