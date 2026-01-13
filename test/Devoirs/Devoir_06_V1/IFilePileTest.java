package Devoirs.Devoir_06_V1;

import Devoirs.Devoir_06_V1.Interfaces.IFilePile;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Supplier;
import java.util.stream.Stream;

class IFilePileTest {

    static Stream<Supplier<? extends IFilePile<Integer>>> implementations() {
        return Stream.of(
                ListeFile::new,
                ListePile::new,
                TableauFile::new,
                TableauPile::new
        );
    }

    // ===========================   PUSH   =============================
    @ParameterizedTest
    @MethodSource("implementations")
    void testPushInteger(Supplier<? extends IFilePile<Integer>> factory) {
        var s = factory.get();
        assertEquals(0, s.size());
        for (int i = 1; i <= 10; i++) {
            s.push(i);
            assertEquals(i, s.size());
        }
        assertEquals(10, s.size());
    }

    @ParameterizedTest
    @MethodSource("implementations")
    void testPushString(Supplier<? extends IFilePile<String>> factory) {
        var s = factory.get();
        assertEquals(0, s.size());
        s.push("rouge");
        assertEquals(1, s.size());
        s.push("vert");
        assertEquals(2, s.size());
        s.push("bleu");
        assertEquals(3, s.size());
    }

    // ===========================   SIZE   ============================
    @ParameterizedTest
    @MethodSource("implementations")
    void testSizeInteger(Supplier<? extends IFilePile<Integer>> factory) {
        var s = factory.get();

        // initial
        assertEquals(0, s.size());

        // push
        s.push(10);
        assertEquals(1, s.size());
        s.push(20);
        assertEquals(2, s.size());
        s.push(30);
        assertEquals(3, s.size());

        // pop (peu importe l’ordre, juste la taille)
        assertTrue(s.pop().isPresent());
        assertEquals(2, s.size());
        assertTrue(s.pop().isPresent());
        assertEquals(1, s.size());
        assertTrue(s.pop().isPresent());
        assertEquals(0, s.size());
        assertFalse(s.pop().isPresent());

        // clear
        s.push(40);
        s.push(50);
        s.push(60);
        s.push(70);
        assertEquals(4, s.size());
        s.clear();
        assertEquals(0, s.size());

        // pop sur vide ne change pas size
        assertTrue(s.pop().isEmpty());
        assertEquals(0, s.size());

        // push null ne change pas la taille
        s.push(null);
        assertEquals(0, s.size());
    }

    @ParameterizedTest
    @MethodSource("implementations")
    void testSizeString(Supplier<? extends IFilePile<String>> factory) {
        var s = factory.get();

        // initial
        assertEquals(0, s.size());

        // push
        s.push("rouge");
        assertEquals(1, s.size());
        s.push("vert");
        assertEquals(2, s.size());
        s.push("bleu");
        assertEquals(3, s.size());

        // pop (peu importe l’ordre, juste la taille)
        assertTrue(s.pop().isPresent());
        assertEquals(2, s.size());
        assertTrue(s.pop().isPresent());
        assertEquals(1, s.size());
        assertTrue(s.pop().isPresent());
        assertEquals(0, s.size());
        assertFalse(s.pop().isPresent());

        // clear
        s.push("poisson");
        s.push("riz");
        s.push("légumes");
        s.push("sauce");
        assertEquals(4, s.size());
        s.clear();
        assertEquals(0, s.size());

        // pop sur vide ne change pas size
        assertTrue(s.pop().isEmpty());
        assertEquals(0, s.size());

        // push null ne change pas la taille
        s.push(null);
        assertEquals(0, s.size());
    }

    // ==========================   CLEAR   ============================
    @ParameterizedTest
    @MethodSource("implementations")
    void testClearInteger(Supplier<? extends IFilePile<Integer>> factory) {
        var s = factory.get();
        assertEquals(0, s.size());
        s.push(14);
        s.push(15);
        assertEquals(2, s.size());

        s.clear();
        assertEquals(0, s.size());
        assertTrue(s.pop().isEmpty());
    }

    @ParameterizedTest
    @MethodSource("implementations")
    void testClearString(Supplier<? extends IFilePile<String>> factory) {
        var s = factory.get();
        assertEquals(0, s.size());
        s.push("PHP");
        s.push("Java");
        s.push("C#");
        assertEquals(3, s.size());

        s.clear();
        assertEquals(0, s.size());
        assertTrue(s.pop().isEmpty());
    }

    // =========================   toString   ==========================
    @ParameterizedTest
    @MethodSource("implementations")
    void testToStringInteger(Supplier<? extends IFilePile<Integer>> factory) {
        var s = factory.get();
        s.push(10);
        s.push(250);
        s.push(54);
        assertEquals("[10, 250, 54]", s.toString());
        s.clear();
        assertEquals("[]", s.toString());
    }

    @ParameterizedTest
    @MethodSource("implementations")
    void testToStringString(Supplier<? extends IFilePile<String>> factory) {
        var s = factory.get();
        s.push("Tesla");
        s.push("Ford");
        assertEquals("[Tesla, Ford]", s.toString());
        s.clear();
        assertEquals("[]", s.toString());
    }


    // =========================   estVide   ==========================
    @ParameterizedTest
    @MethodSource("implementations")
    void testEstVideInteger(Supplier<IFilePile<Integer>> factory) {
        var s = factory.get();
        assertTrue(s.estVide());
        s.push(null);
        assertTrue(s.estVide());
        s.push(100);
        s.push(200);
        assertFalse(s.estVide());
        s.pop();
        assertFalse(s.estVide());
        s.pop();
        assertTrue(s.estVide());
    }

    @ParameterizedTest
    @MethodSource("implementations")
    void testEstVideString(Supplier<IFilePile<String>> factory) {
        var s = factory.get();
        assertTrue(s.estVide());
        s.push(null);
        assertTrue(s.estVide());
        s.push("orange");
        s.push("vert");
        assertFalse(s.estVide());
        s.pop();
        assertFalse(s.estVide());
        s.pop();
        assertTrue(s.estVide());
    }

}