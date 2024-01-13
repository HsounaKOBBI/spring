package com.hydatis.KycmicroserviceCQRS.command.service;

import com.hydatis.KycmicroserviceCQRS.command.model.Activite;
import com.hydatis.KycmicroserviceCQRS.command.model.Banque;
import com.hydatis.KycmicroserviceCQRS.command.model.Produit;
import com.hydatis.KycmicroserviceCQRS.command.repository.ActiviteRepository;
import com.hydatis.KycmicroserviceCQRS.command.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiviteService {
    private final ActiviteRepository activiteRepository;
    private final ProduitRepository produitRepository;

    public ActiviteService(ActiviteRepository activiteRepository, ProduitRepository produitRepository) {
        this.activiteRepository = activiteRepository;
        this.produitRepository = produitRepository;
    }

    public Activite save(Activite activite){

        List<Produit> produits = activite.getProduits();
        for (Produit produit : produits) {
            produit = produitRepository.save(produit);
        }

        activite.setProduits(produits);
        return activiteRepository.save(activite);
    }
    public List<Activite> findAll(){
        return activiteRepository.findAll();
    }
}
