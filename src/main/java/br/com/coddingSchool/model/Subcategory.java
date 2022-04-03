package br.com.coddingSchool.model;

import br.com.coddingSchool.validations.ObjectValidator;
import br.com.coddingSchool.validations.StringValidator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.List;

import static br.com.coddingSchool.validations.CodeValidator.cantBeOutPattern;

@Entity
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{name.empty.null}")
    private String name;
    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;
    @Column(name = "`order`")
    private int order;
    @NotBlank(message = "The category description can't be empty or null")
    @Column(columnDefinition = "text")
    private String description;
    private boolean active;
    @NotNull(message = "The category can't be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnore
    private Category category;
    @Column(name = "study_guide", columnDefinition = "text")
    private String studyGuide;
    @OneToMany(mappedBy = "subcategory")
    private List<Course> courses;

    public Subcategory(String name, String code, int order, String description, boolean active, Category category,
                       String studyGuide) {
        this.name = name;
        this.code = code;
        this.order = order;
        this.description = description;
        this.active = active;
        this.category = category;
        this.studyGuide = studyGuide;
    }

    public Subcategory(String name, String code, boolean active, Category category) {
        this.name = name;
        this.code = code;
        this.active = active;
        this.category = category;
    }

    public Subcategory() {

    }

    public Long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getOrder() {
        return order;
    }

    public String getDescription() {
        return description;
    }

    public boolean getActive() {
        return active;
    }

    public Category getCategory() {
        return category;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", studyGuide='" + studyGuide + '\'' +
                ", active=" + active +
                ", order=" + order +
                ", category=" + category.getName() +
                '}';
    }
}
