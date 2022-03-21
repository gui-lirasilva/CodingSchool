package com.coddingSchool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import static com.coddingSchool.validations.ObjectValidator.cantBeNull;
import static com.coddingSchool.validations.StringValidator.cantBeBlank;

@Entity
public class Question extends Activity{

    private String statement;
    @Enumerated(EnumType.STRING)
    @Column(name = "question_type")
    private QuestionType questionType;

    public Question(String title, String code, Section section, String statement, QuestionType questionType) {

        super(title, code, section);

        cantBeBlank(statement, "The statement can't be empty or null");

        cantBeNull(questionType, "The question type can't be null");

        this.statement = statement;
        this.questionType = questionType;
    }

    public Question() {

    }

    @Override
    public String toString() {
        return "Question{" +
                "statement='" + statement + '\'' +
                ", questionType=" + questionType +
                '}';
    }
}
