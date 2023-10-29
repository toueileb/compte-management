package org.sid.comptemanagement.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.sid.comptemanagement.dto.MouvementDto;
import org.sid.comptemanagement.entities.Compte;
import org.sid.comptemanagement.entities.Mouvement;
import org.sid.comptemanagement.repositories.MouvementRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


/**
 * The type Mouvement service test.
 */
@RunWith(MockitoJUnitRunner.class)
public class MouvementServiceTest {

    @Mock
    private MouvementRepository mouvementRepository;

    @InjectMocks
    private MouvementService mouvementService;


    /**
     * Test get mouvements by compte id.
     */
    @Test
    public void testGetMouvementsByCompteId() {

        // Create test data
        Long compteId = 1L;
        var mouvement1 = new Mouvement().setId(1l).setSolde(BigDecimal.valueOf(1000)).setReference("REF 1").setCompte(new Compte().setId(compteId));
        var mouvement2 = new Mouvement().setId(2l).setSolde(BigDecimal.valueOf(2000)).setReference("REF 2").setCompte(new Compte().setId(compteId));

        // Configure the behavior of the mocked repository (mouvementRepository) using Mockito
        when(mouvementRepository.getMouvementByCompteId(compteId)).thenReturn(List.of(mouvement1, mouvement2));

        // Call the method to be tested
        var result = mouvementService.getMouvementsByCompteId(compteId);

        // Check the results
        assertNotNull(result);
        assertEquals(2, result.size());

        // Check the properties of MouvementDto objects
        MouvementDto resultMouvement1 = result.get(0);
        assertEquals(mouvement1.getId(), resultMouvement1.getId());
        assertEquals(mouvement1.getSolde(), resultMouvement1.getSolde());

        MouvementDto resultMouvement2 = result.get(1);
        assertEquals(mouvement2.getId(), resultMouvement2.getId());
        assertEquals(mouvement2.getSolde(), resultMouvement2.getSolde());

        // Verify that the repository method was called
        verify(mouvementRepository, times(1)).getMouvementByCompteId(compteId);
    }
}