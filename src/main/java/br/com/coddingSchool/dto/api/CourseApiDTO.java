package br.com.coddingSchool.dto.api;

import br.com.coddingSchool.model.Course;

import java.util.List;

public class CourseApiDTO {

    private String name;
    private String code;
    private int estimatedTime;
    private String developedSkills;

    @Deprecated
    public CourseApiDTO() {

    }

    public CourseApiDTO(Course course) {
        this.name = course.getName();
        this.code = course.getCode();
        this.estimatedTime = course.getEstimatedTime();
        this.developedSkills = course.getDevelopedSkills();
    }

    public static List<CourseApiDTO> toDTO(List<Course> courses) {
        return courses.stream().map(CourseApiDTO::new).toList();
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
}
