package org.sid.comptemanagement.repositories;

import org.sid.comptemanagement.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Utilisateur repository.
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findOneByEmail(String email);
}
