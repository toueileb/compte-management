package org.sid.comptemanagement.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.comptemanagement.dto.CompteDto;
import org.sid.comptemanagement.dto.CompteRequestDto;
import org.sid.comptemanagement.services.CompteService;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Add money to count.
     *
     * @param compteRequestDto the compte request dto
     */
    @PostMapping("/modifyAccountBalance")
    public void modifyAccountBalance(@RequestBody CompteRequestDto compteRequestDto){
        log.debug("compteRequestDto: {}", compteRequestDto);
        compteService.modifyAccountBalance(compteRequestDto);
    }
}
