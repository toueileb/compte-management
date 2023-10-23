package org.sid.comptemanagement.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * The persistent class for the UTILISATEUR database table.
 */
@Entity
@Table(name = "UTILISATEUR")
@Data
@Accessors(chain = true)
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(name = "LAST_NAME", unique = true)
    private String lastName;

    @Column(name = "FIRST_NAME", unique = true)
    private String firstName;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "COMPTE_ID", nullable = false)
    private Compte compte;

}
