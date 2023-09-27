package com.example.qa2.controller;

import com.example.qa2.entity.Question;
import com.example.qa2.entity.Questionnaire;
import com.example.qa2.repository.QuestionRepository;
import com.example.qa2.repository.QuestionnaireRepository;
import com.example.qa2.service.impl.QuestionServiceImpl;
import com.example.qa2.service.impl.QuestionnaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionServiceImpl;
    @Autowired
    private QuestionnaireServiceImpl questionnaireServiceImpl;
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @PostMapping("/new")
    public ResponseEntity<?> createQuestion(@RequestParam String text, @RequestParam Long questionnaireId) {
        Questionnaire questionnaire = questionnaireRepository.findById(questionnaireId).orElseThrow(()-> new NoSuchElementException("Not found"));
        Question question = questionServiceImpl.createQuestion(text, questionnaire);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/questionnaire/{questionnaireId}")
    public ResponseEntity<List<Question>> getQuestionsByQuestionnaire(@PathVariable Long questionnaireId) {
        Questionnaire questionnaire = questionnaireServiceImpl.getQuestionnaireById(questionnaireId);
        List<Question> questions = questionServiceImpl.getQuestionsByQuestionnaire(questionnaire);
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = questionServiceImpl.getQuestionById(id);
        return ResponseEntity.ok(question);
    }
}