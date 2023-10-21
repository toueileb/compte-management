package org.sid.comptemanagement.exceptions;

public class CompteNotFoundException extends RuntimeException {

    public CompteNotFoundException(String message) {
        super(message);
    }
}

