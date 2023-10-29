package org.sid.comptemanagement.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.comptemanagement.dto.UtilisateurDto;
import org.sid.comptemanagement.services.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Utilisateur rest controller.
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class UtilisateurRestController {

    private final UtilisateurService utilisateurService;

    /**
     * Gets all users.
     *
     * @return the all users
     */
    @GetMapping("/users")
    public List<UtilisateurDto> getAllUsers() {
        log.info("getAllUsers from UtilisateurController!");
        return utilisateurService.getAllUsers();
    }


    /**
     * Gets u ser connected.
     *
     * @return the u ser connected
     */
    @GetMapping(value = "/isConnected")
    public ResponseEntity<?> getUSerConnected() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return new ResponseEntity<>(((UserDetails) principal).getUsername(), HttpStatus.OK);
        }
        return new ResponseEntity<>("User is not connected", HttpStatus.FORBIDDEN);
    }

}
