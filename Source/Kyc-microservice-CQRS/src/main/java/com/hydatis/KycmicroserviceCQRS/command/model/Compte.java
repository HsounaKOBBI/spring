package com.hydatis.KycmicroserviceCQRS.command.model;
import com.hydatis.KycmicroserviceCQRS.command.model.enums.EtatDeCompte;
import com.hydatis.KycmicroserviceCQRS.command.model.enums.SourceAlimentation;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "comptes")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;
    private String raison;


    @Enumerated(EnumType.STRING)
    private EtatDeCompte typeDeCompte;

    @OneToOne(cascade = CascadeType.ALL)
    private Operation operationDebit;

    @OneToOne(cascade = CascadeType.ALL)
    private Operation operationCredit;
    @OneToOne(mappedBy = "compte",cascade = CascadeType.ALL)

    private AgentPersonnePhysique titulaire;

}
