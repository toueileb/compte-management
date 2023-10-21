package org.sid.comptemanagement.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The persistent class for the MOUVEMENT database table.
 */
@Entity
@Table(name = "MOUVEMENT")
@Data
@Accessors(chain = true)
public class Mouvement implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    private Long jour;

    private String reference;

    private BigDecimal solde;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;


}