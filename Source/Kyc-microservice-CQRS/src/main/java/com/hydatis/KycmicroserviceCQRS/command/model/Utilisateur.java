package com.hydatis.KycmicroserviceCQRS.command.model;
import lombok.*;

import javax.persistence.*;


@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Utilisateur {


    private String username ;
    private String password ;
    private String email ;

}


