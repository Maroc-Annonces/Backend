package com.youcode.MarocAnnonces.repositories;

import com.youcode.MarocAnnonces.models.Entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long>{
}
