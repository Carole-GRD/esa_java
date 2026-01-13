package Devoirs.Devoir_06_V1;

import Devoirs.Devoir_06_V1.Base.StructureTableau;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Implémentation d'une file (FIFO) basée sur un tableau redimensionnable.
 *
 * @author Carole Gérard
 */
public class TableauFile<T> extends StructureTableau<T> {

    public TableauFile() {
        super();
    }

    /**
     * {@inheritDoc}
     *
     * Implémentation FIFO : retire le premier élément.
     */
    @Override
    public Optional<T> pop() {
        if (estVide()) { return Optional.empty(); }

        increment("nbElement", -1);

        @SuppressWarnings("unchecked")
        T donnee = (T) getTableau()[getPointeurPop()];

        // important si T est un objet : on évite de garder une référence inutile
        // getTableau()[getPointeurPop()] = null;

        increment("pointeurPop", 1);  // après avoir récupérer la valeur

        reduireTableau(getTableau());

        return Optional.ofNullable(donnee);
    }
}


