package com.youcode.MarocAnnonces.controllers;

import com.youcode.MarocAnnonces.exceptions.ApiRequestException;
import com.youcode.MarocAnnonces.models.Dtos.CompanyDto.CompanyDto;
import com.youcode.MarocAnnonces.models.Entities.VerifiedAccount;
import com.youcode.MarocAnnonces.services.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyDto> getAllCompanies(){

        return companyService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CompanyDto> getCompanyById(@PathVariable Long id){

        if(Optional.ofNullable(companyService.getById(id)).isEmpty())
            throw new ApiRequestException("Company not found");

        return companyService.getById(id);
    }

    @PostMapping("/auth")
    public Optional<CompanyDto> createCompany(@RequestBody CompanyDto companyDto){

        return companyService.create(companyDto);
    }
    @PostMapping("/verify")
    public void verifyCompanyAcount(@RequestBody VerifiedAccount verifiedAccount){

        companyService.verifyCompanyAccount(verifiedAccount);
    }

    @PutMapping("/update")
    public Optional<CompanyDto> updateCompany(@RequestBody CompanyDto companyDto){

        return companyService.update(companyDto);
    }

    @PostMapping("/login")
    public Optional<CompanyDto> login(@RequestBody CompanyDto companyDto){

        return companyService.login(companyDto);
    }
}
