package org.sid.comptemanagement.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The persistent class for the UTILISATEUR database table.
 */
@Entity
@Data
@Table(name = "UTILISATEUR")
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;

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
    @JoinColumn(name = "COMPTE_ID")
    private Compte compte;


}
