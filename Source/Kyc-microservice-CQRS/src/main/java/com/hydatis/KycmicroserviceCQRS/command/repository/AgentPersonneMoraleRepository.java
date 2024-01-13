package com.hydatis.KycmicroserviceCQRS.command.repository;

import com.hydatis.KycmicroserviceCQRS.command.model.AgentPersonneMorale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AgentPersonneMoraleRepository extends JpaRepository<AgentPersonneMorale,Long> {
}