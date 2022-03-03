package school;

import static validations.StringValidator.cantBeBlank;

public class Explanation extends Activity{

    private String text;

    public Explanation(String title, String code, Section section, String text) {

        super(title, code, section);

        cantBeBlank(text, "The text can't be empty or null");

        this.text = text;
    }

    @Override
    public String toString() {
        return "Explanation{" +
                "text='" + text + '\'' +
                '}';
    }
}
