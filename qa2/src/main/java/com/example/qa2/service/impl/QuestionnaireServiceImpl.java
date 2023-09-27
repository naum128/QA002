package com.example.qa2.service.impl;

import com.example.qa2.entity.Questionnaire;
import com.example.qa2.entity.TypeAnswer;
import com.example.qa2.repository.QuestionnaireRepository;
import com.example.qa2.service.QuestionnaireService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    @Override
    public Questionnaire createQuestionnaire(String title, TypeAnswer type) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setTitle(title);
        questionnaire.setTypeAnswer(type);
        return questionnaireRepository.save(questionnaire);
    }
    @Override
    public List<Questionnaire> getAllQuestionnaires() {
        return questionnaireRepository.findAll();
    }
    @Override
    public Questionnaire getQuestionnaireById(Long id) {
        return questionnaireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Questionnaire not found with id: " + id));
    }

    @Override
    public void delete(Long id) {
        questionnaireRepository.deleteById(id);
    }

    @Override
    public Questionnaire update(Long id, String title, TypeAnswer newType) {
        Questionnaire questionnaire = questionnaireRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Lol"));
        questionnaire.setTitle(title);
        questionnaire.setTypeAnswer(newType);
        return questionnaire;
    }
}