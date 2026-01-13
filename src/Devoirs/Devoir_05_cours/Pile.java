package Devoirs.Devoir_05_cours;

import Devoirs.Devoir_05_cours.Structure.FilePile;
import java.util.OptionalInt;

public class Pile extends FilePile {
    /**
     * Constructs an instance of the Pile class with a specified size.
     * The size determines the initial capacity of the stack's internal array.
     *
     * @param taille the desired size of the internal array for the Pile
     */
    public Pile(int taille) {
        super(taille);
    }

    /**
     * Default constructor for the Pile class.
     * Initializes the Pile instance with default properties and behaviors inherited from the FilePile class.
     */
    public Pile() {
        super();
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

        var retour = OptionalInt.of(tableau[--pointeurPush]);
        if (nbElement < (tableau.length + 1) / 2 && tableau.length * 3 / 4 >= tailleDepart) {
            tableau = new int[tableau.length * 3 / 4];
            System.arraycopy(tableau, pointeurPop, tableau, 0, nbElement);
            // pointeurPop = 0;
            pointeurPush = nbElement;
        }

        return retour;
    }
}
