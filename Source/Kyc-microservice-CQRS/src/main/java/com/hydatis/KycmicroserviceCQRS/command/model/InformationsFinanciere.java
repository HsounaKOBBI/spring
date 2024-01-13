package com.hydatis.KycmicroserviceCQRS.command.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table
public class InformationsFinanciere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double capitalSociete;
    private Double chiffreAffaireTotal;
    private Double TotalPassif;
    private Double TotalActif;
    private Double resultatNet;
    private  String compteInf;
    @OneToMany(cascade=CascadeType.ALL )
    private List<Question> responses;




}
