package Devoirs.Devoir_07.EvenOdd;

import Devoirs.Devoir_07.Interfaces.IMsgPrinter;
import Devoirs.Devoir_07.Interfaces.IValidator;

import java.util.Random;

public class TestEvenOdd {
    public static void main(String[] args) {

        final int SIZE = 50;
        int[] numbers = new int[SIZE];

        Random random = new Random();

        // Remplir le tableau avec des nombres aléatoires (ex: 0 à 99)
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

//        ====================================================================
//        SANS la Classe CheckEvenOdd
//
//        IValidator<Integer> isEven = n -> n % 2 == 0;
//
//        // Interface fonctionnelle + lambda pour afficher "n -> pair/impair"
//        IMsgPrinter msg = n -> {
//            String type = isEven.test((int) n) ? "pair" : "impair";
//            System.out.println(n + " -> " + type);
//        };
//
//        // Parcourir le tableau et afficher
//        for (int n : numbers) {
//            msg.print(n);
//        }
//        ====================================================================

//      AVEC la Classe CheckEvenOdd
        CheckEvenOdd checkEvenOdd = new CheckEvenOdd();
        IMsgPrinter<String> msgToPrint = System.out::println;

        checkEvenOdd.printAll(numbers, msgToPrint);

    }
}
