package school;

import validations.StringValidator;

public class Question extends Activity{

    private String statement; // Enunciado
    private QuestionType questionType = QuestionType.UNIC;

    public Question(String title, String code, Section section, String statement, QuestionType questionType) {
        super(title, code, section);

        StringValidator.cantBeBlank(statement, "The statement can't be empty or null");
        this.statement = statement;

        this.questionType = questionType;
    }

    @Override
    public String toString() {
        return "Question{" +
                "statement='" + statement + '\'' +
                ", questionType=" + questionType +
                '}';
    }
}
