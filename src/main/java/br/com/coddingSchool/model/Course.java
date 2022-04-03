package br.com.coddingSchool.model;

import br.com.coddingSchool.validations.CodeValidator;
import br.com.coddingSchool.validations.EstimatedTimeValidator;
import br.com.coddingSchool.validations.ObjectValidator;
import br.com.coddingSchool.validations.StringValidator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{name.empty.null}")
    private String name;
    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;
    @Min(value = 1, message = "The estimated time can't be smaller 1")
    @Max(value = 20, message = "The estimated time can't be bigger than 20")
    @Column(name = "estimated_time")
    private int estimatedTime;
    private Boolean visible = false;
    @Column(columnDefinition = "text")
    private String target;
    @NotBlank(message = "The instructor name can't be null or empty")
    private String instructor;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "developed_skills", columnDefinition = "text")
    private String developedSkills;
    @NotNull(message = "The sub category can't be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id", nullable = false)
    @JsonIgnore
    private Subcategory subcategory;

    public Course(String name, String code, int estimatedTime, boolean visible, String target, String instructor,
                  String description, String developedSkills, Subcategory subcategory) {

        this.name = name;
        this.code = code;
        this.estimatedTime = estimatedTime;
        this.visible = visible;
        this.target = target;
        this.instructor = instructor;
        this.description = description;
        this.developedSkills = developedSkills;
        this.subcategory = subcategory;
    }

    public Course(String name, String code, int estimatedTime, boolean visible, String instructor, Subcategory subcategory) {

        this.name = name;
        this.code = code;
        this.estimatedTime = estimatedTime;
        this.visible = visible;
        this.instructor = instructor;
        this.subcategory = subcategory;
    }

    public Course() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public Boolean getVisible() {
        return visible;
    }

    public String getTarget() {
        return target;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDescription() {
        return description;
    }

    public String getDevelopedSkills() {
        return developedSkills;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", estimatedTime=" + estimatedTime +
                ", target='" + target + '\'' +
                ", instructor='" + instructor + '\'' +
                ", description='" + description + '\'' +
                ", developedSkills='" + developedSkills + '\'' +
                ", visible=" + visible +
                ", subcategory=" + subcategory +
                '}';
    }
}
