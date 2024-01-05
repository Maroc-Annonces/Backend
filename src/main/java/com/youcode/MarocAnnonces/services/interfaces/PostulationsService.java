package com.youcode.MarocAnnonces.services.interfaces;

import com.youcode.MarocAnnonces.models.Dtos.ChercheurDto.ChercheurDto;
import com.youcode.MarocAnnonces.models.Dtos.PostulationDto.PostulationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PostulationsService extends BaseService<PostulationDto>{
    Optional<PostulationDto> Postuler(Long idOffer, ChercheurDto chercheurDto);
}
