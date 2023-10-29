package org.sid.comptemanagement.exceptions;

/**
 * The type Compte not found exception.
 */
public class CompteNotFoundException extends RuntimeException {

    /**
     * Instantiates a new Compte not found exception.
     *
     * @param message the message
     */
    public CompteNotFoundException(String message) {
        super(message);
    }
}

