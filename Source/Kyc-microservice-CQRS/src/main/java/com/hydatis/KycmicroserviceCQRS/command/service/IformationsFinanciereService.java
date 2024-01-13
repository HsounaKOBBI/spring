package com.hydatis.KycmicroserviceCQRS.command.service;

import com.hydatis.KycmicroserviceCQRS.command.model.Banque;
import com.hydatis.KycmicroserviceCQRS.command.model.InformationsFinanciere;
import com.hydatis.KycmicroserviceCQRS.command.model.Question;
import com.hydatis.KycmicroserviceCQRS.command.repository.InformationsFinanciereRepository;
import com.hydatis.KycmicroserviceCQRS.command.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IformationsFinanciereService {
    private final InformationsFinanciereRepository informationsFinanciereRepository;
    private final QuestionRepository questionRepository ;

    public IformationsFinanciereService(InformationsFinanciereRepository informationsFinanciereRepository, QuestionRepository questionRepository) {
        this.informationsFinanciereRepository = informationsFinanciereRepository;
        this.questionRepository = questionRepository;
    }

    public InformationsFinanciere save(InformationsFinanciere informationsFinanciere){
        List<Question> questions =informationsFinanciere.getResponses();


        for (Question question : questions) {
            question  = questionRepository.save(question);
        }

        informationsFinanciere.setResponses(questions);
        return informationsFinanciereRepository.save(informationsFinanciere);
    }
    public List<InformationsFinanciere> findAll(){
        return informationsFinanciereRepository.findAll();
    }
}
