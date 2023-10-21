package org.sid.comptemanagement.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The persistent class for the UTILISATEUR database table.
 */
@Entity
@Table(name = "UTILISATEUR")
@Data
@Accessors(chain = true)
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "ACCOUNT_EXPIRED")
    private Boolean accountExpired;

    @Column(name = "ACCOUNT_LOCKED")
    private Boolean accountLocked;

    @Column(name = "AGENCE")
    private String agence;

    @Column(name = "LANGUE")
    private String langue;

    @Column(name = "TYPE_PROFILE")
    private String typeProfile;


    @Column(name = "DATE_LAST_CONNECTION")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateLastConnection;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "COMPTE_ID", nullable = false)
    private Compte compte;

}
