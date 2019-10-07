package com.target.springQuizApp.repositories;

import com.target.springQuizApp.model.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<QuizQuestion, Long> {
}
