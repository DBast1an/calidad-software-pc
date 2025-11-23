package com.mycompany.calidad_software_pc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextProcessorTest {

    @Test
    public void testTextoValido() {
        String resultado = TextProcessor.reverseAndCapitalize("hola");
        assertEquals("ALOH", resultado);
    }

    @Test
    public void testTextoNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize(null);
        });
        assertEquals("El texto no puede ser nulo", exception.getMessage());
    }

    @Test
    public void testTextoExcedeLimite() {
        String textoLargo = "a".repeat(1001);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize(textoLargo);
        });
        assertEquals("El texto excede el límite de 1000 caracteres", exception.getMessage());
    }

    @Test
    public void testTextoConEspacios() {
        String resultado = TextProcessor.reverseAndCapitalize("  mundo  ");
        assertEquals("ODNUM", resultado);
    }

    @Test
    public void testTextoSoloEspacios() {
        assertThrows(IllegalArgumentException.class, () -> {
            TextProcessor.reverseAndCapitalize("     ");
        });
    }

    @Test
    public void testMultiplesTransformaciones() {
        assertAll(
                () -> assertEquals("AVAJ", TextProcessor.reverseAndCapitalize("java")),
                () -> assertTrue(TextProcessor.reverseAndCapitalize("test").equals("TSET")),
                () -> assertFalse(TextProcessor.reverseAndCapitalize("abc").equals("abc"))
        );
    }
}
