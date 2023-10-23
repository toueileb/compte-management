package org.sid.comptemanagement.controllers.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.Accessors;
import org.sid.comptemanagement.entities.Compte;
import org.sid.comptemanagement.entities.Utilisateur;

/**
 * The type Utilisateur request.
 */
@Data
@Accessors(chain = true)
public class UtilisateurRequest {

    private int id;


    private String email;

    @Size(min = 2, max = 25, message = "Firstname Entre 2 et 25 caracteres SVP")
    private String lastName;

    @Size(min = 2, max = 25, message = "Lastname Entre 2 et 25 caracteres SVP")
    private String firstName;

    private String password;


}
