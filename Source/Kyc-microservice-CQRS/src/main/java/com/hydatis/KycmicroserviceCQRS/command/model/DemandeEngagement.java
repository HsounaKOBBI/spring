package com.hydatis.KycmicroserviceCQRS.command.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table

public class DemandeEngagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long ID ;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private LocalDateTime dateDemande;
    int fraudScore ;


    @OneToOne
    private Decision decision;
    @OneToOne
    private  AgentPersonnePhysique agentPersonnePhysique;
    @OneToOne
    private  AgentPersonneMorale agentPersonneMorale;


}
