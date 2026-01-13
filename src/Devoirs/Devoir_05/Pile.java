package Devoirs.Devoir_05;

import Devoirs.Devoir_05.Parent.FilePile;
import java.util.OptionalInt;

/**
 * Classe représentant une pile d'entiers basée sur un tableau dynamique.
 * Hérite du comportement de FilePile et spécifie les opérations d’ajout (push) et de retrait (pop) en mode pile (LIFO).
 * -
 * Auteur  : Carole Gérard
 * Date    : 29/10/2025
 * IA      : Documentation générée par chatGPT, Grok et Perplexity
 */
public class Pile extends FilePile {

    /**
     * Constructeur permettant de définir la taille initiale du tableau.
     * @param taille taille initiale désirée pour la pile.
     */
    public Pile(int taille) {
        super(taille);
    }

    /**
     * Constructeur par défaut.
     * Initialise la pile avec la taille définie par défaut (héritée).
     */
    public Pile() {
        super();
    }

    /**
     * Empile une nouvelle valeur en fin de pile.
     * Agrandit automatiquement la taille du tableau si la pile est pleine.
     * @param valeur valeur entière à ajouter.
     */
    @Override
    public void push(int valeur) {
        // Si tableau plein -> on agrandit le tableau
        agrandirTableau();

        // Ajout de l'élément dans le tableau
        tableau[pointeurPush++] = valeur;
        nbElement++;
        //System.out.printf("\n======   Valeur ajoutée sur la pile : %d   ======%n", valeur);
    }

    /**
     * Dépile la dernière valeur de la pile si elle n'est pas vide.
     * Réduit la taille du tableau si le nombre d'éléments le justifie.
     * @return un OptionalInt contenant la valeur retirée, ou OptionalInt.empty si la pile est vide.
     */
    @Override
    public OptionalInt pop() {
        // Test si la pile est vide
        if (tableauVide("pile")) {
            return OptionalInt.empty();
        }

        // Retrait de l'élément du tableau
        int valeur = 0;
        valeur = tableau[pointeurPush - 1];
        tableau[pointeurPush - 1] = 0;
        pointeurPush--;
        nbElement--;

        // Si Pas beaucoup d'élément dans le tableau -> réduction taille tableau
        reductionTailleTableau("pile");

        //System.out.printf("\n======   Valeur supprimée de la pile : %d   ======%n", valeur);
        return OptionalInt.of(valeur);
    }
}
