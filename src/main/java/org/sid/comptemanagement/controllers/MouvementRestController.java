package org.sid.comptemanagement.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.comptemanagement.dto.MouvementDto;
import org.sid.comptemanagement.services.MouvementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Mouvement rest controller.
 */
@RestController
@RequestMapping("mouvements")
@RequiredArgsConstructor
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class MouvementRestController {
    private final MouvementService mouvementService;

    /**
     * Gets mouvements by compte id.
     *
     * @param compteId the compte id
     * @return the mouvements by compte id
     */
    @GetMapping("/compte/{compteId}")
    public List<MouvementDto> getMouvementsByCompteId(@PathVariable("compteId") Long compteId){
        return mouvementService.getMouvementsByCompteId(compteId);
    }
}
