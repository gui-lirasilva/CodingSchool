package com.coddingSchool.model;

import javax.persistence.*;

import static com.coddingSchool.validations.CodeValidator.cantBeOutPattern;
import static com.coddingSchool.validations.ObjectValidator.cantBeNull;
import static com.coddingSchool.validations.StringValidator.cantBeBlank;

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    @Column(name = "`order`")
    private int order;
    private boolean active;
    private boolean test;
    @ManyToOne
    private Course course;

    public Section(String name, String code, int order, boolean active, boolean test, Course course) {

        cantBeBlank(name, "The name can't be null or empty");

        cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");

        cantBeNull(course, "The course can't be null");

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
