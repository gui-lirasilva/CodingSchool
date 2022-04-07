package br.com.coddingSchool.dto.api;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SubcategoryApiDTO {

    private String name;
    private String code;
    private int order;
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
        this.order = subcategory.getOrder();
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

    public int getOrder() {
        return order;
    }

    public String getStudyGuide() {
        return studyGuide;
    }
}
