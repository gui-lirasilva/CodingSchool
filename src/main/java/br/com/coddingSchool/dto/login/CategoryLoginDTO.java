package br.com.coddingSchool.dto.login;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import lombok.Getter;

import java.util.List;

@Getter
public class CategoryLoginDTO {

    private String name;
    private String code;
    private String iconPath;
    private List<SubcategoryLoginDTO> subcategories;

    public CategoryLoginDTO(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.iconPath = category.getIconPath();
        this.subcategories = SubcategoryLoginDTO.toDTO(category.getSubcategories().stream()
                .filter(Subcategory::isActive)
                .filter(s -> s.getCourses().stream().anyMatch(Course::getVisible))
                .toList());
    }

    public static List<CategoryLoginDTO> toDTO(List<Category> categoryList) {
        return categoryList.stream().map(CategoryLoginDTO::new).toList();
    }
}
