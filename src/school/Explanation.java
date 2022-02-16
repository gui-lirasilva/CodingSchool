package school;

import validations.StringValidator;

public class Explanation extends Activity{

    private String text;

    public Explanation(String title, String code, Section section, String text) {

        super(title, code, section);

        StringValidator.cantBeBlank(text, "The text can't be empty or null");

        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Explanation{" +
                "text='" + text + '\'' +
                '}';
    }
}
