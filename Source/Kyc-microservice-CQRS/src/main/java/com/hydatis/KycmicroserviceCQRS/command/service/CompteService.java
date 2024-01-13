package com.hydatis.KycmicroserviceCQRS.command.service;

import com.hydatis.KycmicroserviceCQRS.command.model.Compte;
import com.hydatis.KycmicroserviceCQRS.command.model.Operation;
import com.hydatis.KycmicroserviceCQRS.command.repository.CompteRepository;
import com.hydatis.KycmicroserviceCQRS.command.repository.OperationsRepository;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.util.List;

@Service
public class CompteService {
    private final CompteRepository compteRepository;
    private final OperationsRepository operationsRepository;

    public CompteService(CompteRepository compteRepository, OperationsRepository operationsRepository) {
        this.compteRepository = compteRepository;
        this.operationsRepository = operationsRepository;
    }

    public Compte save(Compte compte){
        Operation operationDebit = compte.getOperationDebit();
        Operation operationCredit = compte.getOperationCredit();

        operationsRepository.save(operationCredit);
        operationsRepository.save(operationDebit);




        return compteRepository.save(compte);
    }
    public List<Compte> findAll(){
        return compteRepository.findAll();
    }
}
