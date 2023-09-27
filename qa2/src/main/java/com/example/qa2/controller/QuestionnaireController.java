package com.example.qa2.controller;

import com.example.qa2.entity.Questionnaire;
import com.example.qa2.entity.TypeAnswer;
import com.example.qa2.repository.QuestionnaireRepository;
import com.example.qa2.service.impl.QuestionnaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questionnaire")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireServiceImpl questionnaireServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<?> createQuestionnaire(@RequestParam String text, @RequestParam TypeAnswer type) {
        Questionnaire newQuestionnaire = questionnaireServiceImpl.createQuestionnaire(text, type);
        return ResponseEntity.ok(newQuestionnaire);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Questionnaire>> getAllQuestionnaires() {
        List<Questionnaire> questionnaires = questionnaireServiceImpl.getAllQuestionnaires();
        return ResponseEntity.ok(questionnaires);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questionnaire> getQuestionnaireById(@PathVariable Long id) {
        Questionnaire questionnaire = questionnaireServiceImpl.getQuestionnaireById(id);
        return ResponseEntity.ok(questionnaire);
    }
    @DeleteMapping("/{id}")
    public void deleteQuestionnaire(@PathVariable Long id) {
        questionnaireServiceImpl.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestParam String title, @RequestParam TypeAnswer newType) {
        return ResponseEntity.ok(questionnaireServiceImpl.update(id, title, newType));
    }
}