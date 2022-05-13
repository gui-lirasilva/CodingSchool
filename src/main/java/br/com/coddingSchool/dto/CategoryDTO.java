package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Category;
import lombok.Getter;

import java.util.List;

@Getter
public class CategoryDTO {

    private Long id;
    private String name;
    private String code;
    private boolean active;
    private int orderInSystem;
    private String description;
    private String iconPath;
    private String colorCode;
    private String studyGuide;
    private List<SubcategoryDTO> subcategories;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.code = category.getCode();
        this.active = category.isActive();
        this.orderInSystem = category.getOrderInSystem();
        this.description = category.getDescription();
        this.iconPath = category.getIconPath();
        this.colorCode = category.getColorCode();
        this.studyGuide = category.getStudyGuide();
        this.subcategories = SubcategoryDTO.toDTO(category.getSubcategories());
    }

    public static List<CategoryDTO> toDTO(List<Category> categoryList) {
        return categoryList.stream().map(CategoryDTO::new).toList();
    }
}
