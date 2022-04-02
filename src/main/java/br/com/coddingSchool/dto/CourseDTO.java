package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Course;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CourseDTO {

    private String name;
    private String code;
    private int estimatedTime;
    private String developedSkills;

    public CourseDTO(Course course) {
        this.name = course.getName();
        this.code = course.getCode();
        this.estimatedTime = course.getEstimatedTime();
        this.developedSkills = course.getDevelopedSkills();
    }

    public static List<CourseDTO> fromDTO(List<Course> courses) {
        return courses.stream().map(CourseDTO::new).toList();
    }
}
