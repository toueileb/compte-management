package org.sid.comptemanagement.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.comptemanagement.dto.UtilisateurDto;
import org.sid.comptemanagement.entities.Utilisateur;
import org.sid.comptemanagement.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

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
    public List<UtilisateurDto> getAllUsers(){
        log.info("getAllUsers from UtilisateurService!");
        return utilisateurRepository.findAll().stream().map(UtilisateurDto::from).toList();
    }

}
