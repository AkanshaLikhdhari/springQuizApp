package com.target.springQuizApp.service;

import com.target.springQuizApp.model.QuizQuestion;
import com.target.springQuizApp.repositories.QuestionRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<QuizQuestion> getAllQuestion() {
        return questionRepository.findAll();
    }
}