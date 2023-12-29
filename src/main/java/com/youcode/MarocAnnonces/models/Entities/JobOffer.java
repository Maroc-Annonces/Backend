package com.youcode.MarocAnnonces.models.Entities;

import com.youcode.MarocAnnonces.models.Enums.EducationLevel;
import com.youcode.MarocAnnonces.models.Enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "job_offers")
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String profile;
    private String city;
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = true)
    private String salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
