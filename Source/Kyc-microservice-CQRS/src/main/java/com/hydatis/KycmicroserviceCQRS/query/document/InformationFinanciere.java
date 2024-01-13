package com.hydatis.KycmicroserviceCQRS.query.document;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InformationFinanciere {
    private Integer id;

    private Double capitalSociete;
    private Double chiffreAffaireTotal;
    private Double TotalPassif;
    private Double resultatNet;
    private Double TotalActif;
    private  String compteInf;
    private List<Question> responses;

}
