package com.coddingSchool.model;

import com.coddingSchool.validations.ObjectValidator;
import com.coddingSchool.validations.StringValidator;

import javax.persistence.*;

@Entity
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "explanatory_text")
    private String explanatoryText;
    @Column(name = "`order`")
    private int order;
    private boolean correct;
    private String justification;
    @ManyToOne
    private Question question;

    public Alternative(String explanatoryText, int order, boolean correct, String justification, Question question) {

        StringValidator.cantBeBlank(explanatoryText, "The explanatory text can't be empty or null");

        ObjectValidator.cantBeNull(question, "The question can't be null");

        this.explanatoryText = explanatoryText;
        this.order = order;
        this.justification = justification;
        this.question = question;
        this.correct = correct;
    }

    public Alternative() {

    }

    @Override
    public String toString() {
        return "Alternative{" +
                "explanatoryText='" + explanatoryText + '\'' +
                ", order=" + order +
                ", correct=" + correct +
                ", justification='" + justification + '\'' +
                ", question=" + question +
                '}';
    }
}
