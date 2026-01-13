package Devoirs.Devoir_06_V1;

import Devoirs.Devoir_06_V1.Base.ListeElement;
import Devoirs.Devoir_06_V1.Base.StructureListe;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ListeTest {

    static Stream<Supplier<StructureListe<Integer>>> listes() {
        return Stream.of(
                ListeFile::new,
                ListePile::new
        );
    }

    // =========================   trouveDernier   ===========================
    @ParameterizedTest
    @MethodSource("listes")
    void testTrouveDernierInteger(Supplier<StructureListe<Integer>> factory) {
        var s = factory.get();
        s.push(1);
        ListeElement<Integer> premier = s.getHead();

        assertSame(premier, s.trouveDernier());

        s.push(2);
        ListeElement<Integer> second = premier.getSuivant();
        assertSame(second, s.trouveDernier());

        s.push(3);
        ListeElement<Integer> third = second.getSuivant();
        assertSame(third, s.trouveDernier());
        assertSame(third, s.trouveDernier());

        s.clear();
        var exception = assertThrows(IllegalArgumentException.class, s::trouveDernier);
        assertTrue(exception.getMessage().contains("Liste vide"));
    }

    @ParameterizedTest
    @MethodSource("listes")
    void testTrouveDernierString(Supplier<StructureListe<String>> factory) {
        var s = factory.get();
        s.push("un");
        ListeElement<String> premier = s.getHead();

        assertSame(premier, s.trouveDernier());

        s.push("deux");
        ListeElement<String> second = premier.getSuivant();
        assertSame(second, s.trouveDernier());

        s.push("trois");
        ListeElement<String> third = second.getSuivant();
        assertSame(third, s.trouveDernier());
        assertSame(third, s.trouveDernier());

        s.clear();
        var exception = assertThrows(IllegalArgumentException.class, s::trouveDernier);
        assertTrue(exception.getMessage().contains("Liste vide"));
    }

    // ========================   trouveLeReferent   ==========================
    @ParameterizedTest
    @MethodSource("listes")
    void testTrouveLeReferentInteger(Supplier<StructureListe<Integer>> factory) {
        var s = factory.get();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        ListeElement<Integer> head = s.getHead();
        ListeElement<Integer> second = head.getSuivant();
        ListeElement<Integer> third = second.getSuivant();
        ListeElement<Integer> fourth = third.getSuivant();

        // Le référent du 2e élément est le head
        assertSame(head, s.trouveLeReferent(second));

        // Le référent du 3e élément est le 2e
        assertSame(second, s.trouveLeReferent(third));

        // Le référent du 4e élément est le 3e
        assertSame(third, s.trouveLeReferent(fourth));
    }

    @ParameterizedTest
    @MethodSource("listes")
    void testTrouveLeReferentString(Supplier<StructureListe<String>> factory) {
        var s = factory.get();
        s.push("un");
        s.push("deux");
        s.push("trois");
        s.push("quatre");

        ListeElement<String> head = s.getHead();
        ListeElement<String> second = head.getSuivant();
        ListeElement<String> third = second.getSuivant();
        ListeElement<String> fourth = third.getSuivant();

        // Le référent du 2e élément est le head
        assertSame(head, s.trouveLeReferent(second));

        // Le référent du 3e élément est le 2e
        assertSame(second, s.trouveLeReferent(third));

        // Le référent du 4e élément est le 3e
        assertSame(third, s.trouveLeReferent(fourth));
    }

    // ========================   setHead / avanceHead   ==========================
    @ParameterizedTest
    @MethodSource("listes")
    void testGetHeadAvanceHead(Supplier<StructureListe<Integer>> factory) {
        var s = factory.get();
        s.push(1);
        s.push(2);
        s.push(3);

        assertEquals(1, s.getHead().getInfo());
        s.avanceHead();
        assertEquals(2, s.getHead().getInfo());
        s.avanceHead();
        assertEquals(3, s.getHead().getInfo());

    }
}

