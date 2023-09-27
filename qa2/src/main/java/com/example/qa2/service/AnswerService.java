package com.example.qa2.service;

import com.example.qa2.entity.Answer;
import com.example.qa2.entity.Question;

import java.util.List;

public interface AnswerService {


    Answer createAnswer(String text, Long question);


    List<Answer> getAnswersByQuestion(Question question);

    Answer getAnswerById(Long id);
}
