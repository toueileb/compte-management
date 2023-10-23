package org.sid.comptemanagement.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.sid.comptemanagement.controllers.request.CompteRequestDto;
import org.sid.comptemanagement.entities.Compte;
import org.sid.comptemanagement.repositories.CompteRepository;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * The type Compte service test.
 */
@RunWith(MockitoJUnitRunner.class)
public class CompteServiceTest {
    @Mock
    private CompteRepository compteRepository;

    @InjectMocks
    private CompteService compteService;

    /**
     * Test get compte by id.
     */
    @Test
    public void testGetCompteById() {
        // Create test data
        Long compteId = 1L;
        Compte compte = new Compte().setId(compteId).setTypeCompte("Courant");

        // Configure the behavior of the mocked repository (compteRepository) using Mockito
        Mockito.when(compteRepository.findById(compteId)).thenReturn(Optional.of(compte));

        // Call the method to be tested
        var result = compteService.getCompteById(compteId);


        // Check the results
        assertNotNull(result);
        assertEquals(compte.getId(), result.getId());

        // Verify that the repository method was called
        verify(compteRepository, times(1)).findById(compteId);
    }


    /**
     * Test modify account balance.
     */
    @Test
    public void testModifyAccountBalance() {
        // Create test data
        CompteRequestDto compteRequestDto = new CompteRequestDto();
        compteRequestDto.setId(1L);
        compteRequestDto.setTransactionAmount(new BigDecimal("200.00"));
        compteRequestDto.setIsDeposit(true);

        Compte compte = new Compte();
        compte.setId(1L);
        compte.setSolde(new BigDecimal("1000.00"));
        // Initialize other properties of the Compte object as needed

        // Configure the behavior of the mocked repository (compteRepository) using Mockito
        Mockito.when(compteRepository.findById(compteRequestDto.getId())).thenReturn(Optional.of(compte));
        Mockito.when(compteRepository.save(compte)).thenReturn(compte);

        // Call the method to be tested
        compteService.modifyAccountBalance(compteRequestDto);

        // Verify the result
        assertEquals(new BigDecimal("1200.00"), compte.getSolde()); // Verify that the solde is updated correctly

        // Check for IllegalArgumentException when the solde is insufficient for a withdrawal
        CompteRequestDto withdrawalRequest = new CompteRequestDto();
        withdrawalRequest.setId(1L);
        withdrawalRequest.setTransactionAmount(new BigDecimal("1400.00"));
        withdrawalRequest.setIsDeposit(false);

        // Configure the behavior of the mocked repository for the insufficient solde scenario
        Mockito.when(compteRepository.findById(withdrawalRequest.getId())).thenReturn(Optional.of(compte));

        // Verify that an IllegalArgumentException is thrown for an insufficient solde
        assertThrows(IllegalArgumentException.class, () -> compteService.modifyAccountBalance(withdrawalRequest));
    }
}