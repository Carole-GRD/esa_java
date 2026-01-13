package Devoirs.Devoir_06_V1;

import Devoirs.Devoir_06_V1.Base.StructureTableau;

import java.util.Optional;

/**
 * Implémentation d'une pile (LIFO) basée sur un tableau redimensionnable.
 *
 * @author Carole Gérard
 */
public class TableauPile<T> extends StructureTableau<T> {

    public TableauPile() {
        super();
    }

    /**
     * {@inheritDoc}
     *
     * Implémentation LIFO : retire le dernier élément.
     */
    @Override
    public Optional<T> pop() {
        if (estVide()) { return Optional.empty(); }

        increment("nbElement", -1);
        increment("pointeurPush", -1);   // avant de récupérer la valeur

        @SuppressWarnings("unchecked")
        T donnee = (T) getTableau()[getPointeurPush()];

        // ERREUR !!
        //getTableau()[getPointeurPush()-2] = "coucou";

        // important si T est un objet : on évite de garder une référence inutile
        // getTableau()[getPointeurPush()] = null;

        reduireTableau(getTableau());

        return Optional.ofNullable(donnee);
    }
}
