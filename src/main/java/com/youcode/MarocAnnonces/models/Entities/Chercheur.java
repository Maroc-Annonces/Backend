package com.youcode.MarocAnnonces.models.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Chercheur")
public class Chercheur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String city;
    private String educationLevel;
    private String experience;
    private String skills;
    private String image;

    @ManyToOne
    @JoinColumn(name = "Postulation_id")
    private Postulation Postulation;
}
