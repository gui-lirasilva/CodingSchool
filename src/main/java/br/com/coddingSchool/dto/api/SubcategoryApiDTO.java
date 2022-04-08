package br.com.coddingSchool.dto.api;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class SubcategoryApiDTO {

    private String name;
    private String code;
    private int orderInSystem;
    private String studyGuide;
    @JsonIgnore
    private int coursesNumber;
    private List<CourseApiDTO> activeCourses;

    @Deprecated
    public SubcategoryApiDTO() {
    }

    public SubcategoryApiDTO(Subcategory subcategory) {
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.orderInSystem = subcategory.getOrderInSystem();
        this.studyGuide = subcategory.getStudyGuide();
        this.activeCourses = CourseApiDTO.toDTO(subcategory.getCourses().stream().filter(Course::getVisible).toList());
        this.coursesNumber = subcategory.getCourses().size();
    }

    public static List<SubcategoryApiDTO> toDTO(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryApiDTO::new).toList();
    }

    public List<CourseApiDTO> getActiveCourses() {
        return activeCourses;
    }

    public int getCoursesNumber() {
        return coursesNumber;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getOrderInSystem() {
        return orderInSystem;
    }

    public String getStudyGuide() {
        return studyGuide;
    }
}
