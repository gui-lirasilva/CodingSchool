package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Category;

import java.util.List;

public class CategoryDTO {

    private Long id;
    private String name;
    private String code;
    private boolean active;
    private List<SubcategoryDTO> subcategories;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.code = category.getCode();
        this.active = category.getActive();
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

    public List<SubcategoryDTO> getSubcategories() {
        return subcategories;
    }
}
