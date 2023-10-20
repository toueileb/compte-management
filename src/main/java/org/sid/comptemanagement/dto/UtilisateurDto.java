package org.sid.comptemanagement.dto;


import lombok.Data;
import lombok.experimental.Accessors;
import org.sid.comptemanagement.entities.Utilisateur;

import java.time.LocalDateTime;

/**
 * The type Utilisateur dto.
 */
@Data
@Accessors(chain = true)
public class UtilisateurDto {

    /**
     * The Id.
     */
    protected Long id;

    private Boolean accountExpired;

    private Boolean accountLocked;

    private String agence;

    private String langue;

    private String typeProfile;

    private LocalDateTime dateLastConnection;

    private Long compteId;

    /**
     * From utilisateur dto.
     *
     * @param utilisateur the utilisateur
     * @return the utilisateur dto
     */
    public static UtilisateurDto from(Utilisateur utilisateur){
        if (utilisateur == null){
            return null;
        }

        return new UtilisateurDto()
                .setId(utilisateur.getId())
                .setAccountExpired(utilisateur.getAccountExpired())
                .setAccountLocked(utilisateur.getAccountLocked())
                .setAgence(utilisateur.getAgence())
                .setLangue(utilisateur.getLangue())
                .setTypeProfile(utilisateur.getTypeProfile())
                .setDateLastConnection(utilisateur.getDateLastConnection())
                .setCompteId(utilisateur.getCompte().getId());
    }

}
