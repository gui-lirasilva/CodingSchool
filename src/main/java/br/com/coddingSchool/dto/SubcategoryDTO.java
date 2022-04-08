package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Subcategory;

import java.util.List;

public class SubcategoryDTO {

    private Long id;
    private String name;
    private String code;
    private int order;
    private String studyGuide;
    private List<CourseDTO> courses;


    public SubcategoryDTO(Subcategory subcategory) {
        this.id = subcategory.getId();
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.order = subcategory.getOrderInSystem();
        this.studyGuide = subcategory.getStudyGuide();
        this.courses = CourseDTO.toDTO(subcategory.getCourses());
    }

    public static List<SubcategoryDTO> toDTO(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryDTO::new).toList();
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getOrder() {
        return order;
    }

    public String getStudyGuide() {
        return studyGuide;
    }
}
