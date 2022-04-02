package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CategoryDTO {

    private String name;
    private String code;
    private int order;
    private String colorCode;
    private String studyGuide;
    private int categoryCoursesNumber;
    private List<SubcategoryDTO> activeSubcategories;

    public CategoryDTO(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.order = category.getOrder();
        this.colorCode = category.getColorCode();
        this.studyGuide = category.getStudyGuide();
        this.activeSubcategories = SubcategoryDTO.fromDTO(category.getSubcategories().stream()
                .filter(Subcategory::isActive).toList());
        this.categoryCoursesNumber = SubcategoryDTO.fromDTO(category.getSubcategories()).stream()
                .mapToInt(SubcategoryDTO::getCoursesNumber).sum();
    }

    public static List<CategoryDTO> fromDTO(List<Category> categoryList) {
        return categoryList.stream().map(CategoryDTO::new).toList();
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

    public List<SubcategoryDTO> getActiveSubcategories() {
        return activeSubcategories;
    }
}
