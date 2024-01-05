package com.youcode.MarocAnnonces.models.Dtos.PostulationDto;

import com.youcode.MarocAnnonces.models.Dtos.ChercheurDto.ChercheurResponseDto;
import com.youcode.MarocAnnonces.models.Dtos.JobOfferDto.JobOfferResponseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostulationDto {
    private Long id;
    private JobOfferResponseDto JobOffer;
    private ChercheurResponseDto Chercheur;
}
