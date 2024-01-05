package com.youcode.MarocAnnonces.repositories;

import com.youcode.MarocAnnonces.models.Entities.Postulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulationRepository  extends JpaRepository<Postulation, Long> {
}
