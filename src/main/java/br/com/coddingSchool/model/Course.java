package br.com.coddingSchool.model;

import br.com.coddingSchool.dto.form.CourseFormDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank(message = "{name.empty.null}")
    private String name;

    @Setter
    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;

    @Setter
    @Min(value = 1, message = "{estimatedTime.min}")
    @Max(value = 20, message = "{estimatedTime.max}")
    @Column(name = "estimated_time")
    private int estimatedTime;

    @Setter
    private Boolean visible = false;

    @Setter
    @Column(columnDefinition = "text")
    private String target;

    @Setter
    @NotBlank(message = "{instructor.null.empty}")
    private String instructor;

    @Setter
    @Column(columnDefinition = "text")
    private String description;

    @Setter
    @Column(name = "developed_skills", columnDefinition = "text")
    private String developedSkills;

    @Setter
    @NotNull(message = "{subcategory.null}")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", name = "subcategory_id", nullable = false)
    private Subcategory subcategory;

    public Course(String name, String code, int estimatedTime, boolean visible, String target, String instructor,
                  String description, String developedSkills, Subcategory subcategory) {

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

    public Course(String name, String code, int estimatedTime, boolean visible, String instructor, Subcategory subcategory) {

        this.name = name;
        this.code = code;
        this.estimatedTime = estimatedTime;
        this.visible = visible;
        this.instructor = instructor;
        this.subcategory = subcategory;
    }

    public void toMerge(CourseFormDTO courseFormDto) {
        this.name = courseFormDto.getName();
        this.code = courseFormDto.getCode();
        this.estimatedTime = courseFormDto.getEstimatedTime();
        this.visible = courseFormDto.isVisible();
        this.target = courseFormDto.getTarget();
        this.instructor = courseFormDto.getInstructor();
        this.description = courseFormDto.getDescription();
        this.developedSkills = courseFormDto.getDevelopedSkills();
        this.subcategory = courseFormDto.getSubcategory();
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", estimatedTime=" + estimatedTime +
                ", target='" + target + '\'' +
                ", instructor='" + instructor + '\'' +
                ", description='" + description + '\'' +
                ", developedSkills='" + developedSkills + '\'' +
                ", visible=" + visible +
                ", subcategory=" + subcategory +
                '}';
    }
}
