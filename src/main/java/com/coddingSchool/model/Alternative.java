package com.coddingSchool.model;

import com.coddingSchool.validations.ObjectValidator;
import com.coddingSchool.validations.StringValidator;

public class Alternative {

    private String explanatoryText;
    private int order;
    private boolean correct;
    private String justification;
    private Question question;

    public Alternative(String explanatoryText, boolean correct, Question question) {

        StringValidator.cantBeBlank(explanatoryText, "The explanatory text can't be empty or null");

        ObjectValidator.cantBeNull(question, "The question can't be null");

        this.explanatoryText = explanatoryText;
        this.question = question;
        this.correct = correct;
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
