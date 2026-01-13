package Interfaces;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class Pile<T> extends FilePile<T> implements ContratFilePile <T>{
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
    public Optional<T> pop() {
        if (estVide()) {
            return Optional.empty();
        }

        nbElement--;
        Optional<T> retour = Optional.of(tableau[--pointeurPush]);;

        if (nbElement < (tableau.length + 1) / 2 && tableau.length * 3 / 4 >= tailleDepart) {
            tableau = Arrays.copyOf(tableau, tableau.length * 3 / 4);
            pointeurPush = nbElement;
        }

        return retour;
    }
}
