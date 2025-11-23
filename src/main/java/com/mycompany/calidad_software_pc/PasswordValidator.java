package com.mycompany.calidad_software_pc;

public class PasswordValidator {
    
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 64;
    private static final String SPECIAL_CHARS = "!@#$%^&*()_-+={[}]|\\:;\"'<>,.?/";
    
    public static boolean isValid(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }
        
        String trimmed = password.trim();
        if (trimmed.length() != password.length()) {
            return false;
        }
        
        if (password.contains("  ")) {
            return false;
        }
        
        if (password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            return false;
        }
        
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (SPECIAL_CHARS.indexOf(c) >= 0) hasSpecial = true;
            else if (c != ' ') return false;
        }
        
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}