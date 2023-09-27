package com.example.qa2.controller;

import com.example.qa2.entity.Answer;
import com.example.qa2.entity.Question;
import com.example.qa2.repository.AnswerRepository;
import com.example.qa2.service.AnswerService;
import com.example.qa2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerServiceImpl;
    @Autowired
    private QuestionService questionServiceImpl;

    @PostMapping
    public ResponseEntity<?> createAnswer(@RequestParam String text, @RequestParam Long question) {
        Answer answer = answerServiceImpl.createAnswer(text, question);
        return ResponseEntity.ok(answer);
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<?> getAnswersByQuestion(@PathVariable Long questionId) {
        Question question = questionServiceImpl.getQuestionById(questionId);
        List<Answer> answers = answerServiceImpl.getAnswersByQuestion(question);
        return ResponseEntity.ok(answers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnswerById(@PathVariable Long id) {
        Answer answer = answerServiceImpl.getAnswerById(id);
        return ResponseEntity.ok(answer);
    }

}