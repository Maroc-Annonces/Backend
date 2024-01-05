package com.youcode.MarocAnnonces.controllers;

import com.youcode.MarocAnnonces.models.Dtos.ChercheurDto.ChercheurDto;
import com.youcode.MarocAnnonces.models.Dtos.JobOfferDto.JobOfferDto;
import com.youcode.MarocAnnonces.models.Dtos.PostulationDto.PostulationDto;
import com.youcode.MarocAnnonces.services.interfaces.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/jobOffers")
public class JobOfferController {
    private final JobOfferService jobOfferService;

    @Autowired
    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @GetMapping
    public List<JobOfferDto> getAllJobOffers(){

        return jobOfferService.getAllJobOffers();
    }

    @GetMapping("/{id}")
    public Optional<JobOfferDto> getJobOfferById(@PathVariable Long id){
        return jobOfferService.getById(id);
    }

    @PostMapping("/create")
    public Optional<JobOfferDto> createJobOffer(@RequestBody JobOfferDto jobOfferDto){

        return jobOfferService.create(jobOfferDto);
    }

    @PutMapping("/update")
    public Optional<JobOfferDto> updateJobOffer(@RequestBody JobOfferDto jobOfferDto){

        return jobOfferService.update(jobOfferDto);
    }
}
