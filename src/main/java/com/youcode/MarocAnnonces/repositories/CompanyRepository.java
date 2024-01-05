package com.youcode.MarocAnnonces.repositories;

import com.youcode.MarocAnnonces.models.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndLogin(String email, String login);

    Optional<Company> findByEmail(String email);
    Optional<Company> findByEmailAndLogin(String email, String login);
}
