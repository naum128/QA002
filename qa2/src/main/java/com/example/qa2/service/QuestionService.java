package com.example.qa2.service;

import com.example.qa2.entity.Question;
import com.example.qa2.entity.Questionnaire;

import java.util.List;

public interface QuestionService {
    Question createQuestion(String text, Questionnaire questionnaire);

    List<Question> getQuestionsByQuestionnaire(Questionnaire questionnaire);

    Question getQuestionById(Long id);
}