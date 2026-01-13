package Devoirs.Devoir_05_cours;

import Devoirs.Devoir_05_cours.Structure.FilePile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class FileAvecRotationTest{
    FileAvecRotation file;// = new File(10);

    @BeforeEach
    void setUp() {
        file = new FileAvecRotation(10);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Est-ce que j'ai bien autant d'éléments que j'en ai ajouté")
    void testPush() {
        file.push(1);
        file.push(2);
        assertEquals(2, file.size(), "Il devrait y avoir 2 éléments dans la file");
    }

    @Test
    void testClear() {
        file.push(1);
        file.push(2);
        file.clear();
        assertEquals(0, file.size());
    }

    @Test
    void testSize() {
        assertEquals(0, file.size());
        file.push(1);
        assertEquals(1, file.size());
        file.push(2);
        assertEquals(2, file.size());
        file.pop();
        assertEquals(1, file.size());
        file.pop();
        assertEquals(0, file.size());
    }

    @Test
    void testEstVide() {
        assertTrue(file.estVide());
        file.push(1);
        assertFalse(file.estVide());
        file.pop();
        assertTrue(file.estVide());
    }

    @Test
    void testEstPleine() {
        for (int i = 0; i < 10; i++) {
            assertFalse(file.estPleine());
            file.push(i);
        }
        assertTrue(file.estPleine());
    }

    @Test
    void testToString() {
        assertEquals("[]", file.toString());
        file.push(1);
        assertEquals("[1]", file.toString());
        file.push(2);
        assertEquals("[1, 2]", file.toString());
        file.pop();
        assertEquals("[2]", file.toString());
        file.pop();
        assertEquals("[]", file.toString());
    }

    @Test
    void testPopWhenEmpty() {
        assertTrue(file.estVide());
        assertEquals(OptionalInt.empty(), file.pop());
    }

    @Test
    void testPopWhenNotEmpty() {
        file.push(1);
        assertEquals(OptionalInt.of(1), file.pop());
    }
}