package com.target.springQuizApp.integration;


import com.target.springQuizApp.controllers.QuizController;
import com.target.springQuizApp.model.QuizOption;
import com.target.springQuizApp.model.QuizQuestion;
import com.target.springQuizApp.model.UserEntity;
import com.target.springQuizApp.service.QuestionService;
import com.target.springQuizApp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(QuizController.class)


public class QuizControllerTest {


    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    QuestionService questionService;

    @Test
    public void quizControllertTest() throws Exception {

        when(userService.getUserData()).thenReturn(new UserEntity(1,"akansha@gmail.com", "121"));

        List<QuizOption> option = Arrays.asList(new QuizOption(1, "If we derive an abstract class and do not implement all the abstract methods, then the derived class should also be marked as abstract using abstract keyword", 1),
                new QuizOption(2, "Abstract classes can have constructors", 1), new QuizOption(3, "A class can be made abstract without any abstract method", 1), new QuizOption(4, "A class can inherit from multiple abstract classes", 1));
        List<QuizQuestion> questions = Arrays.asList(new QuizQuestion(1, "Which of the following is FALSE about abstract classes in Java", 4, option, null));
        when(questionService.getAllQuestion()).thenReturn(questions);


        RequestBuilder request = MockMvcRequestBuilders.get("/UserLoginData").accept(MediaType.APPLICATION_JSON);
        RequestBuilder request1 = MockMvcRequestBuilders.get("/questions").accept(MediaType.APPLICATION_JSON);


        MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().json("{\"id\":1,\"username\":\"akansha@gmail.com\",\"password\":\"121\"}")).andReturn();

        MvcResult mvcResult1 = mockMvc.perform(request1).andReturn();

        JSONAssert.assertEquals("[{\"questionId\":1,\"questionDescription\":\"Which of the following is FALSE about abstract classes in Java\",\"correctOptionId\":4,\"quizOption\":[{\"optionId\":1,\"optionDescription\":\"If we derive an abstract class and do not implement all the abstract methods, then the derived class should also be marked as abstract using abstract keyword\",\"questionId\":1},{\"optionId\":2,\"optionDescription\":\"Abstract classes can have constructors\",\"questionId\":1},{\"optionId\":3,\"optionDescription\":\"A class can be made abstract without any abstract method\",\"questionId\":1},{\"optionId\":4,\"optionDescription\":\"A class can inherit from multiple abstract classes\",\"questionId\":1}],\"selected\":null}]"
                , mvcResult1.getResponse().getContentAsString(), false);
    }

}