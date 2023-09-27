package com.example.qa2.service;

import com.example.qa2.entity.Questionnaire;
import com.example.qa2.entity.TypeAnswer;

import java.util.List;

public interface QuestionnaireService {
    Questionnaire createQuestionnaire(String title, TypeAnswer type);

    List<Questionnaire> getAllQuestionnaires();

    Questionnaire getQuestionnaireById(Long id);

    void delete(Long id);

    Questionnaire update(Long id, String title, TypeAnswer newType);
}