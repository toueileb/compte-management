package org.sid.comptemanagement.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.comptemanagement.dto.CompteDto;
import org.sid.comptemanagement.entities.Compte;
import org.sid.comptemanagement.repositories.CompteRepository;
import org.springframework.stereotype.Service;

/**
 * The type Compte service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CompteService {
    private final CompteRepository compteRepository;

    /**
     * Get compte by id compte dto.
     *
     * @param compteId the compte id
     * @return the compte dto
     */
    public CompteDto getCompteById(Long compteId){
        log.info("getCompteById from CompteService!");
        return CompteDto.from(compteRepository.getReferenceById(compteId));

    }

}
