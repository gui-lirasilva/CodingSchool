package br.com.coddingSchool.dto.api;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;

import java.util.List;

public class CategoryApiDTO {

    private String name;
    private String code;
    private int orderInSystem;
    private String colorCode;
    private String studyGuide;
    private int categoryCoursesNumber;
    private List<SubcategoryApiDTO> activeSubcategories;

    @Deprecated
    public CategoryApiDTO() {
    }

    public CategoryApiDTO(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.orderInSystem = category.getOrderInSystem();
        this.colorCode = category.getColorCode();
        this.studyGuide = category.getStudyGuide();
        this.activeSubcategories = SubcategoryApiDTO.toDTO(category.getSubcategories().stream()
                .filter(Subcategory::isActive).toList());
        this.categoryCoursesNumber = SubcategoryApiDTO.toDTO(category.getSubcategories()).stream()
                .mapToInt(SubcategoryApiDTO::getCoursesNumber).sum();
    }

    public static List<CategoryApiDTO> toDTO(List<Category> categoryList) {
        return categoryList.stream().map(CategoryApiDTO::new).toList();
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

    public String getColorCode() {
        return colorCode;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public List<SubcategoryApiDTO> getActiveSubcategories() {
        return activeSubcategories;
    }

    public int getCategoryCoursesNumber() {
        return categoryCoursesNumber;
    }
}
