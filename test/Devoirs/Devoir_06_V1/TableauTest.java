package Devoirs.Devoir_06_V1;

import Devoirs.Devoir_06_V1.Base.StructureTableau;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TableauTest {

    static Stream<Supplier<StructureTableau<Integer>> > tableaux() {
        return Stream.of(
                TableauFile::new,
                TableauPile::new
        );
    }

    // =========================   estPleine   ===========================
    @ParameterizedTest
    @MethodSource("tableaux")
    void testEstPleine(Supplier<StructureTableau<Integer>> factory) {
        var s = factory.get();
        assertFalse(s.estPleine());  // vide        => 4 cases

        s.push(1);
        assertFalse(s.estPleine());  // 1           => 4 cases
        s.push(2);
        assertFalse(s.estPleine());  // 1, 2        => 4 cases
        s.push(3);
        assertFalse(s.estPleine());  // 1, 2, 3     => 4 cases

        s.push(4);
        assertTrue(s.estPleine());   // 1, 2, 3, 4  => 4 cases

        s.push(5);
        assertFalse(s.estPleine());  // 1, 2, 3, 4, 5  => 8 cases

        s.pop();
        assertFalse(s.estPleine());  // 1, 2, 3, 4     => 8 cases

        s.pop();
        assertFalse(s.estPleine());  // 1, 2, 3        => 8 cases
        s.pop();
        assertFalse(s.estPleine());  // 1, 2           => 8 cases
        s.pop();
        assertFalse(s.estPleine());  // 1              => 4 cases
        s.pop();
        assertFalse(s.estPleine());  // vide           => 4 cases
        s.pop();
        assertFalse(s.estPleine());  // vide           => 4 cases

        for (int i = 0; i < 40; i++) {
            s.push(i);
        }
        assertTrue(s.estPleine());  // plein    => 40 cases
    }

    // =================   agrandir taille du tableau   ===================
    @ParameterizedTest
    @MethodSource("tableaux")
    void testAgrandirTableau(Supplier<StructureTableau<Integer>> factory) {
        var s = factory.get();
        assertEquals(4, s.getTableau().length);

        for (int i = 1; i <= 4; i++) {
            s.push(i*10);
        }
        assertEquals(4, s.getTableau().length);

        s.push(50);
        assertEquals(8, s.getTableau().length);

        for (int i = 6; i <=8; i++) {
            s.push(i*10);
        }
        assertEquals(8, s.getTableau().length);

        s.pop();
        assertEquals(8, s.getTableau().length);

        s.push(80);
        assertEquals(8, s.getTableau().length);

        s.push(90);
        assertEquals(12, s.getTableau().length);
    }


    // ==============   réduire de la taille du tableau   ================
    @ParameterizedTest
    @MethodSource("tableaux")
    void testReduireTableau(Supplier<StructureTableau<Integer>> factory) {
        var s = factory.get();
        // Remplir
        for (int i = 0; i < 100; i++) s.push(i);
        assertEquals(100, s.getTableau().length);
        assertEquals(100, s.size());

        // Vider en partie -> déclenche plusieurs rétrécissement du tableau
        for (int i = 0; i < 80; i++) s.pop().orElseThrow();
        assertEquals(32, s.getTableau().length);
        assertEquals(20, s.size());

        // Le reste doit être correct
        // Vider complètement -> déclenche à nouveau plusieurs rétr&cissement du tableau
        for (int i = 80; i < 95; i++) s.pop().orElseThrow();
        assertEquals(8, s.getTableau().length);
        assertEquals(5, s.size());

        for (int i = 95; i < 97; i++) s.pop().orElseThrow();
        assertEquals(6, s.getTableau().length);
        assertEquals(3, s.size());

        s.pop();
        assertEquals(5, s.getTableau().length);
        assertEquals(2, s.size());
        s.pop();
        assertEquals(4, s.getTableau().length);
        assertEquals(1, s.size());
        s.pop();
        assertEquals(4, s.getTableau().length);
        assertEquals(0, s.size());
        assertTrue(s.pop().isEmpty());
    }
}


