package com.example.qa2.controller;

import com.example.qa2.entity.Questionnaire;
import com.example.qa2.entity.User;
import com.example.qa2.entity.UserQuestionnaire;
import com.example.qa2.repository.UserQuestionnaireRepository;
import com.example.qa2.service.impl.QuestionnaireServiceImpl;
import com.example.qa2.service.impl.UserQuestionnaireServiceImpl;
import com.example.qa2.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-questionnaires")
public class UserQuestionnaireController {
    @Autowired
    private UserQuestionnaireServiceImpl userQuestionnaireServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private QuestionnaireServiceImpl questionnaireServiceImpl;

    @PostMapping
    public ResponseEntity<UserQuestionnaire> createUserQuestionnaire(@RequestParam User user, @RequestParam Questionnaire questionnaire,
                                                                     @RequestBody UserQuestionnaire userQuestionnaire) {
        User newUser = userServiceImpl.getUserById(user.getId());
        Questionnaire newQuestionnaire = questionnaireServiceImpl.getQuestionnaireById(questionnaire.getId());
        UserQuestionnaire newUserQuestionnaire = userQuestionnaireServiceImpl.createUserQuestionnaire(newUser, newQuestionnaire);
        return ResponseEntity.ok(newUserQuestionnaire);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserQuestionnaire>> getUserQuestionnairesByUser(@PathVariable Long userId) {
        User user = userServiceImpl.getUserById(userId);
        List<UserQuestionnaire> userQuestionnaires = userQuestionnaireServiceImpl.getUserQuestionnairesByUser(user);
        return  ResponseEntity.ok(userQuestionnaires);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserQuestionnaire> getUserQuestionnaireById(@PathVariable Long id) {
        UserQuestionnaire userQuestionnaire = userQuestionnaireServiceImpl.getUserQuestionnaireById(id);
        return ResponseEntity.ok(userQuestionnaire);
    }
}