package com.example.qa2.service;

import com.example.qa2.entity.Questionnaire;
import com.example.qa2.entity.User;
import com.example.qa2.entity.UserQuestionnaire;

import java.util.List;

public interface UserQuestionnaireService {
    UserQuestionnaire createUserQuestionnaire(User user, Questionnaire questionnaire);

    List<UserQuestionnaire> getUserQuestionnairesByUser(User user);

    UserQuestionnaire getUserQuestionnaireById(Long id);
}