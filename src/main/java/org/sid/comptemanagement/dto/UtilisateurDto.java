package org.sid.comptemanagement.dto;


import lombok.Data;
import lombok.experimental.Accessors;
import org.sid.comptemanagement.entities.Utilisateur;

/**
 * The type Utilisateur dto.
 */
@Data
@Accessors(chain = true)
public class UtilisateurDto {

    private Long id;

    private String email;

    private String lastName;

    private String firstName;

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
                .setEmail(utilisateur.getEmail())
                .setFirstName(utilisateur.getFirstName())
                .setLastName(utilisateur.getLastName())
                .setCompteId(utilisateur.getCompte().getId());
    }

}
