package com.youcode.MarocAnnonces.models.Dtos.CompanyDto;

import com.youcode.MarocAnnonces.models.Dtos.JobOfferDto.JobOfferResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyDto {
    private Long id;
    private String name;
    private String description;
    private String phone;
    private String email;
    private String login;
    private String image;
    private boolean isVerified;

    private List<JobOfferResponseDto> jobOffers;
}
