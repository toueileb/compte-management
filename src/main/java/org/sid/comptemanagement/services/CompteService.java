package org.sid.comptemanagement.services;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.comptemanagement.controllers.request.CompteRequestDto;
import org.sid.comptemanagement.dto.CompteDto;
import org.sid.comptemanagement.entities.Compte;
import org.sid.comptemanagement.enums.TypeMouvementEnum;
import org.sid.comptemanagement.exceptions.CompteNotFoundException;
import org.sid.comptemanagement.repositories.CompteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * The type Compte service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CompteService {
    private final CompteRepository compteRepository;
    private final MouvementService mouvementService;

    /**
     * Get compte by id compte dto.
     *
     * @param compteId the compte id
     * @return the compte dto
     */
    public CompteDto getCompteById(Long compteId) {

        log.info("getCompteById from CompteService!");
        Compte compte = compteRepository.findById(compteId)
                .orElseThrow(() -> new CompteNotFoundException(String.format("Le compte %d n'existe pas dans la BD", compteId)));

        return CompteDto.from(compte);
    }

    @Transactional
    public void modifyAccountBalance(@Valid CompteRequestDto compteRequestDto) {

        TypeMouvementEnum typeMouvementEnum = null;

        Compte updatedCompte = compteRepository.findById(compteRequestDto.getId())
                .orElseThrow(() -> new CompteNotFoundException(String.format("Le compte %d n'existe pas dans la BD", compteRequestDto.getId())));


        BigDecimal soldeChange = compteRequestDto.getTransactionAmount();

        if (compteRequestDto.getIsDeposit()) {
            updatedCompte.setSolde(updatedCompte.getSolde().add(soldeChange));
            typeMouvementEnum = TypeMouvementEnum.ADD;
        } else {
            BigDecimal newSolde = updatedCompte.getSolde().subtract(soldeChange);
            if (newSolde.compareTo(BigDecimal.ZERO) < 0) {
                    throw new IllegalArgumentException("Solde insuffisant pour cette opération");
            }
            updatedCompte.setSolde(newSolde);
            typeMouvementEnum = TypeMouvementEnum.WITHDRAW;
        }

        Compte savedCompte = compteRepository.save(updatedCompte);
        mouvementService.saveMouvement(savedCompte.getId(), savedCompte.getSolde(), typeMouvementEnum);
    }

}
