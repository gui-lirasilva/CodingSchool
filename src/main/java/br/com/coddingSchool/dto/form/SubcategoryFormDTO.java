package br.com.coddingSchool.dto.form;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class SubcategoryFormDTO {

    private Long id;
    @NotBlank(message = "{name.empty.null}")
    private String name;
    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;
    private boolean active;
    private int orderInSystem;
    private String studyGuide;
    @NotBlank(message = "{description.empty.null}")
    private String description;
    @NotNull(message = "{category.null}")
    private Category category;

    public SubcategoryFormDTO() {
    }

    public SubcategoryFormDTO(Long id, String name, String code, boolean active, int orderInSystem, String studyGuide, String description, Category category) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.active = active;
        this.orderInSystem = orderInSystem;
        this.studyGuide = studyGuide;
        this.description = description;
        this.category = category;
    }

    public SubcategoryFormDTO(Subcategory subcategory) {
        this.id = subcategory.getId();
        this.name = subcategory.getName();
        this.code = subcategory.getCode();
        this.orderInSystem = subcategory.getOrderInSystem();
        this.description = subcategory.getDescription();
        this.active = subcategory.isActive();
        this.studyGuide = subcategory.getStudyGuide();
        this.category = subcategory.getCategory();
    }

    public static List<SubcategoryFormDTO> toDTO(List<Subcategory> subcategories) {
        return subcategories.stream().map(SubcategoryFormDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getOrderInSystem() {
        return orderInSystem;
    }

    public void setOrderInSystem(int orderInSystem) {
        this.orderInSystem = orderInSystem;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public void setStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Subcategory toEntity() {
        return new Subcategory(name, code, orderInSystem, description, active, category, studyGuide);
    }
}
