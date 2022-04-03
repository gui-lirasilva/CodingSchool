package br.com.coddingSchool.dto.api;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CategoryApiDTO {

    private String name;
    private String code;
    private int order;
    private String colorCode;
    private String studyGuide;
    private int categoryCoursesNumber;
    private List<SubcategoryApiDTO> activeSubcategories;

    public CategoryApiDTO(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.order = category.getOrder();
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

    public int getOrder() {
        return order;
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
}
