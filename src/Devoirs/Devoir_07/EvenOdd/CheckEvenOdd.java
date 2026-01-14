package Devoirs.Devoir_07.EvenOdd;

import Devoirs.Devoir_07.Interfaces.IMsgPrinter;
import Devoirs.Devoir_07.Interfaces.IValidator;

public class CheckEvenOdd {

    private final IValidator<Integer> isEven = n -> n % 2 == 0;

    // Facile à tester : renvoie le texte à afficher
    public String format(int n) {
        return n + " -> " + (isEven.test(n) ? "pair" : "impair");
    }

    // Pour afficher une liste de nombres (testable aussi avec un faux printer)
    public void printAll(int[] numbers, IMsgPrinter<String> msg) {
        for (int n : numbers) {
            msg.print(format(n));
        }
    }
}
