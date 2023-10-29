package org.sid.comptemanagement.controllers.request;

import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    protected Long id;


    @NotEmpty
    private BigDecimal transactionAmount;


    @NotEmpty
    private Boolean isDeposit;

}