package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
}
