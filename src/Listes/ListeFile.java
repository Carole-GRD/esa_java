package Listes;

import Listes.ContratFilePile;

import java.util.Optional;

public class ListeFile<T> implements ContratFilePile<T> {
    private T info = null;
    private ListeFile<T> suivant = null;

    private ListeFile(T info) {
        this.info = info;
    }

    public ListeFile() { }

    public void push(T element) {
        if (element != null) {
            if (info == null) {
                info = element;
            } else {
                var temp = new ListeFile<>(element);
                var dernier = trouveDernier();
                dernier.suivant = temp;
            }
        }
    }

    public Optional<T> pop() {
        Optional<T> retour;
        if (suivant == null) {
             retour = Optional.ofNullable(info);
            info = null;
//            return retour;
        } else {

            retour = Optional.ofNullable(info);
            info = suivant.info;
            suivant = suivant.suivant;
        }

        return retour;
    }

    private ListeFile<T> trouveLeReferent(ListeFile<T> reference) {
        ListeFile<T> p = this;
        while (p.suivant != reference) {
            p = p.suivant;
        }
        return p;
    }

    private ListeFile<T> trouveDernier() {
        // Utilisation d'un pointeur p qui va parcourir chaque paire <info, suivant>
        ListeFile<T> p = this;
        // Parcourt toues les éléments de la liste pour s'arrêter sur le dernier
        // car le pointeur "suivant" du dernier vaut null
        while (p.suivant != null) {
            p = p.suivant;
        }
        return p;
    }

    public int size() {
        ListeFile<T> p = this;
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
