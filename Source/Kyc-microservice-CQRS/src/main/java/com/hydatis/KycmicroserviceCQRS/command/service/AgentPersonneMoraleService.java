package com.hydatis.KycmicroserviceCQRS.command.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hydatis.KycmicroserviceCQRS.command.eventhandler.implementation.AgentPersonneMoraleEventHandler;
import com.hydatis.KycmicroserviceCQRS.command.model.*;
import com.hydatis.KycmicroserviceCQRS.command.repository.*;
import com.hydatis.KycmicroserviceCQRS.events.CreateEvent;
import com.hydatis.KycmicroserviceCQRS.events.DeleteEvent;
import com.hydatis.KycmicroserviceCQRS.events.Event;
import com.hydatis.KycmicroserviceCQRS.events.UpdateEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentPersonneMoraleService {
    private final AgentPersonneMoraleRepository agentPersonneMoraleRepository;
    private final CompteRepository compteRepository;
    private final ActiviteRepository activiteRepository;
    private final InformationsFinanciereRepository informationsFinanciereRepository;
    private final BanqueRepository banqueRepository;
    private final SocietesAffileesRepository societesAffileesRepository;
    private final PersonnePhysiqueRepository personnePhysiqueBeneficaireRepository;
    private final PersonnePhysiqueRepository personnePhysiqueRepository;

    private final ObjectMapper objectMapper ;
    private final AgentPersonneMoraleEventHandler eventHandler;

    public AgentPersonneMoraleService(AgentPersonneMoraleRepository agentPersonneMoraleRepository, CompteRepository compteRepository, ActiviteRepository activiteRepository, InformationsFinanciereRepository informationsFinanciereRepository, BanqueRepository banqueRepository, SocietesAffileesRepository societesAffileesRepository, PersonnePhysiqueRepository personnePhysiqueBeneficaireRepository, PersonnePhysiqueRepository personnePhysiqueActionneurRepository, PersonnePhysiqueRepository personnePhysiqueRepository, ObjectMapper objectMapper, AgentPersonneMoraleEventHandler eventHandler) {
        this.agentPersonneMoraleRepository = agentPersonneMoraleRepository;
        this.compteRepository=compteRepository;
        this.activiteRepository = activiteRepository;
        this.informationsFinanciereRepository = informationsFinanciereRepository;
        this.banqueRepository = banqueRepository;
        this.societesAffileesRepository = societesAffileesRepository;
        this.personnePhysiqueBeneficaireRepository = personnePhysiqueBeneficaireRepository;
        this.personnePhysiqueRepository = personnePhysiqueRepository;
        this.objectMapper = objectMapper;
        this.eventHandler = eventHandler;
    }

    public AgentPersonneMorale save(AgentPersonneMorale agentPersonneMorale) throws JsonProcessingException {
        System.out.println(agentPersonneMorale);




        Compte compte=agentPersonneMorale.getCompte();
        Activite activite=agentPersonneMorale.getActivite();
        InformationsFinanciere informationsFinanciere=agentPersonneMorale.getInformationsFinanciere();
        List<Banque> banques =agentPersonneMorale.getBanques();
        List<SocietesAffilees> societesAffilees =agentPersonneMorale.getSocietesAffilees();
        List<PersonnePhysique> personnePhysiquesBenificiaires = agentPersonneMorale.getPersonnePhysiqueBeneficaire();
        List<PersonnePhysique> personnePhysiquesActionneurs = agentPersonneMorale.getPersonnePhysiqueActionneur();


        compte=compteRepository.save(compte);
        activite=activiteRepository.save(activite);
        informationsFinanciere=informationsFinanciereRepository.save(informationsFinanciere);
        for (Banque banque : banques) {
            banque = banqueRepository.save(banque);
        }
        for (SocietesAffilees societesAffilee : societesAffilees) {
            societesAffilee = societesAffileesRepository.save(societesAffilee);
        }
        for (PersonnePhysique personnePhysiqueBenificiaire : personnePhysiquesBenificiaires) {
            personnePhysiqueBenificiaire = personnePhysiqueRepository.save(personnePhysiqueBenificiaire);
        }
        for (PersonnePhysique personnePhysiqueActionneur : personnePhysiquesActionneurs) {
            personnePhysiqueActionneur = personnePhysiqueRepository.save(personnePhysiqueActionneur);
        }




        agentPersonneMorale.setCompte(compte);
        agentPersonneMorale.setActivite(activite);
        agentPersonneMorale.setInformationsFinanciere(informationsFinanciere);
        agentPersonneMorale.setBanques(banques);
        agentPersonneMorale.setSocietesAffilees(societesAffilees);
        agentPersonneMorale.setPersonnePhysiqueBeneficaire(personnePhysiquesBenificiaires);
        agentPersonneMorale.setPersonnePhysiqueActionneur(personnePhysiquesActionneurs);

        AgentPersonneMorale entity=agentPersonneMoraleRepository.save(agentPersonneMorale);
        System.out.println("in command saved AgentPp" + objectMapper.writeValueAsString(entity));
        Event<AgentPersonneMorale> createEvent = new CreateEvent<>(entity);

        eventHandler.publish(createEvent);

        return entity;
    }
    public List<AgentPersonneMorale> findAll(){
        return agentPersonneMoraleRepository.findAll();
    }
    public AgentPersonneMorale update(AgentPersonneMorale entity) {
        try{
            if(agentPersonneMoraleRepository.findById(entity.getNumIdUnique()).isPresent()) {
                AgentPersonneMorale agentPersonneMorale = agentPersonneMoraleRepository.save(entity);
                Event<AgentPersonneMorale> updateEvent = new UpdateEvent<>(agentPersonneMorale);
                eventHandler.publish(updateEvent);
                return agentPersonneMorale;
            }
            else return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public AgentPersonneMorale delete(Long id) {
        try{
            Optional<AgentPersonneMorale> agentPersonneMorale = agentPersonneMoraleRepository.findById(id);
            if (agentPersonneMorale.isPresent()) {
                agentPersonneMoraleRepository.deleteById(id);
                Event<AgentPersonneMorale> deleteEvent = new DeleteEvent<>(agentPersonneMorale.get());
                eventHandler.publish(deleteEvent);
                return agentPersonneMorale.get();
            } else return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
