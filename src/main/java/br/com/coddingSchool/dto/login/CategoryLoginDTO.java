package br.com.coddingSchool.dto.login;

import br.com.coddingSchool.model.Category;

import java.util.List;

public class CategoryLoginDTO {

    private String name;
    private String code;
    private String iconPath;
    private List<SubcategoryLoginDTO> subcategories;

    public CategoryLoginDTO(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.iconPath = category.getIconPath();
        this.subcategories = SubcategoryLoginDTO.toDTO(category.getSubcategories());
    }

    public static List<CategoryLoginDTO> toDTO(List<Category> categoryList) {
        return categoryList.stream().map(CategoryLoginDTO::new).toList();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getIconPath() {
        return iconPath;
    }

    public List<SubcategoryLoginDTO> getSubcategories() {
        return subcategories;
    }
}
