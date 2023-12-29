package com.youcode.MarocAnnonces.services.interfaces;

import com.youcode.MarocAnnonces.models.Dtos.AgentDto.AgentDto;

import java.util.List;

public interface AgentService extends BaseService<AgentDto>{
    List<AgentDto> getAllAgents();
}
