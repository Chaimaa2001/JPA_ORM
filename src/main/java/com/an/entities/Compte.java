package com.an.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.Date;

@Entity
@Table(name="COMPTES")
@NamedQueries( {
        @NamedQuery(name = "findByType", query = "SELECT c FROM Compte c where c.type=:x ")
})
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Compte implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="CODE")
    private Long code;
    private double solde;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    @Column(length=15)
    private TypeCompte type;
}
