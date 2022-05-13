package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;
import lombok.Getter;

import java.util.List;

@Getter
public class SubcategoryDTO {

    private Long id;
    private String name;
    private String code;
    private int orderInSystem;
    private String description;
    private boolean active;
    private String studyGuide;
    private List<CourseDTO> courses;
    private Category category;


    public SubcategoryDTO(Subcategory subcategory) {
        this.id = subcategory.getId();
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.orderInSystem = subcategory.getOrderInSystem();
        this.description = subcategory.getDescription();
        this.active = subcategory.isActive();
        this.studyGuide = subcategory.getStudyGuide();
        this.courses = CourseDTO.toDTO(subcategory.getCourses());
        this.category = subcategory.getCategory();
    }

    public static List<SubcategoryDTO> toDTO(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryDTO::new).toList();
    }
}
