package org.sid.comptemanagement.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.sid.comptemanagement.entities.Mouvement;

import java.math.BigDecimal;


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

    private Long jour;

    private String reference;

    private BigDecimal solde;


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
                .setJour(mouvement.getJour())
                .setSolde(mouvement.getSolde());
    }
}