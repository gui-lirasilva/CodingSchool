package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

public class CourseDTO {

    private Long id;
    private String name;
    private String code;
    private int estimatedTime;
    private boolean visible;
    private String target;
    private String instructor;
    private String description;
    private String developedSkills;
    private Subcategory subcategory;

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.code = course.getCode();
        this.estimatedTime = course.getEstimatedTime();
        this.visible = course.getVisible();
        this.target = course.getTarget();
        this.instructor = course.getInstructor();
        this.description = course.getDescription();
        this.developedSkills = course.getDevelopedSkills();
        this.subcategory = course.getSubcategory();
    }

    public static List<CourseDTO> toDTO(List<Course> courses) {
        return courses.stream().map(CourseDTO::new).toList();
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

    public String getDevelopedSkills() {
        return developedSkills;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDevelopedSkills(String developedSkills) {
        this.developedSkills = developedSkills;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
