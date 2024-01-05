package com.youcode.MarocAnnonces.repositories;

import com.youcode.MarocAnnonces.models.Entities.VerifiedAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerifiedAccountRepository extends JpaRepository<VerifiedAccount, Long> {
    Optional<VerifiedAccount> findByEmail(String email);;
}
