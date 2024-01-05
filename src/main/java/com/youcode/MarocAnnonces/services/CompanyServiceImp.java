package com.youcode.MarocAnnonces.services;

import com.youcode.MarocAnnonces.exceptions.ApiRequestException;
import com.youcode.MarocAnnonces.models.Dtos.CompanyDto.CompanyDto;
import com.youcode.MarocAnnonces.models.Entities.Company;
import com.youcode.MarocAnnonces.models.Entities.VerifiedAccount;
import com.youcode.MarocAnnonces.repositories.CompanyRepository;
import com.youcode.MarocAnnonces.repositories.VerifiedAccountRepository;
import com.youcode.MarocAnnonces.services.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
@Service
public class CompanyServiceImp implements CompanyService{
    private final CompanyRepository companyRepository;
    private final EmailService emailService;
    private final ModelMapper modelMapper;
    private final VerifiedAccountRepository verifiedAccountRepository;

    @Autowired
    public CompanyServiceImp(CompanyRepository companyRepository, EmailService emailService, ModelMapper modelMapper, VerifiedAccountRepository verifiedAccountRepository) {
        this.companyRepository = companyRepository;
        this.emailService = emailService;
        this.modelMapper = modelMapper;
        this.verifiedAccountRepository = verifiedAccountRepository;
    }

    @Override
    public List<CompanyDto> getAll() {

        List<Company> companies  = companyRepository.findAll();

        return companies.stream()
                .map(Company -> modelMapper.map(Company, CompanyDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CompanyDto> getById(Long id) {

        Company company = companyRepository.findById(id).orElse(null);

        return Optional.ofNullable(modelMapper.map(company, CompanyDto.class));
    }

    @Override
    public Optional<CompanyDto> create(CompanyDto item) {

        if(companyRepository.existsByEmail(item.getEmail())){
            throw new ApiRequestException("Email already exists");
        }

        Company company = modelMapper.map(item, Company.class);
        company.setVerified(false);
        Company savedCompany = companyRepository.save(company);

        long code = generateRandomCode();

        emailService.sendEmail(item.getEmail(),
                "Validation code",
                "Your validation code is: " + code);

        VerifiedAccount verifiedAccount = new VerifiedAccount();
        verifiedAccount.setCode(code);
        verifiedAccount.setExpiredAt(LocalDateTime.now().plusMinutes(3));
        verifiedAccount.setEmail(company.getEmail());

        verifiedAccountRepository.save(verifiedAccount);

        return Optional.ofNullable(modelMapper.map(savedCompany, CompanyDto.class));
    }

    private long generateRandomCode() {
        return ThreadLocalRandom.current().nextLong(100000, 999999);
    }

    @Override
    public void verifyCompanyAccount(VerifiedAccount verifiedAccount) {

        VerifiedAccount verifiedAccountOptional = verifiedAccountRepository.findByEmail(verifiedAccount.getEmail()).
                orElseThrow(() -> new ApiRequestException("Email not found or already verified"));

        Company notVerifiedCompanyAccount = companyRepository.findByEmail(verifiedAccount.getEmail()).
                orElseThrow(() -> new ApiRequestException("Email not found, please sign up first"));

        LocalDateTime  expiredTime = verifiedAccountOptional.getExpiredAt();
        LocalDateTime startTimestamp = LocalDateTime.now();

        if(startTimestamp.isAfter(expiredTime)){

            verifiedAccountRepository.delete(verifiedAccountOptional);
            companyRepository.delete(notVerifiedCompanyAccount);

            throw new ApiRequestException("The code is expired, try signing up again");
        }

        if(verifiedAccountOptional.getCode() != verifiedAccount.getCode()){

            throw new ApiRequestException("The code is not correct");
        }else{
            verifiedAccountRepository.delete(verifiedAccountOptional);
            notVerifiedCompanyAccount.setVerified(true);
            companyRepository.save(notVerifiedCompanyAccount);

            throw new ApiRequestException("Your account is verified successfully");
        }
    }

    @Override
    public Optional<CompanyDto> login(CompanyDto companyDto) {

        if(companyRepository.existsByEmailAndLogin(companyDto.getEmail(),companyDto.getLogin())){
            Company company = companyRepository.findByEmailAndLogin(companyDto.getEmail(),companyDto.getLogin()).orElse(null);
            return Optional.ofNullable(modelMapper.map(company, CompanyDto.class));
        }else{
            throw new ApiRequestException("Email or login is not correct");
        }
    }

    @Override
    public Optional<CompanyDto> update(CompanyDto item) {

        Company company = modelMapper.map(item, Company.class);
        Company savedCompany = companyRepository.save(company);

        return Optional.ofNullable(modelMapper.map(savedCompany, CompanyDto.class));
    }
    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

}
