package br.com.coddingSchool.model;

import br.com.coddingSchool.validations.ObjectValidator;
import br.com.coddingSchool.validations.StringValidator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Question extends Activity{

    private String statement;
    @Enumerated(EnumType.STRING)
    @Column(name = "question_type")
    private QuestionType questionType;

    public Question(String title, String code, Section section, String statement, QuestionType questionType) {

        super(title, code, section);

        StringValidator.cantBeBlank(statement, "The statement can't be empty or null");

        ObjectValidator.cantBeNull(questionType, "The question type can't be null");

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
