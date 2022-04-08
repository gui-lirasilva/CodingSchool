package br.com.coddingSchool.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@MappedSuperclass
public abstract class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "The title can't be empty or null")
    private String title;
    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;
    private boolean active;
    @Column(name = "order_in_system")
    private int orderInSystem;
    @NotNull(message = "The section can't be null")
    @ManyToOne
    private Section section;

    public Activity() {

    }

    public Activity(String title, String code, Section section) {
        this.title = title;
        this.code = code;
        this.section = section;
    }
}
