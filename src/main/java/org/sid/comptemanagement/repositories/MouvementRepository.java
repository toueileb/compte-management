package org.sid.comptemanagement.repositories;

import org.sid.comptemanagement.entities.Mouvement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Mouvement repository.
 */
@Repository
public interface MouvementRepository extends JpaRepository<Mouvement, Long> {
    /**
     * Gets mouvement by compte id.
     *
     * @param compteId the compte id
     * @return the mouvement by compte id
     */
    List<Mouvement> getMouvementByCompteId(Long compteId);
}
