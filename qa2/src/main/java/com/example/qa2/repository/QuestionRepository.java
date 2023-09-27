package com.example.qa2.repository;

import com.example.qa2.entity.Question;
import com.example.qa2.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuestionnaire(Questionnaire questionnaire);
}