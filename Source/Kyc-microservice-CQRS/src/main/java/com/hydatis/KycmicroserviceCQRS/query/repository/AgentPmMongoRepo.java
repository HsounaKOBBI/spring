package com.hydatis.KycmicroserviceCQRS.query.repository;


import com.hydatis.KycmicroserviceCQRS.query.document.AgentPersonneMorale;
import com.hydatis.KycmicroserviceCQRS.query.document.AgentPersonnePhysique;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AgentPmMongoRepo extends MongoRepository<AgentPersonneMorale,Long> {
    Optional<AgentPersonneMorale> findById(Long numIdUnique
    );
}