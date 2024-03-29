package com.hydatis.KycmicroserviceCQRS.command.repository;

import com.hydatis.KycmicroserviceCQRS.command.model.AgentPersonneMorale;
import com.hydatis.KycmicroserviceCQRS.command.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompteRepository extends JpaRepository<Compte,Long> {
}