package com.hydatis.KycmicroserviceCQRS.command.service;

import com.hydatis.KycmicroserviceCQRS.command.model.Activite;
import com.hydatis.KycmicroserviceCQRS.command.model.Banque;
import com.hydatis.KycmicroserviceCQRS.command.repository.ActiviteRepository;
import com.hydatis.KycmicroserviceCQRS.command.repository.BanqueRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BanqueService {
    private final BanqueRepository banqueRepository;


    public BanqueService(BanqueRepository banqueRepository) {
        this.banqueRepository = banqueRepository;
    }

    public Banque save(Banque banque){
        return banqueRepository.save(banque);
    }
    public List<Banque> findAll(){
        return banqueRepository.findAll();
    }
}
