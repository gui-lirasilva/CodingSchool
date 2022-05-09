package br.com.coddingSchool.dto.login;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
}
