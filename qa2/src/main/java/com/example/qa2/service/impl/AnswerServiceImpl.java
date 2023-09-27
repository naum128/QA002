package com.example.qa2.service.impl;

import com.example.qa2.entity.Answer;
import com.example.qa2.entity.Question;
import com.example.qa2.repository.AnswerRepository;
import com.example.qa2.repository.QuestionRepository;
import com.example.qa2.service.AnswerService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionRepository questionRepository;



    @Override
    public Answer createAnswer(String text, Long question) {
        Question question1 = questionRepository.findById(question).orElseThrow();
        Answer answer = new Answer();
        answer.setText(text);
        answer.setQuestion(question1);
        return answerRepository.save(answer);
    }
    @Override
    public List<Answer> getAnswersByQuestion(Question question) {
        return answerRepository.findByQuestion(question);
    }
    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + id));
    }
}