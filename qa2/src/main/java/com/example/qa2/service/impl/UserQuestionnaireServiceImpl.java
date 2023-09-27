package com.example.qa2.service.impl;

import com.example.qa2.entity.Questionnaire;
import com.example.qa2.entity.User;
import com.example.qa2.entity.UserQuestionnaire;
import com.example.qa2.repository.UserQuestionnaireRepository;
import com.example.qa2.service.UserQuestionnaireService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserQuestionnaireServiceImpl implements UserQuestionnaireService {
    @Autowired
    private UserQuestionnaireRepository userQuestionnaireRepository;
    @Override
    public UserQuestionnaire createUserQuestionnaire(User user, Questionnaire questionnaire) {
        UserQuestionnaire userQuestionnaire = new UserQuestionnaire();
        userQuestionnaire.setUser(user);
        userQuestionnaire.setQuestionnaire(questionnaire);
        return userQuestionnaireRepository.save(userQuestionnaire);
    }
    @Override
    public List<UserQuestionnaire> getUserQuestionnairesByUser(User user) {
        return userQuestionnaireRepository.findByUser(user);
    }
    @Override
    public UserQuestionnaire getUserQuestionnaireById(Long id) {
        return userQuestionnaireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserQuestionnaire not found with id: " + id));
    }

}