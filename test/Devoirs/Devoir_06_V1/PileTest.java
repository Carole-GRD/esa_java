package Devoirs.Devoir_06_V1;

import Devoirs.Devoir_06_V1.Interfaces.IFilePile;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PileTest {

    static Stream<Supplier<? extends IFilePile<Integer>>> piles() {
        return Stream.of(
                ListePile::new,
                TableauPile::new
        );
    }

    @ParameterizedTest
    @MethodSource("piles")
    void testPopFIFO(Supplier<? extends IFilePile<Integer>> factory) {
        var p = factory.get();
        p.push(4);
        assertEquals(4, p.pop().orElseThrow());
        assertTrue(p.pop().isEmpty());

        p.push(1);
        p.push(2);
        p.push(3);
        assertEquals(3, p.pop().orElseThrow());
        assertEquals(2, p.pop().orElseThrow());
        assertEquals(1, p.pop().orElseThrow());
        assertTrue(p.pop().isEmpty());
    }

    @ParameterizedTest
    @MethodSource("piles")
    void testRetrecissementConserveOrdre() {
        TableauPile<Integer> tabPile = new TableauPile<>();

        assertEquals(4, tabPile.getTableau().length);

        for (int i = 1; i <= 14; i++) tabPile.push(i);
        assertEquals(16, tabPile.getTableau().length);

        // pop 14..9 -> reste 8..1 (8 éléments) => pas de shrink
        for (int i = 14; i >= 9; i--) {
            assertEquals(Optional.of(i), tabPile.pop());
        }
        assertEquals(16, tabPile.getTableau().length);

        // pop 8 -> reste 7 éléments (7 < 16/2) => shrink 16 -> 12
        assertEquals(Optional.of(8), tabPile.pop());
        assertEquals(12, tabPile.getTableau().length);

        // pop 7 -> reste 6 éléments => pas de shrink (seuil < 6)
        assertEquals(Optional.of(7), tabPile.pop());
        assertEquals(12, tabPile.getTableau().length);

        // pop 6 -> reste 5 éléments (5 < 9/2) => shrink 12 -> 9
        assertEquals(Optional.of(6), tabPile.pop());
        assertEquals(9, tabPile.getTableau().length);

        // Et on vérifie que le reste sort encore dans le bon ordre
        for (int i = 5; i >= 1; i--) {
            assertEquals(Optional.of(i), tabPile.pop());
        }
        assertTrue(tabPile.pop().isEmpty());
    }
}




