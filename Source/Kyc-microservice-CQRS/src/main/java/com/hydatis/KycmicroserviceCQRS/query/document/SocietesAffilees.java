package com.hydatis.KycmicroserviceCQRS.query.document;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SocietesAffilees {
    private  String nomSocietesAffilees;
    private String secteurActivite;
    private Double pourcentageCapitalDetenu;
}
