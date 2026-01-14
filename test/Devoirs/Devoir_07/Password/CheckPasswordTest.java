package Devoirs.Devoir_07.Password;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckPasswordTest {

    private final CheckPassword ckPwd = new CheckPassword();

    @Test
    void testNull() {
        assertFalse(ckPwd.isValid(null));

        String[] errors = ckPwd.errors(null);
        assertEquals(1, errors.length);
        assertEquals("Ne peut pas être NULL", errors[0]);
    }

    @Test
    void testEmpty() {
        assertFalse(ckPwd.isValid(""));

        String[] errors = ckPwd.errors("");
        assertTrue(contains(errors, "Ne peut pas être vide ou blanc"));
    }

    @Test
    void testBlank() {
        assertFalse(ckPwd.isValid("   "));

        String[] errors = ckPwd.errors("   ");
        assertTrue(contains(errors, "Ne peut pas être vide ou blanc"));
    }

    @Test
    void testTooShort() {
        assertFalse(ckPwd.isValid("Abc!123"));

        String[] errors = ckPwd.errors("Abc!123");
        assertTrue(contains(errors, "Minimum 10 caractères"));
    }

    @Test
    void testMissingLowercase() {
        assertFalse(ckPwd.isValid("PASSWORD12!"));

        String[] errors = ckPwd.errors("PASSWORD12!");
        assertTrue(contains(errors, "Minimum 1 lettre minuscule"));
    }

    @Test
    void testMissingUppercase() {
        assertFalse(ckPwd.isValid("password12!"));

        String[] errors = ckPwd.errors("password12!");
        assertTrue(contains(errors, "Minimum 1 lettre majuscule"));
    }

    @Test
    void testMissingSpecial() {
        assertFalse(ckPwd.isValid("Password1234"));

        String[] errors = ckPwd.errors("Password1234");
        assertTrue(contains(errors, "Minimum 1 caractère spécial"));
    }

    @Test
    void testValid() {
        assertTrue(ckPwd.isValid("Password12!"));

        String[] errors = ckPwd.errors("Password12!");
        assertEquals(0, errors.length);
    }

    // petite fonction utilitaire pour les tests
    private boolean contains(String[] arr, String expectedPart) {
        for (String s : arr) {
            if (s != null && s.contains(expectedPart)) return true;
        }
        return false;
    }
}

/*
    Fonction utilitaire pour les tests :

    Fonction qui parcourt tous les messages du tableau.
    Retourne true dès qu'un message contient le texte recherché (expectedPart), sinon false.
    Utile car certains messages d'erreur sont plus longs, on vérifie juste un morceau de phrase.


    - "arr" = array -> le tableau de messages d'erreur (String[])
    - "expectedPart" = la partie de texte qu'on s'attend à retrouver dans un des messages

    On utilise contains(...) car certains messages sont plus longs (ex: "Minimum 1 caractère spécial parmi: ..."),
    donc on vérifie juste qu'un message contient le morceau recherché.
 */