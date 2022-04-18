package br.com.coddingSchool.dto.login;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;

import java.util.List;

public class CourseLoginDTO {

    private Long id;
    private String name;
    private String code;
    private boolean visible;
    private Subcategory subcategory;

    public CourseLoginDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.code = course.getCode();
        this.visible = course.getVisible();
        this.subcategory = course.getSubcategory();
    }

    public static List<CourseLoginDTO> toDTO(List<Course> courses) {
        return courses.stream().map(CourseLoginDTO::new).toList();
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

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
