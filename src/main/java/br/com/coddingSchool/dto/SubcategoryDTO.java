package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SubcategoryDTO {

    private String name;
    private String code;
    private int order;
    private String studyGuide;
    @JsonIgnore
    private int coursesNumber;
    private List<CourseDTO> activeCourses;


    public SubcategoryDTO(Subcategory subcategory) {
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.order = subcategory.getOrder();
        this.studyGuide = subcategory.getStudyGuide();
        this.activeCourses = CourseDTO.fromDTO(subcategory.getCourses().stream().filter(Course::getVisible).toList());
        this.coursesNumber = subcategory.getCourses().size();
    }

    public static List<SubcategoryDTO> fromDTO(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryDTO::new).toList();
    }

    public List<CourseDTO> getActiveCourses() {
        return activeCourses;
    }

    public int getCoursesNumber() {
        return coursesNumber;
    }
}
