package org.sid.comptemanagement.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.comptemanagement.dto.MouvementDto;
import org.sid.comptemanagement.entities.Compte;
import org.sid.comptemanagement.entities.Mouvement;
import org.sid.comptemanagement.enums.TypeMouvementEnum;
import org.sid.comptemanagement.repositories.MouvementRepository;
import org.sid.comptemanagement.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Mouvement service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MouvementService {

    private final MouvementRepository mouvementRepository;

    /**
     * Get mouvements by compte id list.
     *
     * @param compteId the compte id
     * @return the list
     */
    public List<MouvementDto> getMouvementsByCompteId(Long compteId){
        return mouvementRepository.getMouvementByCompteId(compteId).stream().map(MouvementDto::from).toList();

    }

    public void saveMouvement(Long compteId, BigDecimal solde, TypeMouvementEnum typeMouvement){
        Mouvement mouvement = new Mouvement();
        mouvement.setId(mouvementRepository.getMaxId() + 1);
        //.setCompte(new Compte().setId(compte.getId()))
        mouvement.setCompte(new Compte().setId(compteId));
        mouvement.setDate(LocalDateTime.now());
        mouvement.setSolde(solde);
        mouvement.setReference(Util.generateUniqueString());
        mouvement.setTypeMouvement(typeMouvement);

        mouvementRepository.save(mouvement);
        log.info("Operation Saved Successfully");
    }
}
