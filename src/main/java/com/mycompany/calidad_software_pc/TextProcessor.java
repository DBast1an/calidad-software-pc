package com.mycompany.calidad_software_pc;

public class TextProcessor {

    private static final int MAX_LENGTH = 1000;

    public static String reverseAndCapitalize(String input) {
        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        if (input.isEmpty() || input.trim().isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }

        String trimmed = input.trim();

        if (trimmed.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        String reversed = new StringBuilder(trimmed).reverse().toString();
        return reversed.toUpperCase();
    }
}
