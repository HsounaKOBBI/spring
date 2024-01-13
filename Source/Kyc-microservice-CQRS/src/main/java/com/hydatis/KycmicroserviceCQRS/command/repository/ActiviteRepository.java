package com.hydatis.KycmicroserviceCQRS.command.repository;

import com.hydatis.KycmicroserviceCQRS.command.model.Activite;
import com.hydatis.KycmicroserviceCQRS.command.model.AgentPersonneMorale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActiviteRepository extends JpaRepository<Activite,Long> {
}