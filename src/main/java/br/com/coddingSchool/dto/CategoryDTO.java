package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Category;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CategoryDTO {

    private String name;
    private String code;
    private int order;
    private String colorCode;
    private String studyGuide;
    private List<SubcategoryDTO> subcategories;

    public CategoryDTO(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.order = category.getOrder();
        this.colorCode = category.getColorCode();
        this.studyGuide = category.getStudyGuide();
        this.subcategories = SubcategoryDTO.fromDTO(category.getSubcategories());
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

    public List<SubcategoryDTO> getSubcategories() {
        return subcategories;
    }
}
