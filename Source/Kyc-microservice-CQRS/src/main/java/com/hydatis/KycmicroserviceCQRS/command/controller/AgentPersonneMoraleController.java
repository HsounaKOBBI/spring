package com.hydatis.KycmicroserviceCQRS.command.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hydatis.KycmicroserviceCQRS.command.model.AgentPersonneMorale;
import com.hydatis.KycmicroserviceCQRS.command.service.AgentPersonneMoraleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/pm")
public class AgentPersonneMoraleController {
    @Autowired
    private AgentPersonneMoraleService agentPersonneMoraleService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public AgentPersonneMorale save(@RequestBody  AgentPersonneMorale agentPersonneMorale) throws JsonProcessingException {
        return agentPersonneMoraleService.save(agentPersonneMorale);
    }
    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<AgentPersonneMorale> findAll(){
        return agentPersonneMoraleService.findAll();
    }

    @PutMapping("/update")
    public AgentPersonneMorale updateAgent(@RequestBody AgentPersonneMorale agentPersonneMorale) {
        return  agentPersonneMoraleService.update(agentPersonneMorale);
    }

    @DeleteMapping("/delete/{id}")
    public AgentPersonneMorale deleteAgent(@PathVariable("id") Long id) {
        return agentPersonneMoraleService.delete(id);

    }

}
