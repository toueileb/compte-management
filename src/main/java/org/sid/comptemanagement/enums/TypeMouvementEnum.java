package org.sid.comptemanagement.enums;

/**
 * The enum Type mouvement enum.
 */
public enum TypeMouvementEnum {
    /**
     * Add type mouvement enum.
     */
    ADD("Ajout"),
    /**
     * Withdraw type mouvement enum.
     */
    WITHDRAW("Retrait");

    private final String libelle;

    TypeMouvementEnum(String libelleDescriptif) {
        this.libelle = libelleDescriptif;
    }

    /**
     * Gets libelle.
     *
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }
}

