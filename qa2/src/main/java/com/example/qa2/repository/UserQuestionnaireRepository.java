package com.example.qa2.repository;

import com.example.qa2.entity.User;
import com.example.qa2.entity.UserQuestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserQuestionnaireRepository extends JpaRepository<UserQuestionnaire, Long> {
    List<UserQuestionnaire> findByUser(User user);
}
