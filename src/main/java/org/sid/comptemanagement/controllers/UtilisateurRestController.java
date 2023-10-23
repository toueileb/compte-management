package org.sid.comptemanagement.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.comptemanagement.controllers.request.UtilisateurRequest;
import org.sid.comptemanagement.dto.UtilisateurDto;
import org.sid.comptemanagement.entities.Utilisateur;
import org.sid.comptemanagement.jwt.JwtController;
import org.sid.comptemanagement.jwt.JwtFilter;
import org.sid.comptemanagement.jwt.JwtUtils;
import org.sid.comptemanagement.services.UtilisateurService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Utilisateur rest controller.
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class UtilisateurRestController {

    private final UtilisateurService utilisateurService;
    private final JwtController jwtController;
    private final JwtUtils jwtUtils;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/users")
    public List<UtilisateurDto> getAllUsers() {
        log.info("getAllUsers from UtilisateurController!");
        return utilisateurService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<?> add(@Valid @RequestBody UtilisateurRequest utilisateurRequest) {
        Utilisateur existingUser = utilisateurService.findUtilisateurByEmail(utilisateurRequest.getEmail());

        if (existingUser == null) {
            return new ResponseEntity<>("User already existing", HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = jwtController.logUser(utilisateurRequest.getEmail(), utilisateurRequest.getPassword());
        String jwt = jwtUtils.generateToken(authentication);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(utilisateurService.saveUser(utilisateurRequest), HttpStatus.CREATED);
    }

    @GetMapping(value = "/isConnected")
    public ResponseEntity getUSerConnected() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return new ResponseEntity(((UserDetails) principal).getUsername(), HttpStatus.OK);
        }
        return new ResponseEntity("User is not connected", HttpStatus.FORBIDDEN);
    }

}
