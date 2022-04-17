package br.com.coddingSchool.dto.form;

import br.com.coddingSchool.dto.CourseDTO;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;

import javax.validation.constraints.*;
import java.util.List;

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

    public CourseFormDTO() {
    }

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

    public CourseFormDTO(Long id, String name, String code, int estimatedTime, boolean visible, String target,
                         String instructor, String description, String developedSkills, Subcategory subcategory) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.estimatedTime = estimatedTime;
        this.visible = visible;
        this.target = target;
        this.instructor = instructor;
        this.description = description;
        this.developedSkills = developedSkills;
        this.subcategory = subcategory;
    }

    public static List<CourseFormDTO> toDTO(List<Course> courses) {
        return courses.stream().map(CourseFormDTO::new).toList();
    }

    public Course toEntity() {
        return new Course(name, code, estimatedTime, visible, target, instructor, description, developedSkills, subcategory);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public boolean isVisible() {
        return visible;
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

    public String getDevelopedSkills() {
        return developedSkills;
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
