package com.target.springQuizApp.integration;

import com.target.springQuizApp.model.QuizQuestion;
import com.target.springQuizApp.repositories.QuestionRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by z001hmh on 10/7/19.
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionRepositoryIntegrationTest {


    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void givenSetOfQuestions_whenFindAll_thenReturnAllQuestions() {

        List<QuizQuestion> allQuestions = questionRepository.findAll();

        Assertions.assertThat(allQuestions).hasSize(10).extracting(QuizQuestion::getQuestionId).contains(1l,2l,3l);
    }

}
