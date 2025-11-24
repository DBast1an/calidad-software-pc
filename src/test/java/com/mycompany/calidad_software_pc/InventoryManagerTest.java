package com.mycompany.calidad_software_pc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagerTest {

    private InventoryManager manager;

    @BeforeEach
    public void setUp() {
        manager = new InventoryManager();
    }

    @Test
    public void testAgregarItemNuevo() {
        manager.addItem("Laptop", 5);
        assertEquals(5, manager.getStock("Laptop"));
    }

    @Test
    public void testAgregarCantidadNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addItem("Mouse", -1);
        });
    }

    @Test
    public void testAgregarItemNombreVacio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            manager.addItem("", 5);
        });
        assertEquals("El nombre del producto no puede estar vacío", exception.getMessage());
    }

    @Test
    public void testAgregarMismoProductoVarias() {
        manager.addItem("Teclado", 10);
        manager.addItem("Teclado", 5);
        assertEquals(15, manager.getStock("Teclado"));
    }

    @Test
    public void testCantidadExcedeLimite() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addItem("Monitor", 1001);
        });
    }

    @Test
    public void testValidacionesMultiples() {
        assertAll(
                () -> assertTrue(manager.getStock("Inexistente") == 0),
                () -> assertFalse(manager.getInventory().containsKey("NoExiste")),
                () -> {
                    manager.addItem("Auriculares", 50);
                    assertEquals(50, manager.getStock("Auriculares"));
                }
        );
    }
    
    // Para cubrir el fallo por nombre demasiado corto (Línea 20)
@Test
public void testNombreDemasiadoCorto() {
    // Asumiendo que el mínimo es 2, "A" falla.
    assertThrows(IllegalArgumentException.class, () -> 
        manager.addItem("A", 5)); 
}

// Para cubrir el fallo por nombre que excede el máximo (Línea 20)
@Test
public void testNombreExcedeMaximo() {
    String longName = "a".repeat(51); // Asumiendo que el máximo es 50
    assertThrows(IllegalArgumentException.class, () -> 
        manager.addItem(longName, 10)); 
}
}
