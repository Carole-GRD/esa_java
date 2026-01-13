package Devoirs.Devoir_05_cours;

import Devoirs.Devoir_05_cours.Structure.FilePile;

import java.util.Arrays;
import java.util.OptionalInt;

public class File extends FilePile {
    /**
     * Default constructor for the FilePile class.
     * Initializes the internal array with the default size.
     */
    public File() {
    }

    /**
     * Constructs an instance of the File class with a specified size.
     * Initializes the internal array with the given size.
     *
     * @param taille the desired size of the internal array for the File
     */
    public File(int taille) {
        super(taille);
    }

    /**
     * Removes and returns the top element of the stack, if present.
     * If the stack is empty, an empty {@link OptionalInt} is returned instead.
     *
     * @return an {@link OptionalInt} containing the top element of the stack
     * if it is not empty, otherwise an empty {@link OptionalInt}.
     */
    @Override
    public OptionalInt pop() {
        if (estVide()) {
            return OptionalInt.empty();
        }

        nbElement--;
        var retour = OptionalInt.of(tableau[pointeurPop++]);
        if (nbElement < (tableau.length + 1) / 2 && tableau.length * 3 / 4 >= tailleDepart) {
            tableau = Arrays.copyOf(tableau, tableau.length * 3 / 4);
            pointeurPop = 0;
            pointeurPush = nbElement;
        }

        return retour;
    }
}

