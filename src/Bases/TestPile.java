package Bases;

/**
 * TestPile
 *
 * But : petit programme de test manuel pour la classe MaClassePile (pile d'entiers).
 * - Empile quelques valeurs, dépile, puis affiche l'état de la pile après chaque opération.
 * - Affiche le contenu via les accesseurs (getters) et — à titre de débogage — via l'accès direct au tableau interne.
 *
 * Remarques :
 * - L'accès direct au tableau interne (pile.tableau) viole l'encapsulation : à éviter dans du code "propre".
 *   Garder cet accès uniquement pour comprendre/visualiser ce qui se passe pendant les tests.
 */
public class TestPile {
    public static void main(String[] args) {
        // Bloc de test des arguments : à décommenter au besoin.
        //if ( args.length > 0) {
        //    System.out.println("Nombre d'arguments : " + args.length);
        //    for (String arg : args) {
        //        System.out.println("Argument : " + arg);
        //    }
        //}

        MaClassePile pile = new MaClassePile();

        // Exemple : si MaClassePile expose la taille et/ou le tableau en public (peu recommandé),
        // on pourrait forcer une taille.
        //pile.taille = 10;
        //pile.tableau = new int[pile.taille];

        // ----- Opération 1 : empiler 10 -----
        pile.empiler(10);
        afficherEtatPile(pile);
        afficherContenuPile(pile, true);

        // ----- Opération 2 : empiler 20 -----
        pile.empiler(20);
        afficherEtatPile(pile);
        afficherContenuPile(pile, true);

        // ----- Opération 3 : dépiler -----
        pile.depiler();
        afficherEtatPile(pile);
        afficherContenuPile(pile, true);

        // ----- Opération 4 : empiler 30 -----
        pile.empiler(30);
        afficherEtatPile(pile);
        afficherContenuPile(pile, true);
    }

    /*
     * À propos de static :
     * - Une méthode "static" appartient à la classe et non à une instance.
     * - On peut donc appeler afficherEtatPile(...) sans créer d'objet TestPile :
     *     TestPile.afficherEtatPile(pile);
     *   (l'appel direct dans main est possible car main est aussi static).
     *
     * Différence "static" vs "instance" (rappel) :
     * - Attribut/méthode static : partagé(e) par toutes les instances (un seul emplacement mémoire par classe).
     * - Attribut/méthode d'instance : propre à chaque objet créé.
     */
    static void afficherEtatPile(MaClassePile pile) {
        System.out.println("Taille : " + pile.getTaille());
        System.out.println("Vide : " + pile.estVide());
        System.out.println("Pleine : " + pile.estPleine());
    }

    /**
     * Affiche le contenu de la pile.
     * @param pile la pile à afficher
     * @param afficherInterne si true, affiche aussi le tableau interne (débogage)
     */
    static void afficherContenuPile(MaClassePile pile, boolean afficherInterne) {
        // Affichage via les getters (recommandé)
        System.out.println("* Contenu via getters :");
        for (int i = 0; i < pile.getTaille(); i++) {
            System.out.printf("  Case %d : %d%n", i, pile.getTableau()[i]);
        }

        // Affichage via le tableau interne (option de débogage, moins "propre")
        if (afficherInterne) {
            System.out.println("* Contenu via tableau interne (debug) :");
            for (int i = 0; i < pile.tableau.length; i++) {
                System.out.printf("     Case %d : %d%n", i, pile.tableau[i]);
            }
        }
        System.out.println();
    }
}
