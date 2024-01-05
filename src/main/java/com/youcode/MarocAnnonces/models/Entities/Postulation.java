package com.youcode.MarocAnnonces.models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Postulation")
public class Postulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "JobOffer_id")
    private JobOffer JobOffer;

    @ManyToOne
    @JoinColumn(name = "Chercheur_id")
    private Chercheur Chercheur;
}
