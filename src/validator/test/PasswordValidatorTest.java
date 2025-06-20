package validator.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import validator.util.PasswordValidator;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    static PasswordValidator validator;

    @BeforeAll
    static void setUpAll() {
        validator = new PasswordValidator();
    }

    @Test
    void testValidPassword(){
        assertTrue(validator.isStrong("Qwerty0!"));
        assertTrue(validator.isStrong("Qwerty0?"));
        assertTrue(validator.isStrong("Qwerty0@"));
        assertTrue(validator.isStrong("Qwerty0#"));
    }

    @Test
    void testSymbolsLessThan8(){
        assertFalse(validator.isStrong("Qwert0!"));
        assertFalse(validator.isStrong("Qwerty0?"));

    }

    @Test
    void testInvalidSpecSymbols(){
        assertFalse(validator.isStrong("Qwerty0 "));
        assertFalse(validator.isStrong("Qwe^ty0"));
        assertFalse(validator.isStrong("~Qwerty0"));
    }

    @Test
    void testNotUpperCase(){
        assertFalse(validator.isStrong("qwerty2!"));
    }
    @Test
    void testNoLowerCase(){
        assertFalse(validator.isStrong("QWERTY2!"));
    }
    @Test
    void testNotDigit(){
        assertFalse(validator.isStrong("Qwerty!!"));
    }
    @Test
    void testNull() {
        assertFalse(validator.isStrong(null));
    }
}
