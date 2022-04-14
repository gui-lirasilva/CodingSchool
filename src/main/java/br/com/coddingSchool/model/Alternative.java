package br.com.coddingSchool.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Alternative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "The explanatory text can't be null")
    @NotBlank(message = "The explanatory text can't be blank")
    @Column(name = "explanatory_text")
    private String explanatoryText;
    @Column(name = "order_in_system")
    private int orderInSystem;
    private boolean correct;
    private String justification;
    @NotNull(message = "The question can't be null")
    @ManyToOne
    private Question question;

    public Alternative(String explanatoryText, int orderInSystem, boolean correct, String justification, Question question) {

        this.explanatoryText = explanatoryText;
        this.orderInSystem = orderInSystem;
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
                ", order=" + orderInSystem +
                ", correct=" + correct +
                ", justification='" + justification + '\'' +
                ", question=" + question +
                '}';
    }
}
