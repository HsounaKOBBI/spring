package com.hydatis.KycmicroserviceCQRS.command.service;

import com.hydatis.KycmicroserviceCQRS.command.model.Activite;
import com.hydatis.KycmicroserviceCQRS.command.model.SocietesAffilees;
import com.hydatis.KycmicroserviceCQRS.command.repository.SocietesAffileesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocietesAffileesService {
    private final SocietesAffileesRepository societesAffileesRepository;


    public SocietesAffileesService(SocietesAffileesRepository societesAffileesRepository, SocietesAffileesRepository societesAffileesRepository1) {
        this.societesAffileesRepository = societesAffileesRepository1;
    }

    public SocietesAffilees save(SocietesAffilees societesAffilees){
        return societesAffileesRepository.save(societesAffilees);
    }
    public List<SocietesAffilees> findAll(){
        return societesAffileesRepository.findAll();
    }
}
