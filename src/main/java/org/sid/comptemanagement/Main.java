package org.sid.comptemanagement;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
        String password = "12345678";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        System.out.println("Mot de passe original : " + password);
        System.out.println("Mot de passe haché : " + hashedPassword);
    }
}