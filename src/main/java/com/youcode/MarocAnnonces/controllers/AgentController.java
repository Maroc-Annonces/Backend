package com.youcode.MarocAnnonces.controllers;

import com.youcode.MarocAnnonces.models.Dtos.AgentDto.AgentDto;
import com.youcode.MarocAnnonces.services.interfaces.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@CrossOrigin("*")
@RequestMapping("/api/v1/agents")
public class AgentController {
    private  final AgentService agentService;
    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }
    @GetMapping
    public List<AgentDto> getAllAgents(){

        return agentService.getAllAgents();
    }
    @GetMapping("/{id}")
    public Optional<AgentDto> getAgentById(@PathVariable Long id){

        return agentService.getById(id);
    }
    @PostMapping("/create")
    public Optional<AgentDto> createAgent(@RequestBody AgentDto agentDto){

        return agentService.create(agentDto);
    }
    @PutMapping("/update")
    public Optional<AgentDto> updateAgent(@RequestBody AgentDto agentDto){

        return agentService.update(agentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAgentById(@PathVariable Long id){
        agentService.deleteById(id);
    }
}
