package Devoirs.Devoir_06_V1;

import Devoirs.Devoir_06_V1.Base.StructureListe;

import java.util.Optional;

/**
 * Implémentation d'une file (FIFO) basée sur une liste chaînée.
 *
 * @author Carole Gérard
 */
public class ListeFile<T> extends StructureListe<T> {

    public ListeFile() {
        super();
    }

    /**
     * {@inheritDoc}
     *
     * Implémentation FIFO : retire l'élément en tête.
     */
    @Override
    public Optional<T> pop() {
        if (getHead() == null) return Optional.empty();

        T donnee = getHead().getInfo();
        if (getHead() == trouveDernier()) {
            clear();
        } else {
            avanceHead();
        }
        return Optional.of(donnee);
    }
}