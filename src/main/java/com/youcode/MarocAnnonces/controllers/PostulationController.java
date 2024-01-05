package com.youcode.MarocAnnonces.controllers;

import com.youcode.MarocAnnonces.models.Dtos.ChercheurDto.ChercheurDto;
import com.youcode.MarocAnnonces.models.Dtos.PostulationDto.PostulationDto;
import com.youcode.MarocAnnonces.services.interfaces.PostulationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/Postulations")
public class PostulationController {
    private final PostulationsService postulationsService;
    @Autowired
    public PostulationController(PostulationsService postulationsService) {
        this.postulationsService = postulationsService;
    }
    @PostMapping("/postuler/{id}")
    public Optional<PostulationDto> Postuler(@PathVariable Long id, @RequestBody ChercheurDto chercheurDto){

        return postulationsService.Postuler(id, chercheurDto);
    }
}
