package Interfaces;

import java.util.Optional;
import java.util.OptionalInt;

public class File <T> extends FilePile<T> {
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
     * Removes and returns the next element in the queue. If the queue is empty, an empty {@link OptionalInt} is returned.
     * The method dynamically reduces the internal array size if the number of elements falls below half the current capacity,
     * ensuring efficient memory usage.
     *
     * @return an {@link OptionalInt} containing the next element of the queue if it is not empty, otherwise an empty {@link OptionalInt}.
     */
    @Override
    public Optional<T> pop() {
        if (estVide()) {
            return Optional.empty();
        }

        nbElement--;
        Optional<T> retour = Optional.of(tableau[pointeurPop++]);

        if (nbElement < (tableau.length + 1) / 2 && tableau.length * 3 / 4 >= tailleDepart) {
            T[] tempTableau = (T[]) new Object[tableau.length * 3 / 4];
            System.arraycopy(tableau, pointeurPop, tempTableau, 0, nbElement);
            tableau = tempTableau;
            pointeurPop = 0;
            pointeurPush = nbElement;
        }

        return  retour;
    }
}