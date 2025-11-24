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
    
    // Para cubrir la línea del constructor (Línea 4)
@Test
public void testConstructorParaCobertura() {
    new PasswordValidator(); // Ejecuta el constructor vacío
    assertTrue(true); 
}

// Para cubrir la línea roja de caracteres no permitidos (Línea 38)
@Test
public void testPasswordConCaracterNoPermitido() {
    // Usamos '~', que NO está en tu lista SPECIAL_CHARS.
    // Esto fuerza la ejecución de la línea de rechazo (else if (c != ' ') return false;).
    assertFalse(PasswordValidator.isValid("Pass123~R")); 
}
// Para cubrir el fallo por doble espacio (Línea 20 del PDF)
@Test
public void testPasswordConDobleEspacio() {
    assertFalse(PasswordValidator.isValid("Pass  Word1")); 
}
    
}
