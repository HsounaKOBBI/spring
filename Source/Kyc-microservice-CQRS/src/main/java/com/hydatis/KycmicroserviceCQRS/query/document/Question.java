package com.hydatis.KycmicroserviceCQRS.query.document;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question {
    private Long id;
    private String question;
    private String response;
}
