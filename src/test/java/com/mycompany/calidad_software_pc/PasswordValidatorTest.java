package com.mycompany.calidad_software_pc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    public void testPasswordMenorOchoCaracteres() {
        assertFalse(PasswordValidator.isValid("Abc1!"));
    }

    @Test
    public void testPasswordNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            PasswordValidator.isValid(null);
        });
    }

    @Test
    public void testPasswordValidaCompleta() {
        assertTrue(PasswordValidator.isValid("MyPass123@"));
    }

    @Test
    public void testPasswordConEspacioInicio() {
        assertFalse(PasswordValidator.isValid(" Secure99!"));
    }

    @Test
    public void testPasswordSinMayusculas() {
        assertEquals(false, PasswordValidator.isValid("password123!"));
    }

    @Test
    public void testPasswordMaximaLongitud() {
        assertAll(
                () -> assertTrue(PasswordValidator.isValid("ValidPass123!ValidPass123!ValidPass123!ValidPass123!ValidPass12")),
                () -> assertFalse(PasswordValidator.isValid("abc"))
        );
    }
}
