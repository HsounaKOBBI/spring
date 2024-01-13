package com.hydatis.KycmicroserviceCQRS.command.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "AgentPersonneMorales")
public class AgentPersonneMorale extends Personne {

    @Id
    private Long numIdUnique;
    @Column(nullable = true)
    private String raisonSociale;
    @Column(nullable = true)
    private String matriculeFiscale;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = true)
    private LocalDate dateExtraitRNE;

    @Column(nullable = true)
    private Long codeDouane;

    @Column(nullable = true)
    private  String adresseSiégeSociale;
    @Column(nullable = true )
    private URL siteWeb;
    @Column(nullable = true)
    private String fax;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "compte_id")
    private Compte compte;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activite_id")
    private Activite activite;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "informations_id")
    private InformationsFinanciere informationsFinanciere;


    @ManyToMany
    @JoinTable(
            name = "PM_BANQUE_EN_RELATION",
            joinColumns = @JoinColumn(name = "personne_Morale_id"),
            inverseJoinColumns = @JoinColumn(name = "banque_id")
    )
    private List<Banque> banques;


    @OneToMany(mappedBy = "societesAffilees", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SocietesAffilees> societesAffilees ;



    @OneToMany(mappedBy = "agentPersonneMorale", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PersonnePhysique> personnePhysiqueBeneficaire ;

    @OneToMany(mappedBy = "societe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PersonnePhysique> personnePhysiqueActionneur ;



}


