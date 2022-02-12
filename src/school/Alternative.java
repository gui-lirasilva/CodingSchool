package school;

import validations.ObjectValidator;
import validations.StringValidator;

public class Alternative {

    private String explanatoryText;
    private int order;
    private boolean correct;
    private String justification;
    private Question question;

    public Alternative(String explanatoryText, boolean correct, Question question) {

        StringValidator.cantBeBlank(explanatoryText, "The explanatory text can't be empty or null");
        this.explanatoryText = explanatoryText;

        ObjectValidator.cantBeNull(question, "The question can't be null");
        this.question = question;

        this.correct = correct;
    }

    public Alternative(String explanatoryText, int order, boolean correct, String justification, Question question) {

        StringValidator.cantBeBlank(explanatoryText, "The explanatory text can't be empty or null");
        this.explanatoryText = explanatoryText;

        ObjectValidator.cantBeNull(question, "The question can't be null");
        this.question = question;

        ObjectValidator.cantBeNull(justification, "The explanation can't be null");
        this.justification = justification;

        this.order = order;
        this.correct = correct;
    }

    public String getExplanatoryText() {
        return explanatoryText;
    }

    public int getOrder() {
        return order;
    }

    public boolean isCorrect() {
        return correct;
    }

    public String getJustification() {
        return justification;
    }

    public Question getQuestion() {
        return question;
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
