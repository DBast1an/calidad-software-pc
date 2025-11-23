package com.mycompany.calidad_software_pc;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private Map<String, Integer> inventory = new HashMap<>();
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 1000;
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 50;

    public void addItem(String item, int quantity) {
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }

        if (item.length() < MIN_NAME_LENGTH || item.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("El nombre debe tener entre 2 y 50 caracteres");
        }

        if (quantity < MIN_QUANTITY) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }

        if (quantity > MAX_QUANTITY) {
            throw new IllegalArgumentException("La cantidad no puede exceder 1000 unidades");
        }

        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
    }

    public int getStock(String item) {
        return inventory.getOrDefault(item, 0);
    }

    public Map<String, Integer> getInventory() {
        return new HashMap<>(inventory);
    }
}
