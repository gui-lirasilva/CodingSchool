package br.com.coddingSchool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Explanation extends Activity {

    @NotBlank(message = "The text can't be empty or null")
    @Column(name = "explanatory_text", columnDefinition = "text")
    private String explanatoryText;

    public Explanation(String title, String code, Section section, String text) {
        super(title, code, section);
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
