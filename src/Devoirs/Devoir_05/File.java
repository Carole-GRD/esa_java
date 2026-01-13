package Devoirs.Devoir_05;

import Devoirs.Devoir_05.Parent.FilePile;
import java.util.OptionalInt;

/**
 * Classe représentant une file d’entiers, basée sur un tableau dynamique.
 * Hérite de FilePile et spécifie les opérations d’ajout (push) et de retrait (pop) en mode file (FIFO).
 * -
 * Auteur  : Carole Gérard
 * Date    : 29/10/2025
 * IA      : Documentation générée par chatGPT, Grok et Perplexity
 */
public class File extends FilePile {

    /**
     * Constructeur permettant de définir la taille initiale du tableau.
     * @param taille taille initiale désirée pour la file.
     */
    public File(int taille) {
        super(taille);
    }

    /**
     * Constructeur par défaut.
     * Initialise la file avec la taille définie par défaut (héritée).
     */
    public File() {
        super();
    }

    /**
     * Ajoute une valeur en fin de file.
     * Décale les éléments si le pointeur d'insertion est à la fin et que la file n'est pas pleine.
     * Agrandit automatiquement la taille du tableau si la file est pleine.
     * @param valeur valeur entière à ajouter.
     */
    @Override
    public void push(int valeur) {
        // Si on est à la fin du tableau -> on décale vers la gauche
        decalageVersLaGauche();

        // Si tableau plein -> on agrandit le tableau
        agrandirTableau();

        // Ajout de l'élément dans le tableau
        tableau[pointeurPush++] = valeur;
        nbElement++;
        //System.out.printf("\n======   Valeur ajoutée sur la file : %d   ======%n", valeur);
    }

    /**
     * Retire la valeur en tête de la file si elle n'est pas vide.
     * Réduit la taille du tableau si le nombre d’éléments le justifie.
     * @return un OptionalInt contenant la valeur retirée, ou OptionalInt.empty si la file est vide.
     */
    @Override
    public OptionalInt pop() {
        // Test si la file est vide
        if (tableauVide("file")) {
            return OptionalInt.empty();
        }

        // Retrait de l'élément du tableau
        int valeur = 0;
        valeur = tableau[pointeurPop];
        tableau[pointeurPop] = 0;
        pointeurPop++;
        nbElement--;

        // Si Pas beaucoup d'élément dans le tableau -> réduction taille tableau
        reductionTailleTableau("file");

        //System.out.printf("\n======   Valeur supprimée de la file : %d   ======%n", valeur);
        return OptionalInt.of(valeur);
    }
}
