package br.com.coddingSchool.model;

import br.com.coddingSchool.validations.ObjectValidator;
import br.com.coddingSchool.validations.StringValidator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Question extends Activity{

    @NotBlank(message = "The statement can't be empty or null")
    private String statement;
    @NotNull(message = "The question type can't be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "question_type")
    private QuestionType questionType;

    public Question(String title, String code, Section section, String statement, QuestionType questionType) {
        super(title, code, section);
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
