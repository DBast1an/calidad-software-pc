package com.mycompany.calidad_software_pc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class EmailValidatorTest {

    private EmailValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new EmailValidator();
    }

    @Test
    public void testCorreoNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validator.isValidEmail(null);
        });
        assertEquals("El correo no puede ser nulo o vacío", exception.getMessage());
    }

    @Test
    public void testCorreoSinArroba() {
        assertFalse(validator.isValidEmail("usuario.gmail.com"));
    }

    @Test
    public void testCorreoDominioInvalido() {
        assertFalse(validator.isValidEmail("usuario@com"));
    }

    @Test
    public void testCorreoFormatoValido() {
        assertTrue(validator.isValidEmail("cliente123@tienda.com"));
    }

    @Test
    public void testCorreoPuntosConsecutivos() {
        assertFalse(validator.isValidEmail("usuario..nombre@gmail.com"));
    }

    @Test
    public void testValidacionesMultiples() {
        assertAll(
                () -> assertTrue(validator.isValidEmail("test@example.org")),
                () -> assertFalse(validator.isValidEmail(".inicio@dominio.pe")),
                () -> assertEquals(false, validator.isValidEmail("correo con espacio@test.com"))
        );
    }
}
