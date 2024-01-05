package com.youcode.MarocAnnonces.repositories;

import com.youcode.MarocAnnonces.models.Entities.Chercheur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChercheurRepository extends JpaRepository<Chercheur, Long> {
}
