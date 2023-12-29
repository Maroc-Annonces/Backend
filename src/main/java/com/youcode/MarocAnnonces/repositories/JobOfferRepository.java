package com.youcode.MarocAnnonces.repositories;

import com.youcode.MarocAnnonces.models.Entities.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {
}
