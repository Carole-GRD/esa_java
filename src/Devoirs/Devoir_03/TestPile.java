package Devoirs.Devoir_03;

/**
 * TestPile — petit programme de test manuel pour MaClassePile.
 * Objet : empiler/dépiler quelques valeurs et afficher l’état de la pile après chaque opération.
 * Affichage :
 *   - vue “éléments” (ce qui est vraiment dans la pile),
 *   - vue “cases” (toutes les cases du tableau).
 * Auteur : Carole Gérard
 * Date : 13/10/2025
 * IA : aide uniquement pour les commentaires
 */
public class TestPile {

    public static void main(String[] args) {

        MaClassePile pile = new MaClassePile();

        afficherPile(pile);

        // ----- Opération 1 : empiler 10 -----
        pile.empiler(10);
        afficherPile(pile);

        // ----- Opération 2 : empiler 20 -----
        pile.empiler(20);
        afficherPile(pile);

        // ----- Opération 3 : empiler 30 -----
        pile.empiler(30);
        afficherPile(pile);

        // ----- Opération 4 : empiler 40 -----
        pile.empiler(40);
        afficherPile(pile);

        // ----- Opération 5 : empiler 50 -----
        pile.empiler(50);
        afficherPile(pile);

        // ----- Opération 6 : empiler 60 -----
        pile.empiler(60);
        afficherPile(pile);

        // ----- Opération 7 : empiler 70 -----
        pile.empiler(70);
        afficherPile(pile);

        // ----- Opération 8 : empiler 80 -----
        pile.empiler(80);
        afficherPile(pile);

        // ----- Dépiler -----
        System.out.println("=============================");
        System.out.println(pile.depiler());  // dépiler 80
        System.out.println(pile.depiler());  // dépiler 70
        System.out.println(pile.depiler());  // dépiler 60
        System.out.println(pile.depiler());  // dépiler 50
        afficherPile(pile);

        System.out.println("=============================");
        System.out.println(pile.depiler());  // dépiler 40 (nbr d'éléments < tableau/2 => tableau - 1/4)
        afficherPile(pile);

        System.out.println("=============================");
        System.out.println(pile.depiler());  // dépiler 30 (nbr d'éléments < tableau/2 => tableau - 1/4)
        afficherPile(pile);

        System.out.println("=============================");
        System.out.println(pile.depiler());  // dépiler 20 (nbr d'éléments < tableau/2 => tableau - 1/4)
        afficherPile(pile);

        System.out.println("=============================");
        System.out.println(pile.depiler());  // dépiler 10 (nbr d'éléments < tableau/2 => tableau - 1/4)
        afficherPile(pile);

        System.out.println("=============================");
        System.out.println(pile.depiler());  // dépiler mais pile vide !
        afficherPile(pile);

    }


    /**
     * Affiche l'état et les éléments de la pile, ainsi que les cases du tableau.
     * @param pile la pile à afficher
     */
    static void afficherPile(MaClassePile pile) {

        // Affiche l'état de la pile
        System.out.println(" * État de la pile");
        System.out.println("    - Vide : " + pile.estVide());
        System.out.println("    - Pleine : " + pile.estPleine());

        // Affichage via les getters (recommandé)
        System.out.println(" * Éléments de la pile (taille logique = " + pile.getTaille() + ") :");
        for (int i = 0; i < pile.getTaille(); i++) {
            System.out.printf("      Elément %d : %d%n", i, pile.tableau[i]);
        }

        // Affichage via le tableau interne (option de débogage, moins "propre")
        System.out.println(" * Toutes les cases du tableau (capacité = " + pile.tableau.length + ") :");
        for (int i = 0; i < pile.tableau.length; i++) {
            System.out.printf("         Case %d : %d%n", i, pile.tableau[i]);
        }

        System.out.println();
    }
}
