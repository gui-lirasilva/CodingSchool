package br.com.coddingSchool.dto.login;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import lombok.Getter;

import java.util.List;

@Getter
public class SubcategoryLoginDTO {

    private Long id;
    private String name;
    private String code;
    private int orderInSystem;
    private boolean active;
    private List<CourseLoginDTO> courses;
    private Category category;


    public SubcategoryLoginDTO(Subcategory subcategory) {
        this.id = subcategory.getId();
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.orderInSystem = subcategory.getOrderInSystem();
        this.active = subcategory.isActive();
        this.courses = CourseLoginDTO.toDTO(subcategory.getCourses().stream()
                .filter(Course::getVisible).toList());
        this.category = subcategory.getCategory();
    }

    public static List<SubcategoryLoginDTO> toDTO(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryLoginDTO::new).toList();
    }

    public List<CourseLoginDTO> getCourses() {
        return courses;
    }
}
