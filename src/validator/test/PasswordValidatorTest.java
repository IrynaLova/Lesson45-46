package validator.test;

import org.junit.jupiter.api.Test;
import validator.util.PasswordValidator;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    @Test
    void testValidPassword(){
        assertTrue(PasswordValidator.isStrong("Qwerty0!"));
        assertTrue(PasswordValidator.isStrong("Qwerty0?"));
        assertTrue(PasswordValidator.isStrong("Qwerty0@"));
        assertTrue(PasswordValidator.isStrong("Qwerty0#"));
    }
    @Test
    void testSymbolsLessThan8(){
        assertFalse(PasswordValidator.isStrong("Qwert0!"));
        assertFalse(PasswordValidator.isStrong("Qwerty0?"));

    }

    @Test
    void testInvalidSpecSymbols(){
        assertFalse(PasswordValidator.isStrong("Qwerty0 "));
        assertFalse(PasswordValidator.isStrong("Qwe^ty0"));
        assertFalse(PasswordValidator.isStrong("~Qwerty0"));

    }

    @Test
    void testNotUpperCase(){
        assertFalse(PasswordValidator.isStrong("qwerty2!"));
    }
}
