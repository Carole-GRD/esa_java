package Devoirs.Devoir_05;

import Devoirs.Devoir_05.Parent.FilePile;
import java.util.OptionalInt;

/**
 * Classe représentant une file d’attente d’entiers avec gestion de rotation du tableau.
 * Hérite de FilePile et spécialise les opérations d’ajout (push) et de retrait (pop) de type FIFO.
 * -
 * Auteur  : Carole Gérard
 * Date    : 29/10/2025
 * IA      : Documentation générée par chatGPT, Grok et Perplexity
 */
public class FileAvecRotation extends FilePile {

    /**
     * Constructeur permettant de définir la taille initiale du tableau.
     * @param taille taille initiale désirée pour la file avec rotation.
     */
    public FileAvecRotation(int taille) {
        super(taille);
    }

    /**
     * Constructeur par défaut.
     * Initialise la pile avec la taille définie par défaut (héritée).
     */
    public FileAvecRotation() {
        super();
    }

    /**
     * Ajoute une valeur en fin de file avec gestion de la rotation et réorganisation dynamique.
     * Si la file est pleine, agrandit le tableau ou le réorganise selon l’état des pointeurs internes.
     * Remet le pointeur d’insertion au début en cas de dépassement.
     * @param valeur valeur entière à ajouter.
     */
    @Override
    public void push(int valeur) {

        if (estPleine() && pointeurPop == 0 && pointeurPush == tableau.length) {
            agrandirTableau();
        }
        else if (estPleine() && pointeurPop == pointeurPush) {
            reorganiserElements();
            agrandirTableau();
        }

        // Insérer la valeur
        tableau[pointeurPush++] = valeur;
        nbElement++;

        // Revenir au début du tableau quand on atteint la fin
        if (pointeurPush == tableau.length) {
            pointeurPush = 0;
        }

        System.out.printf("\n======   Valeur ajoutée sur la file avec rotation : %d   ======%n", valeur);
    }

    /**
     * Retire la valeur présente en tête de la file et gère la rotation automatique des pointeurs.
     * Réorganise et réduit la taille du tableau si nécessaire après retrait.
     * @return un OptionalInt contenant la valeur retirée, ou OptionalInt.empty si la file est vide.
     */
    @Override
    public OptionalInt pop() {
        // Test si la file est vide
        if (tableauVide("file avec rotation")) {
            return OptionalInt.empty();
        }

        // Retrait de l'élément du tableau
        int valeur = 0;
        valeur = tableau[pointeurPop];
        tableau[pointeurPop] = 0;
        pointeurPop++;
        nbElement--;

        // Revenir au début du tableau quand on atteint la fin
        if (pointeurPop == tableau.length) {
            pointeurPop = 0;
        }

        // Si Pas beaucoup d'élément dans le tableau -> réduction taille tableau
        reductionTailleTableau("file avec rotation");

        System.out.printf("\n======   Valeur supprimée de la file avec rotation : %d   ======%n", valeur);
        return OptionalInt.of(valeur);
    }

}
