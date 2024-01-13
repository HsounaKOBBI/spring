package com.hydatis.KycmicroserviceCQRS.command.repository;

import com.hydatis.KycmicroserviceCQRS.command.model.Activite;
import com.hydatis.KycmicroserviceCQRS.command.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OperationsRepository extends JpaRepository<Operation,Long> {
}