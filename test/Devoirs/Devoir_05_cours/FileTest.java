package Devoirs.Devoir_05_cours;

// https://junit.org/
// https://docs.junit.org/current/user-guide/
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    //final File file = new File(10);
    File file;

    //@BeforeAll
    @BeforeEach
    void setUp() {
        file = new File(10);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Nom de mon test push")
    void testPush() {
        //var file = new File(10);
        assertTrue(file.estVide());
        file.push(1);
        assertFalse(file.estVide());
        file.push(2);
        assertEquals(2, file.size(), "Il davrait y avoir deux éléments dans la file !");
    }

    @Test
    void testClear() {
        assertEquals(0, file.size());
        file.clear();
        assertEquals(0, file.size());
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
        file.push(3);
        assertEquals(3, file.size());
        file.pop();
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
        assertFalse(file.estPleine());
        for (int i = 1; i <= 10; i++) {
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
    void testPop() {
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