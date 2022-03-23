package br.com.coddingSchool.model;

import br.com.coddingSchool.validations.CodeValidator;
import br.com.coddingSchool.validations.EstimatedTimeValidator;
import br.com.coddingSchool.validations.ObjectValidator;
import br.com.coddingSchool.validations.StringValidator;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    @Column(name = "estimated_time")
    private int estimatedTime;
    private Boolean visible = false;
    @Column(columnDefinition = "text")
    private String target;
    private String instructor;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "developed_skills", columnDefinition = "text")
    private String developedSkills;
    @ManyToOne
    private Subcategory subcategory;

    public Course(String name, String code, int estimatedTime, boolean visible, String target, String instructor,
                  String description, String developedSkills, Subcategory subcategory) {

        StringValidator.cantBeBlank(name, "The name can't be null or empty");

        CodeValidator
                .cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");

        EstimatedTimeValidator
                .timeValidator(estimatedTime, "The estimated time can't be smaller 1 or bigger than 20");

        StringValidator.cantBeBlank(instructor, "The instructor name can't be null or empty");

        ObjectValidator.cantBeNull(subcategory, "The sub category can't be null");

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

        StringValidator.cantBeBlank(name, "The name can't be null or empty");

        CodeValidator
                .cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");

        EstimatedTimeValidator
                .timeValidator(estimatedTime, "The estimated time can't be smaller 1 or bigger than 20");

        StringValidator.cantBeBlank(instructor, "The instructor name can't be null or empty");

        ObjectValidator.cantBeNull(subcategory, "The sub category can't be null");

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
