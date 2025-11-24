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
    
    // Para cubrir el fallo por longitud mínima (Línea 23)
@Test
public void testCorreoMenorDeMinLength() {
    // "a@b.c" tiene 5 caracteres, si el mínimo es 6, falla.
    assertFalse(validator.isValidEmail("a@b.c")); 
}

// Para cubrir el fallo por longitud máxima (Línea 23)
@Test
public void testCorreoExcedeMaxLength() {
    // Asumiendo un límite de 254/255
    String longEmail = "a".repeat(240) + "@b.com"; 
    assertFalse(validator.isValidEmail(longEmail + "x")); 
}

// Para cubrir el fallo por múltiples arrobas (Línea 32)
@Test
public void testCorreoMultipleArrobas() {
    assertFalse(validator.isValidEmail("user@domain@com")); 
}

// Para cubrir el fallo por dominio o subdominio de 1 carácter (Línea 51)
@Test
public void testCorreoDominioSubdominioUnCaracter() {
    assertFalse(validator.isValidEmail("test@a.co")); 
}
}
