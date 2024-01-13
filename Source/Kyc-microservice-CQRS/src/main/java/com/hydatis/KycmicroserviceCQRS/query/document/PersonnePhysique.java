package com.hydatis.KycmicroserviceCQRS.query.document;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonnePhysique {
    private Integer id;
    private String nomPrenom;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateDeNaissance;
    private String nationalite;
    private String payResidence;
    private String adressePerso;
    private Long numCIN;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateEmissionCIN;
    private String  lieuEmissionCIN;
    private Double pourcentageCapitalDetenu;
    private AgentPersonneMorale societe;
    private AgentPersonneMorale agentPersonneMorale;
}
