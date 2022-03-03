package school;

import static validations.ObjectValidator.cantBeNull;
import static validations.StringValidator.cantBeBlank;

public class Question extends Activity{

    private String statement;
    private QuestionType questionType;

    public Question(String title, String code, Section section, String statement, QuestionType questionType) {

        super(title, code, section);

        cantBeBlank(statement, "The statement can't be empty or null");

        cantBeNull(questionType, "The question type can't be null");

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
