package com.target.springQuizApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "quiz_question")
public class QuizQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;

    @Column(name = "question_description")
    private String questionDescription;

    @Column(name = "correct_option_id")
    private Long correctOptionId;

    //Fetch Type Lazy makes sure that the question options are loaded only when required like when getQuestionOptions() method is called
    //Cascading decides the deletion of related columns
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<QuizOption> quizOption;

    @Transient
    private String selected;

}
