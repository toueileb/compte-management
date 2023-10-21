package org.sid.comptemanagement.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

/**
 * The type Compte request dto.
 */
@Data
public class CompteRequestDto {

    /**
     * The Id.
     */

    protected Long id;


    private BigDecimal transactionAmount;


    private Boolean isDeposit;

}