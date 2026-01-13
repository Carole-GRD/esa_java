package Devoirs.Devoir_06_V1;

import Devoirs.Devoir_06_V1.Base.ListeElement;
import Devoirs.Devoir_06_V1.Base.StructureListe;

import java.util.Optional;

/**
 * Implémentation d'une pile (LIFO) basée sur une liste chaînée.
 *
 * @author Carole Gérard
 */
public class ListePile<T> extends StructureListe<T> {

    public ListePile() {
        super();
    }

    /**
     * {@inheritDoc}
     *
     * Implémentation LIFO : retire le dernier élément.
     */
    @Override
    public Optional<T> pop() {
        if (getHead() == null) return Optional.empty();

        ListeElement<T> dernier = trouveDernier();
        T donnee = dernier.getInfo();
        if (getHead() == dernier) {
            clear();
        } else {
            ListeElement<T> avantDernier = trouveLeReferent(dernier);
            avantDernier.setSuivant(null);
        }
        return Optional.of(donnee);
    }
}