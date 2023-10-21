package org.sid.comptemanagement.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.sid.comptemanagement.dto.UtilisateurDto;
import org.sid.comptemanagement.entities.Compte;
import org.sid.comptemanagement.entities.Utilisateur;
import org.sid.comptemanagement.repositories.UtilisateurRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * The type Utilisateur service test.
 */
@RunWith(MockitoJUnitRunner.class)
public class UtilisateurServiceTest {

    @InjectMocks
    private UtilisateurService utilisateurService;

    @Mock
    private UtilisateurRepository utilisateurRepository;


    /**
     * Test get all users.
     */
    @Test
    public void testGetAllUsers() {
        // Create test data

        Compte compte1 = new Compte().setId(1l);
        Utilisateur user1 = new Utilisateur().setId(1l).setAgence("Agence 1").setCompte(compte1);
        Compte compte2 = new Compte().setId(2l);
        Utilisateur user2 = new Utilisateur().setId(2l).setAgence("Agence 2").setCompte(compte2);
        List<Utilisateur> userList = List.of(
                user1,
                user2
        );

        // Configure the behavior of the mocked repository (utilisateurRepository) using Mockito
        Mockito.when(utilisateurRepository.findAll()).thenReturn(userList);

        // Call the method to be tested
        List<UtilisateurDto> result = utilisateurService.getAllUsers();

        // Verify the result
        assertNotNull(result);
        assertEquals(2, result.size()); // Verify the size of the resulting list
        assertEquals(user1.getId(), result.get(0).getId());
        assertEquals(user2.getId(), result.get(1).getId());
        assertEquals(user1.getCompte().getId(), result.get(0).getCompteId());
        assertEquals(user2.getCompte().getId(), result.get(1).getCompteId());
        // Verify that the repository method was called
        verify(utilisateurRepository, times(1)).findAll();
    }
}