package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Category;

import java.util.List;

public class CategoryDTO {

    private final Long id;
    private final String name;
    private final String code;
    private final int order;
    private final String description;
    private final boolean active;
    private final String iconPath;
    private final String colorCode;
    private final String studyGuide;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.code = category.getCode();
        this.order = category.getOrder();
        this.description = category.getDescription();
        this.active = category.getActive();
        this.iconPath = category.getIconPath();
        this.colorCode = category.getColorCode();
        this.studyGuide = category.getStudyGuide();
    }

    public static List<CategoryDTO> fromDTO(List<Category> categoryList) {
        return categoryList.stream().map(CategoryDTO::new).toList();
    }

    public Long getId() {
        return id;
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

    public boolean isActive() {
        return active;
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
}
