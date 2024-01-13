package com.hydatis.KycmicroserviceCQRS.query.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;





import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@org.springframework.data.mongodb.core.mapping.Document

public class AgentPersonneMorale {
    @Indexed(unique = true)
    private Long numIdUnique;
    private String nationalite;
    private String residence;
    private Boolean estResident;
    private String telephone;
    private String email;
    private String raisonSociale;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateExtraitRNE;
    private String matriculeFiscale;
    private Long codeDouane;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreation;
    private  String adresseSiégeSociale;
    private URL siteWeb;
    private String fax;
    private List<PersonnePhysique> personnePhysiqueBeneficaire;
    private Compte compte;
    private List<Banque> banques;
    private Activite activite;
    private InformationFinanciere informationFinanciere;
    private List<SocietesAffilees> societesAffilees;
    private List<PersonnePhysique> personnePhysiqueActionneur;

    

}
