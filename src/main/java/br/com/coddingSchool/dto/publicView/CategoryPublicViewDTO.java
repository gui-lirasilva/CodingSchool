package br.com.coddingSchool.dto.publicView;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import lombok.Getter;

import java.util.List;

@Getter
public class CategoryPublicViewDTO {

    private Long id;
    private String name;
    private String code;
    private boolean active;
    private int orderInSystem;
    private String description;
    private String iconPath;
    private String colorCode;
    private String studyGuide;
    private List<SubcategoryPublicViewDTO> subcategories;

    public CategoryPublicViewDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.code = category.getCode();
        this.active = category.isActive();
        this.orderInSystem = category.getOrderInSystem();
        this.description = category.getDescription();
        this.iconPath = category.getIconPath();
        this.colorCode = category.getColorCode();
        this.studyGuide = category.getStudyGuide();
        List<Subcategory> subcategories1 = category.getSubcategories().stream()
                .filter(Subcategory::isActive)
                .filter(s -> s.getCourses().stream().anyMatch(Course::getVisible))
                .toList();
        this.subcategories = SubcategoryPublicViewDTO.toDTO(subcategories1);
    }

    public static List<CategoryPublicViewDTO> toDTO(List<Category> categoryList) {
        return categoryList.stream().map(CategoryPublicViewDTO::new).toList();
    }
}
