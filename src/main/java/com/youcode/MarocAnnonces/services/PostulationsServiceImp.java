package com.youcode.MarocAnnonces.services;

import com.youcode.MarocAnnonces.models.Dtos.ChercheurDto.ChercheurDto;
import com.youcode.MarocAnnonces.models.Dtos.PostulationDto.PostulationDto;
import com.youcode.MarocAnnonces.models.Entities.Chercheur;
import com.youcode.MarocAnnonces.models.Entities.Postulation;
import com.youcode.MarocAnnonces.repositories.ChercheurRepository;
import com.youcode.MarocAnnonces.repositories.JobOfferRepository;
import com.youcode.MarocAnnonces.repositories.PostulationRepository;
import com.youcode.MarocAnnonces.services.interfaces.PostulationsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostulationsServiceImp implements PostulationsService {
    private final ModelMapper modelMapper;
    private final JobOfferRepository jobOfferRepository;
    private final ChercheurRepository chercheurRepository;
    private final PostulationRepository postulationRepository;

    public PostulationsServiceImp(ModelMapper modelMapper, JobOfferRepository jobOfferRepository, ChercheurRepository chercheurRepository, PostulationRepository postulationRepository) {
        this.modelMapper = modelMapper;
        this.jobOfferRepository = jobOfferRepository;
        this.chercheurRepository = chercheurRepository;
        this.postulationRepository = postulationRepository;
    }

    @Override
    public Optional<PostulationDto> Postuler(Long idOffer, ChercheurDto chercheurDto) {
        Chercheur chercheur = modelMapper.map(chercheurDto, Chercheur.class);
        Chercheur savedChercheur = chercheurRepository.save(chercheur);

        Postulation postulation = new Postulation();

        postulation.setChercheur(savedChercheur);
        postulation.setJobOffer(jobOfferRepository.findById(idOffer).get());

        Postulation savedPostulation = postulationRepository.save(postulation);
        return Optional.ofNullable(modelMapper.map(savedPostulation, PostulationDto.class));
    }

    @Override
    public List<PostulationDto> getAll() {
        return null;
    }

    @Override
    public Optional<PostulationDto> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<PostulationDto> create(PostulationDto item) {
        return Optional.empty();
    }

    @Override
    public Optional<PostulationDto> update(PostulationDto item) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}
