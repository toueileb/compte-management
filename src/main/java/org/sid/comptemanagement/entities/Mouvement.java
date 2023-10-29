package org.sid.comptemanagement.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.sid.comptemanagement.enums.TypeMouvementEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private LocalDateTime date;

    @Column(name = "REFERENCE", unique = true)
    private String reference;

    private BigDecimal solde;

    // Add the typeMouvement field
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_MOUVEMENT")
    private TypeMouvementEnum typeMouvement;
    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;


}