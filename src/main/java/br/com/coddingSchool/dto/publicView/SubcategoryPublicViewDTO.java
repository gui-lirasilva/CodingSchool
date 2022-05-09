package br.com.coddingSchool.dto.publicView;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import lombok.Getter;

import java.util.List;

@Getter
public class SubcategoryPublicViewDTO {

    private Long id;
    private String name;
    private String code;
    private int orderInSystem;
    private String description;
    private boolean active;
    private String studyGuide;
    private List<CoursePublicViewDTO> courses;
    private Category category;


    public SubcategoryPublicViewDTO(Subcategory subcategory) {
        this.id = subcategory.getId();
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.orderInSystem = subcategory.getOrderInSystem();
        this.description = subcategory.getDescription();
        this.active = subcategory.isActive();
        this.studyGuide = subcategory.getStudyGuide();
        this.courses = CoursePublicViewDTO.toDTO(subcategory.getCourses().stream()
                .filter(Course::getVisible).toList());
        this.category = subcategory.getCategory();
    }

    public static List<SubcategoryPublicViewDTO> toDTO(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryPublicViewDTO::new).toList();
    }
}
