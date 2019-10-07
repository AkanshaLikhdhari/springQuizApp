package com.target.springQuizApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "quiz_option")
public class QuizOption implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "option_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long optionId;

    @Column(name = "option_description")
    private String optionDescription;

    @Column(name = "question_id")
    private Long questionId;
}
