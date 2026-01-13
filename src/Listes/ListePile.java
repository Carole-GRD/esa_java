package Listes;

import Listes.ContratFilePile;

import java.util.Optional;

public class ListePile<T> implements ContratFilePile<T>  {
    private T info = null;
    private ListePile<T> suivant = null;

    private ListePile(T info) {
        this.info = info;
    }

    public ListePile() { }

    public void push(T element) {
        if (element != null) {
            if (info == null) {
                info = element;
            } else {
                var temp = new ListePile<>(element);
                var dernier = trouveDernier();
                dernier.suivant = temp;
            }
        }
    }

    public Optional<T> pop() {
        if (suivant == null) {
            var retour = Optional.ofNullable(info);
            info = null;
            return retour;
        }

        var dernier = trouveDernier();
        var retour = Optional.of(dernier.info);
        var referent = trouveLeReferent(dernier);
        referent.suivant = null;
//        trouveLeReferent(dernier).suivant = null;

        return retour;
    }

    private ListePile<T> trouveLeReferent(ListePile<T> reference) {
        ListePile<T> p = this;
        while (p.suivant != reference) {
            p = p.suivant;
        }
        return p;
    }

    private ListePile<T> trouveDernier() {
        // Utilisation d'un pointeur p qui va parcourir chaque paire <info, suivant>
        ListePile<T> p = this;
        // Parcourt toues les éléments de la liste pour s'arrêter sur le dernier
        // car le pointeur "suivant" du dernier vaut null
        while (p.suivant != null) {
            p = p.suivant;
        }
        return p;
    }

    public int size() {
        ListePile<T> p = this;
        var nombre = 0;
        if (info != null) nombre++;
        while (p.suivant != null) {
            p = p.suivant;
            nombre++;
        }
        return nombre;
    }

    @Override
    public boolean estPleine() {
        return false;
    }

    @Override
    public boolean estVide() {
        return info == null;
    }

    public void clear() {
        info = null;
        suivant = null;
    }
}
