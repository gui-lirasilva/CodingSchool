package br.com.coddingSchool.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static br.com.coddingSchool.validations.CodeValidator.cantBeOutPattern;
import static br.com.coddingSchool.validations.ObjectValidator.cantBeNull;
import static br.com.coddingSchool.validations.StringValidator.cantBeBlank;

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{name.empty.null}")
    private String name;
    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;
    @Column(name = "`order`")
    private int order;
    private boolean active;
    private boolean test;
    @NotNull(message = "The course can't be null")
    @ManyToOne
    private Course course;

    public Section(String name, String code, int order, boolean active, boolean test, Course course) {
        this.name = name;
        this.code = code;
        this.order = order;
        this.active = active;
        this.test = test;
        this.course = course;
    }

    public Section() {

    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", order=" + order +
                ", active=" + active +
                ", test=" + test +
                ", course=" + course +
                '}';
    }
}
