package org.sid.comptemanagement.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.sid.comptemanagement.entities.Compte;

import java.math.BigDecimal;

/**
 * The type Compte dto.
 */
@Data
@Accessors(chain = true)
public class CompteDto {

    /**
     * The Id.
     */
    protected Long id;


    private String statut;

    private String agence;

    private String rib;

    private String devise;

    private String intitule;

    private BigDecimal solde;

    private String typeCompte;


    /**
     * From compte dto.
     *
     * @param compte the compte
     * @return the compte dto
     */
    public static CompteDto from(Compte compte) {
        if (compte == null) {
            return null;
        }

        return new CompteDto()
                .setId(compte.getId())
                .setStatut(compte.getStatut())
                .setAgence(compte.getAgence())
                .setRib(compte.getRib())
                .setDevise(compte.getDevise())
                .setIntitule(compte.getIntitule())
                .setSolde(compte.getSolde())
                .setTypeCompte(compte.getTypeCompte());
    }
}