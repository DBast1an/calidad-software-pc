package com.mycompany.calidad_software_pc;

import java.util.regex.Pattern;

public class EmailValidator {
    
    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 254;
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[a-zA-Z0-9_-]+(?:\\.[a-zA-Z0-9_-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,}$"
    );
    
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede ser nulo o vacío");
        }
        
        if (email.contains(" ")) {
            return false;
        }
        
        if (email.length() < MIN_LENGTH || email.length() > MAX_LENGTH) {
            return false;
        }
        
        if (!email.contains("@")) {
            return false;
        }
        
        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false;
        }
        
        String local = parts[0];
        String domain = parts[1];
        
        if (local.startsWith(".") || local.endsWith(".")) {
            return false;
        }
        
        if (local.contains("..")) {
            return false;
        }
        
        if (!domain.contains(".")) {
            return false;
        }
        
        String[] domainParts = domain.split("\\.");
        if (domainParts.length < 2 || domainParts[0].length() < 2) {
            return false;
        }
        
        return EMAIL_PATTERN.matcher(email).matches();
    }
}