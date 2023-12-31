package com.youcode.MarocAnnonces.services.interfaces;

import com.youcode.MarocAnnonces.models.Dtos.ChercheurDto.ChercheurDto;
import com.youcode.MarocAnnonces.models.Dtos.JobOfferDto.JobOfferDto;
import com.youcode.MarocAnnonces.models.Dtos.PostulationDto.PostulationDto;

import java.util.List;
import java.util.Optional;


public interface JobOfferService extends BaseService<JobOfferDto>{

    List<JobOfferDto> getAllJobOffers();
}
