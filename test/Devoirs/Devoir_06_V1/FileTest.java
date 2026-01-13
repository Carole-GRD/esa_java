package Devoirs.Devoir_06_V1;

import Devoirs.Devoir_06_V1.Interfaces.IFilePile;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    static Stream<Supplier<? extends IFilePile<Integer>>> files() {
        return Stream.of(
                ListeFile::new,
                TableauFile::new
        );
    }

    @ParameterizedTest
    @MethodSource("files")
    void testPopFIFO(Supplier<? extends IFilePile<Integer>> factory) {
        var f = factory.get();
        f.push(4);
        assertEquals(4, f.pop().orElseThrow());
        assertTrue(f.pop().isEmpty());

        f.push(1);
        f.push(2);
        f.push(3);
        assertEquals(1, f.pop().orElseThrow());
        assertEquals(2, f.pop().orElseThrow());
        assertEquals(3, f.pop().orElseThrow());
        assertTrue(f.pop().isEmpty());
    }


    @ParameterizedTest
    @MethodSource("files")
    void testRetrecissementConserveOrdre() {
        TableauFile<Integer> tabFile = new TableauFile<>();

        assertEquals(4, tabFile.getTableau().length);

        for (int i = 1; i <= 14; i++) tabFile.push(i);
        assertEquals(16, tabFile.getTableau().length);

        // pop 1..6 -> reste 7..14 (8 éléments) => pas de shrink
        for (int i = 1; i <= 6; i++) {
            assertEquals(Optional.of(i), tabFile.pop());
        }
        assertEquals(16, tabFile.getTableau().length);

        // pop 7 -> reste 7 éléments (7 < 16/2) => shrink 16 -> 12
        assertEquals(Optional.of(7), tabFile.pop());
        assertEquals(12, tabFile.getTableau().length);

        // pop 8 -> reste 6 éléments => pas de shrink (seuil < 6)
        assertEquals(Optional.of(8), tabFile.pop());
        assertEquals(12, tabFile.getTableau().length);

        // pop 9 -> reste 5 éléments (5 < 9/2) => shrink 12 -> 9
        assertEquals(Optional.of(9), tabFile.pop());
        assertEquals(9, tabFile.getTableau().length);

        // Et on vérifie que le reste sort encore dans le bon ordre
        for (int i = 10; i <= 14; i++) {
            assertEquals(Optional.of(i), tabFile.pop());
        }
        assertTrue(tabFile.pop().isEmpty());
    }
}




