package Devoirs.Devoir_05_cours;

import java.util.OptionalInt;

public class FileAvecRotation extends File {
    public FileAvecRotation() {
        super();
    }

    public FileAvecRotation(int taille) {
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
        pointeurPop = pointeurPop % tableau.length;

        if (nbElement < (tableau.length + 1) / 2 && tableau.length * 3 / 4 >= tailleDepart) {
            var tempTableau = new int[tableau.length * 3 / 4];
            for (int i = 0; i < nbElement; i++) {
                tempTableau[i] = tableau[(pointeurPop + i) % tableau.length];
            }

            tableau = tempTableau;
            pointeurPop = 0;
            pointeurPush = nbElement;
        }

        return retour;
    }

    /**
     * Pushes an integer element onto the data structure. If the underlying array is full, it dynamically
     * increases the size of the array. For queue-specific functionality, it rearranges the array
     * elements to accommodate new entries at the appropriate position.
     *
     * @param element the integer value to be added to the data structure
     */
    @Override
    public void push(int element) {
        if (estPleine()) {
            var tempTableau = new int[tableau.length + tailleDefaut];
            System.arraycopy(tableau, pointeurPop, tempTableau, 0,
                    tableau.length - pointeurPop);
            System.arraycopy(tableau, 0, tempTableau,
                    tableau.length - pointeurPop, pointeurPop);
            tableau = tempTableau;
            pointeurPush = nbElement;
            pointeurPop = 0;
        }
        tableau[pointeurPush++] = element;
        pointeurPush = pointeurPush % tableau.length;
        nbElement++;
    }

    /**
     * Returns a string representation of the current state of the data structure.
     * The output includes the elements of the structure in their respective order,
     * enclosed within square brackets and separated by commas.
     *
     * @return a string representation of the elements in the data structure
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nbElement; i++) {
            sb.append(tableau[(pointeurPop + i) % tableau.length]).append(", ");
        }
        if (nbElement > 0)
            sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();

    }
}
