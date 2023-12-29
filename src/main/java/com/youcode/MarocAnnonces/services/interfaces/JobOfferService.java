package com.youcode.MarocAnnonces.services.interfaces;

import com.youcode.MarocAnnonces.models.Dtos.JobOfferDto.JobOfferDto;

import java.util.List;


public interface JobOfferService extends BaseService<JobOfferDto>{

    List<JobOfferDto> getAllJobOffers(int page, int pageSize, String sortBy);
}
