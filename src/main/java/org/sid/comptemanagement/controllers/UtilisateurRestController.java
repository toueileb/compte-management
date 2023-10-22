package org.sid.comptemanagement.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.comptemanagement.dto.UtilisateurDto;
import org.sid.comptemanagement.services.UtilisateurService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Utilisateur rest controller.
 */
@RestController
@RequestMapping("utilisateurs")
@RequiredArgsConstructor
@Slf4j
public class UtilisateurRestController {

    private final UtilisateurService utilisateurService;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping
    public List<UtilisateurDto> getAllUsers(){
        log.info("getAllUsers from UtilisateurController!");
        return utilisateurService.getAllUsers();
    }
}
