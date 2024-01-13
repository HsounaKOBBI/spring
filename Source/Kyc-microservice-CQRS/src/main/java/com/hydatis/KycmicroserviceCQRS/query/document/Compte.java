package com.hydatis.KycmicroserviceCQRS.query.document;

import com.hydatis.KycmicroserviceCQRS.command.model.enums.EtatDeCompte;
import com.hydatis.KycmicroserviceCQRS.command.model.enums.SourceAlimentation;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Compte {
    private Long idCompte;
    private String raison;
    @Enumerated(EnumType.STRING)
    private EtatDeCompte typeDeCompte;
    private Operation operationDebit;
    private Operation operationCredit;
}
