package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SubcategoryDTO {

    private String name;
    private String code;
    private int order;
    private String studyGuide;
    private List<CourseDTO> courses;

    public SubcategoryDTO(Subcategory subcategory) {
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.order = subcategory.getOrder();
        this.studyGuide = subcategory.getStudyGuide();
        this.courses = CourseDTO.fromDTO(subcategory.getCourses());
    }

    public static List<SubcategoryDTO> fromDTO(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryDTO::new).toList();
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }
}
