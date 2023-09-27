package com.example.qa2.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description", nullable = false)
    private String text;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    public Answer(){}

    public Answer(Long id,  String text, Question question) {

        this.text = text;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}