package br.com.coddingSchool.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{name.empty.null}")
    private String name;
    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;
    @Column(name = "order_in_system")
    private int orderInSystem;
    private boolean active;
    private boolean test;
    @NotNull(message = "The course can't be null")
    @ManyToOne
    private Course course;

    public Section(String name, String code, int orderInSystem, boolean active, boolean test, Course course) {
        this.name = name;
        this.code = code;
        this.orderInSystem = orderInSystem;
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
                ", order=" + orderInSystem +
                ", active=" + active +
                ", test=" + test +
                ", course=" + course +
                '}';
    }
}
