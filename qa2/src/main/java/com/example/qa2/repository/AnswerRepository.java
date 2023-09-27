package com.example.qa2.repository;

import com.example.qa2.entity.Answer;
import com.example.qa2.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestion(Question question);
}