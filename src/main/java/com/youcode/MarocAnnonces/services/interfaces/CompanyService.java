package com.youcode.MarocAnnonces.services.interfaces;

import com.youcode.MarocAnnonces.models.Dtos.CompanyDto.CompanyDto;
import com.youcode.MarocAnnonces.models.Entities.VerifiedAccount;

import java.util.Optional;

public interface CompanyService extends BaseService<CompanyDto>{
    void verifyCompanyAccount(VerifiedAccount verifiedAccount);

    Optional<CompanyDto> login(CompanyDto companyDto);
}
