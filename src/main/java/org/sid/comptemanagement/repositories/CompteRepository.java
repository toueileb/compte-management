package org.sid.comptemanagement.repositories;

import org.sid.comptemanagement.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Compte repository.
 */
@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
