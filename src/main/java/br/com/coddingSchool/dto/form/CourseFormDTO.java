package br.com.coddingSchool.dto.form;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseFormDTO {

    private Long id;
    @NotBlank(message = "{name.empty.null}")
    private String name;
    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;
    @Min(value = 1, message = "{estimatedTime.min}")
    @Max(value = 20, message = "{estimatedTime.max}")
    private int estimatedTime;
    private boolean visible;
    private String target;
    @NotBlank(message = "{instructor.null.empty}")
    private String instructor;
    private String description;
    private String developedSkills;
    @NotNull(message = "{subcategory.null}")
    private Subcategory subcategory;

    public CourseFormDTO(Course course) {
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

    public static List<CourseFormDTO> toDTO(List<Course> courses) {
        return courses.stream().map(CourseFormDTO::new).toList();
    }

    public Course toEntity() {
        return new Course(name, code, estimatedTime, visible, target, instructor, description, developedSkills, subcategory);
    }
}
