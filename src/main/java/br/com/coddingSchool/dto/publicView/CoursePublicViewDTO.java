package br.com.coddingSchool.dto.publicView;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CoursePublicViewDTO {

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

    public CoursePublicViewDTO(Course course) {
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

    public static List<CoursePublicViewDTO> toDTO(List<Course> courses) {
        return courses.stream().map(CoursePublicViewDTO::new).toList();
    }
}
