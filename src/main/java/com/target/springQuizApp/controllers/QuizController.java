package com.target.springQuizApp.controllers;

import com.target.springQuizApp.exceptions.RestException;
import com.target.springQuizApp.model.QuizQuestion;
import com.target.springQuizApp.model.UserEntity;
import com.target.springQuizApp.repositories.QuestionRepository;
import com.target.springQuizApp.service.QuestionService;
import com.target.springQuizApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.target.springQuizApp.constants.QuizAppConstants.LOGGER_KO_EXCEPTION_PATTERN;
import static com.target.springQuizApp.constants.QuizAppConstants.LOGGER_OK_PATTERN;

@RestController
@Slf4j
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class QuizController {

    private final String LOG_OP_INFO = "QUIZ_CONTROLLER";

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/UserLoginData")
    UserEntity UserLoginData() {


        return userService.getUserData();
    }

    @GetMapping(path = "questions", produces = "application/json")
    public ResponseEntity<List<QuizQuestion>> getAllQuestions() throws RestException {
        try {
            List<QuizQuestion> list = questionService.getAllQuestion();
            log.info(LOGGER_OK_PATTERN, LOG_OP_INFO, "Successfully retrieved all questions from the database ");
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (RestException e) {
            log.error(LOGGER_KO_EXCEPTION_PATTERN, LOG_OP_INFO, "Error occurred while retrieving questions from the database ", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error(LOGGER_KO_EXCEPTION_PATTERN, LOG_OP_INFO, "Error occurred while retrieving questions from the database ", e);
            throw e;
        }

    }


}