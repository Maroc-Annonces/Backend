package com.youcode.MarocAnnonces.models.Dtos.JobOfferDto;

import com.youcode.MarocAnnonces.models.Dtos.CompanyDto.CompanyResponseDto;
import com.youcode.MarocAnnonces.models.Enums.EducationLevel;
import com.youcode.MarocAnnonces.models.Enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobOfferDto {
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
    private CompanyResponseDto company;
}
