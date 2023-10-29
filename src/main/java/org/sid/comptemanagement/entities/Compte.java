package org.sid.comptemanagement.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * The persistent class for the COMPTE database table.
 */
@Entity
@Data
@Table(name = "COMPTE")
@Accessors(chain = true)
public class Compte implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    @Column(name = "STATUT")
    private String statut;

    private String agence;

    private String rib;

    private String devise;

    private String intitule;

    @Column(name = "SOLDE")
    private BigDecimal solde;

    @Column(name = "TYPE_COMPTE")
    private String typeCompte;


}