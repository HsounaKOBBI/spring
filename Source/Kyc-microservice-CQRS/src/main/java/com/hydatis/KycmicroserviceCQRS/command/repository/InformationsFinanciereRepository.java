package com.hydatis.KycmicroserviceCQRS.command.repository;

import com.hydatis.KycmicroserviceCQRS.command.model.Activite;
import com.hydatis.KycmicroserviceCQRS.command.model.InformationsFinanciere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InformationsFinanciereRepository extends JpaRepository<InformationsFinanciere,Long> {
}