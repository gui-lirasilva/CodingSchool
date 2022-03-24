package br.com.coddingSchool.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import static br.com.coddingSchool.validations.StringValidator.cantBeBlank;

@Entity
public class Explanation extends Activity {

    @Column(name = "explanatory_text", columnDefinition = "text")
    private String explanatoryText;

    public Explanation(String title, String code, Section section, String text) {

        super(title, code, section);

        cantBeBlank(text, "The text can't be empty or null");

        this.explanatoryText = text;
    }

    public Explanation() {

    }

    @Override
    public String toString() {
        return "Explanation{" +
                "text='" + explanatoryText + '\'' +
                '}';
    }
}
