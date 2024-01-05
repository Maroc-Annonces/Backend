package com.youcode.MarocAnnonces.services;

import com.youcode.MarocAnnonces.models.Dtos.ChercheurDto.ChercheurDto;
import com.youcode.MarocAnnonces.models.Dtos.JobOfferDto.JobOfferDto;
import com.youcode.MarocAnnonces.models.Dtos.PostulationDto.PostulationDto;
import com.youcode.MarocAnnonces.models.Entities.Chercheur;
import com.youcode.MarocAnnonces.models.Entities.JobOffer;
import com.youcode.MarocAnnonces.models.Entities.Postulation;
import com.youcode.MarocAnnonces.repositories.ChercheurRepository;
import com.youcode.MarocAnnonces.repositories.JobOfferRepository;
import com.youcode.MarocAnnonces.repositories.PostulationRepository;
import com.youcode.MarocAnnonces.services.interfaces.JobOfferService;
import org.antlr.v4.runtime.misc.LogManager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobOfferServiceImp implements JobOfferService {
    private final JobOfferRepository jobOfferRepository;
    private final ChercheurRepository chercheurRepository;
    private final PostulationRepository postulationRepository;

    private final ModelMapper modelMapper;

    public JobOfferServiceImp(JobOfferRepository jobOfferRepository, ChercheurRepository chercheurRepository, PostulationRepository postulationRepository, ModelMapper modelMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.chercheurRepository = chercheurRepository;
        this.postulationRepository = postulationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<JobOfferDto> getAllJobOffers() {

        List<JobOffer> jobOffers = jobOfferRepository.findAll();

        return jobOffers.stream()
                .map(JobOffer -> modelMapper.map(JobOffer, JobOfferDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<JobOfferDto> getAll() {

        List<JobOffer> jobOffers = jobOfferRepository.findAll();

        return jobOffers.stream()
                .map(JobOffer -> modelMapper.map(JobOffer, JobOfferDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JobOfferDto> getById(Long id) {

        JobOffer jobOffer = jobOfferRepository.findById(id).orElse(null);

        return Optional.ofNullable(modelMapper.map(jobOffer, JobOfferDto.class));
    }

    @Override
    public Optional<JobOfferDto> create(JobOfferDto item) {

        JobOffer jobOffer = modelMapper.map(item, JobOffer.class);
        JobOffer savedJobOffer = jobOfferRepository.save(jobOffer);

        return Optional.ofNullable(modelMapper.map(savedJobOffer, JobOfferDto.class));
    }

    @Override
    public Optional<JobOfferDto> update(JobOfferDto item) {

        JobOffer jobOffer = modelMapper.map(item, JobOffer.class);
        JobOffer savedJobOffer = jobOfferRepository.save(jobOffer);

        return Optional.ofNullable(modelMapper.map(savedJobOffer, JobOfferDto.class));
    }

    @Override
    public void deleteById(Long id) {
        jobOfferRepository.deleteById(id);
    }

}
