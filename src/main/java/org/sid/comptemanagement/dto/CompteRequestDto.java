package org.sid.comptemanagement.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

/**
 * The type Compte request dto.
 */
@Data
@Accessors(chain = true)
public class CompteRequestDto {

    /**
     * The Id.
     */
    @NonNull
    protected Long id;

    @NonNull
    private BigDecimal transactionAmount;

    @NonNull
    private Boolean isDeposit;

}