package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Course;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

public class CourseDTO {

    private Long id;
    private String name;
    private String code;
    private boolean visible;
    private int estimatedTime;
    private String developedSkills;

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.code = course.getCode();
        this.estimatedTime = course.getEstimatedTime();
        this.developedSkills = course.getDevelopedSkills();
        this.visible = course.getVisible();
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
}
