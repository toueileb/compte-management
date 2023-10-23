package org.sid.comptemanagement.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.comptemanagement.controllers.request.UtilisateurRequest;
import org.sid.comptemanagement.dto.UtilisateurDto;
import org.sid.comptemanagement.entities.Compte;
import org.sid.comptemanagement.entities.Utilisateur;
import org.sid.comptemanagement.repositories.UtilisateurRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * The type Utilisateur service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    /**
     * Get all users list.
     *
     * @return the list
     */
    public List<UtilisateurDto> getAllUsers() {
        log.info("getAllUsers from UtilisateurService!");
        return utilisateurRepository.findAll().stream().map(UtilisateurDto::from).toList();
    }

    public Utilisateur findUtilisateurByEmail(String email) {
        Utilisateur utilisateurByEmail = utilisateurRepository.findOneByEmail(email);
        return utilisateurByEmail;
    }


    public Utilisateur saveUser(UtilisateurRequest utilisateurRequest) {
        Utilisateur user = new Utilisateur();

        //TO_DO Fix that later
        user.setCompte(new Compte().setId(1l));
        user.setEmail(utilisateurRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(utilisateurRequest.getPassword()));
        user.setLastName(StringUtils.capitalize(utilisateurRequest.getLastName()));
        user.setFirstName(StringUtils.capitalize(utilisateurRequest.getFirstName()));
        utilisateurRepository.save(user);
        return user;
    }
}
