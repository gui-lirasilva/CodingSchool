package br.com.coddingSchool.dto.api;

import br.com.coddingSchool.model.Course;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CourseApiDTO {

    private String name;
    private String code;
    private int estimatedTime;
    private String developedSkills;

    public CourseApiDTO(Course course) {
        this.name = course.getName();
        this.code = course.getCode();
        this.estimatedTime = course.getEstimatedTime();
        this.developedSkills = course.getDevelopedSkills();
    }

    public static List<CourseApiDTO> toDTO(List<Course> courses) {
        return courses.stream().map(CourseApiDTO::new).toList();
    }
}
