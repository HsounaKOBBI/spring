package com.hydatis.KycmicroserviceCQRS.command.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "AgentPersonnePhysiques")
public class AgentPersonnePhysique extends Personne{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dateDeNaissance;
    private String adressePerso;
    private String addresseCourier;
    private Boolean estPPE;
    private String fonctionPpe;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "compte_id")
    private Compte compte;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "document_id")
    private Document document;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categorie_socio_pro_id")
    private CategorieSocioProfesionnelle categorieSocioProfesionnelle;
    private Boolean estBeneficiareEffectifs;

    @OneToOne(optional = true)
    private AgentPersonnePhysique beneficiaireEffectifs;

    @OneToOne(mappedBy ="beneficiaireEffectifs",optional = true)
    private AgentPersonnePhysique titulaireDuCompte;

    @ManyToMany
    @JoinTable(
            name = "PP_BANQUE_EN_RELATION",
            joinColumns = @JoinColumn(name = "personne_physique_id"),
            inverseJoinColumns = @JoinColumn(name = "banque_id")
    )
    private List<Banque> banqueEnRelation;
}
