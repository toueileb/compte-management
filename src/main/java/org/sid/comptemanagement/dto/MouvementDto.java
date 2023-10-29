package org.sid.comptemanagement.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.sid.comptemanagement.entities.Mouvement;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * The type Mouvement dto.
 */
@Data
@Accessors(chain = true)
public class MouvementDto {


    /**
     * The Id.
     */
    protected Long id;

    private LocalDateTime date;

    private String reference;

    private BigDecimal solde;

    private String typeMouvement;


    /**
     * From mouvement dto.
     *
     * @param mouvement the mouvement
     * @return the mouvement dto
     */
    public static MouvementDto from(Mouvement mouvement){
        if (mouvement == null){
            return null;
        }

        return new MouvementDto()
                .setId(mouvement.getId())
                .setDate(mouvement.getDate())
                .setReference(mouvement.getReference())
                .setSolde(mouvement.getSolde())
                .setTypeMouvement(mouvement.getTypeMouvement().getLibelle());
    }
}