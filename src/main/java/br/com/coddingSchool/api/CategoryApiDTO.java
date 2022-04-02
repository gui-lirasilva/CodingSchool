package br.com.coddingSchool.api;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.repository.CourseRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryApiDTO {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CourseRepository courseRepository;

//    private final String name;
//    private final String code;
//    private final int order;
//    private final String colorCode;
//    private final String studyGuide;
//    private final Long coursesNumber;
//    private final List<Subcategory> activeSubcategories;
//    private final List<Course> publicCourses;
//
//    public CategoryApiDTO(String name, String code, int order, String colorCode, String studyGuide, Long coursesNumber) {
//        this.name = name;
//        this.code = code;
//        this.order = order;
//        this.colorCode = colorCode;
//        this.studyGuide = studyGuide;
//        this.coursesNumber = coursesNumber;
//        this.activeSubcategories = subcategoryRepository.findSubcategoriesFromCategory();
//        this.publicCourses = publicCourses;
//    }
}
