package br.com.coddingSchool.model;

import javax.persistence.*;

import static br.com.coddingSchool.validations.CodeValidator.cantBeOutPattern;
import static br.com.coddingSchool.validations.ObjectValidator.cantBeNull;
import static br.com.coddingSchool.validations.StringValidator.cantBeEmpty;

@MappedSuperclass
public abstract class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String code;
    private boolean active;
    @Column(name = "`order`")
    private int order;
    @ManyToOne
    private Section section;

    public Activity() {

    }

    public Activity(String title, String code, Section section) {

        cantBeEmpty(title, "The title can't be empty");

        cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");

        cantBeNull(section, "The section can't be null");

        this.title = title;
        this.code = code;
        this.section = section;
    }
}
