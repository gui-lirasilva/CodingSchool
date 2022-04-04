package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Category;

import java.util.List;

public class CategoryDTO {

    private Long id;
    private String name;
    private String code;
    private boolean active;
    private int order;
    private String description;
    private String iconPath;
    private String colorCode;
    private String studyGuide;
    private List<SubcategoryDTO> subcategories;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.code = category.getCode();
        this.active = category.getActive();
        this.order = category.getOrder();
        this.description = category.getDescription();
        this.iconPath = category.getIconPath();
        this.colorCode = category.getColorCode();
        this.studyGuide = category.getStudyGuide();
        this.subcategories = SubcategoryDTO.toDTO(category.getSubcategories());
    }

    public static List<CategoryDTO> toDTO(List<Category> categoryList) {
        return categoryList.stream().map(CategoryDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
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

    public String getDescription() {
        return description;
    }

    public String getIconPath() {
        return iconPath;
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
