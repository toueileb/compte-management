package org.sid.comptemanagement.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.comptemanagement.dto.CompteDto;
import org.sid.comptemanagement.entities.Compte;
import org.sid.comptemanagement.services.CompteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Compte controller.
 */
@RestController
@RequestMapping("comptes")
@RequiredArgsConstructor
@Slf4j
public class CompteController {
    private final CompteService compteService;

    /**
     * Gets compte by id.
     *
     * @param compteId the compte id
     * @return the compte by id
     */
    @GetMapping("/{compteId}")
    public CompteDto getCompteById(@PathVariable("compteId") Long compteId){
        log.info("getCompteById from CompteController!");
        return compteService.getCompteById(compteId);
    }

}
