package Devoirs.Devoir_07.EvenOdd;

import Devoirs.Devoir_07.Interfaces.IMsgPrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckEvenOddTest {
    private final CheckEvenOdd checkEvenOdd = new CheckEvenOdd();

    @Test
    void testFormatEven() {
        assertEquals("12 -> pair", checkEvenOdd.format(12));
        assertEquals("0 -> pair", checkEvenOdd.format(0));
    }

    @Test
    void testFormatOdd() {
        assertEquals("21 -> impair", checkEvenOdd.format(21));
        assertEquals("-3 -> impair", checkEvenOdd.format(-3));
    }

    @Test
    void testPrintAll() {
        // Tableau de test (on évite Random pour que le test soit toujours identique)
        int[] numbers = {12, 21, 0};

        // StringBuilder = "boîte" dans laquelle on va accumuler du texte
        // (au lieu d'afficher sur la console)
        StringBuilder sb = new StringBuilder();

        // On crée un "msgToPrint" (comme System.out.println) mais au lieu d'imprimer,
        // il ajoute le message dans sb + un retour à la ligne
        // msg -> ... : msg est le paramètre (le texte à imprimer)
        IMsgPrinter<String> msgToPrint = msg -> sb.append(msg).append(System.lineSeparator());

        // On appelle la méthode à tester : elle va parcourir numbers
        // et pour chaque nombre elle appelle msgToPrint.print(...)
        // Donc sb va recevoir toutes les lignes dans l'ordre
        checkEvenOdd.printAll(numbers, msgToPrint);

        // On récupère le séparateur de ligne du système (\n sur Linux/Mac, \r\n sur Windows)
        String ls = System.lineSeparator();

        // On construit le texte attendu EXACTEMENT comme on pense que printAll doit l'écrire
        String expected =
                "12 -> pair" + ls +
                "21 -> impair" + ls +
                "0 -> pair" + ls;

        // sb.toString() = tout ce qui a été "imprimé" dans sb
        // On vérifie que le texte obtenu est égal au texte attendu (et dans le bon ordre)
        assertEquals(expected, sb.toString());
    }
}
