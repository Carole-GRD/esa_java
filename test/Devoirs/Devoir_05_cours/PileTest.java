package Devoirs.Devoir_05_cours;

import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.OptionalInt;

class PileTest {
    Pile pile;

    @BeforeEach
    void setUp() {
        pile = new Pile(10);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Est-ce que j'ai bien autant d'éléments que j'en ai ajouté")
    void testPush() {
        pile.push(1);
        pile.push(2);
        assertEquals(2, pile.size(), "Il devrait y avoir 2 éléments dans la file");
    }

    @Test
    void testClear() {
        pile.push(1);
        pile.push(2);
        pile.clear();
        assertEquals(0, pile.size());
    }

    @Test
    void testSize() {
        assertEquals(0, pile.size());
        pile.push(1);
        assertEquals(1, pile.size());
        pile.push(2);
        assertEquals(2, pile.size());
        pile.pop();
        assertEquals(1, pile.size());
        pile.pop();
        assertEquals(0, pile.size());
    }

    @Test
    void testEstVide() {
        assertTrue(pile.estVide());
        pile.push(1);
        assertFalse(pile.estVide());
        pile.pop();
        assertTrue(pile.estVide());
    }

    @Test
    void testEstPleine() {
        for (int i = 0; i < 10; i++) {
            assertFalse(pile.estPleine());
            pile.push(i);
        }
        assertTrue(pile.estPleine());
    }

    @Test
    void testToString() {
        assertEquals("[]", pile.toString());
        pile.push(1);
        assertEquals("[1]", pile.toString());
        pile.push(2);
        assertEquals("[1, 2]", pile.toString());
        pile.pop();
        assertEquals("[1]", pile.toString());
        pile.pop();
        assertEquals("[]", pile.toString());
        pile.push(1);
    }

    @Test
    void testPopWhenEmpty() {
        assertTrue(pile.estVide());
        assertEquals(OptionalInt.empty(), pile.pop());
    }

    @Test
    void testPopWhenNotEmpty() {
        pile.push(1);
        assertEquals(OptionalInt.of(1), pile.pop());
    }
}