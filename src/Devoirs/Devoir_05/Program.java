package Devoirs.Devoir_05;

import java.util.OptionalInt;


public class Program {
    public static void main(String[] args) {
        //FilePile fp = new FilePile();  // ne peut pas être instancié car c'est une classe abstraite

        //testPile();
        //testFile();
        testFileAvecRotation();
    }

    private static void testPile() {
        System.out.println("=== TESTS PILE (LIFO) ===");

        Pile pile = new Pile(3);

        System.out.println("Pop sur pile vide (attendu: vide)");
        pile.pop();
        System.out.println(pile);

        System.out.println("➡️ Empile 10, 20, 30 (push)");
        pile.push(10);
        pile.push(20);
        pile.push(30);
        System.out.println(pile);

        System.out.println("➡️ Dépile un élément (pop)");
        OptionalInt val = pile.pop();
        System.out.println("Valeur dépilée : " + val.orElse(-1));
        System.out.println(pile);

        System.out.println("➡️ Empile 40");
        pile.push(40);
        System.out.println(pile);

        System.out.println("Empile 50 (déclenche agrandissement car plein)");
        pile.push(50);
        System.out.println(pile);

        System.out.println("➡️ Vide la pile (clear)");
        pile.clear();
        System.out.println(pile);

        System.out.println("➡️ Empile 60, 70, 80, 90 (agrandissement)");
        pile.push(60);
        pile.push(70);
        pile.push(80);
        pile.push(90);
        System.out.println(pile);

        System.out.println("➡️ Dépile un élément (pop)");
        OptionalInt val1 = pile.pop();
        System.out.println("Valeur dépilée : " + val1.orElse(-1));
        System.out.println(pile);

        System.out.println("➡️ Dépile un élément (réduit la longueur du tableau de 3/4)");
        OptionalInt val2 = pile.pop();
        System.out.println("Valeur dépilée : " + val2.orElse(-1));
        System.out.println(pile);
    }

    private static void testFile() {
        System.out.println("\n=== TESTS FILE (FIFO) ===");

        File file = new File(3);

        System.out.println("Pop sur file vide (attendu: vide)");
        OptionalInt val = file.pop();
        System.out.println("Valeur retirée : " + val.orElse(-1));

        System.out.println("➡️ Enfile 10, 20, 30");
        file.push(10);
        file.push(20);
        file.push(30);
        System.out.println(file);

        System.out.println("➡️ Défile un élément");
        OptionalInt val0 = file.pop();
        System.out.println("Valeur retirée : " + val0.orElse(-1));
        System.out.println(file);

        System.out.println("➡️ Enfile 40 (déclanche le décalage vers la gauche)");
        file.push(40);
        System.out.println(file);

        System.out.println("➡️ Enfile 50 (déclenche agrandissement car plein)");
        file.push(50);
        System.out.println(file);

        System.out.println("➡️ Défile deux fois (réduit la longueur du tableau de 3/4)");
        OptionalInt val1 = file.pop();
        System.out.println("Valeur défilée : " + val1.orElse(-1));
        OptionalInt val2 = file.pop();
        System.out.println("Valeur défilée : " + val2.orElse(-1));
        System.out.println(file);

        System.out.println("➡️ Vide la file (clear)");
        file.clear();
        System.out.println(file);
    }

    private static void testFileAvecRotation() {
        System.out.println("\n=== TESTS FILE AVEC ROTATION (FIFO circulaire) ===");

        FileAvecRotation fileR = new FileAvecRotation(3);

        System.out.println("Pop sur file vide (attendu: vide)");
        OptionalInt val = fileR.pop();
        System.out.println("Valeur retirée : " + val.orElse(-1));

        System.out.println("➡️ Enfile 10, 20, 30");
        fileR.push(10);
        fileR.push(20);
        fileR.push(30);
        System.out.println(fileR);

        System.out.println("➡️ Défile un élément (libère une case au début)");
        OptionalInt val0= fileR.pop();
        System.out.println("Valeur retirée : " + val0.orElse(-1));
        System.out.println(fileR);

        System.out.println("➡️ Enfile 40 (doit aller en début du tableau grâce à la rotation)");
        fileR.push(40);
        System.out.println(fileR);

        System.out.println("➡️ Enfile à nouveau 50 (réorganise et agrandit le tableau)");
        fileR.push(50);
        System.out.println(fileR);

        System.out.println("➡️ Défile deux fois (réduit la longueur du tableau de 3/4)");
        OptionalInt val1 = fileR.pop();
        System.out.println("Valeur défilée : " + val1.orElse(-1));
        OptionalInt val2 = fileR.pop();
        System.out.println("Valeur défilée : " + val2.orElse(-1));
        System.out.println(fileR);

        System.out.println("➡️ Enfile 60, 70, 80, 90, 100");
        fileR.push(60);
        System.out.println(fileR);
        fileR.push(70);
        System.out.println(fileR);
        fileR.push(80);
        fileR.push(90);
        fileR.push(100);
        System.out.println(fileR);

        System.out.println("➡️ Vide la file avec rotation (clear)");
        fileR.clear();
        System.out.println(fileR);

    }
}