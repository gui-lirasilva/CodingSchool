package br.com.coddingSchool.dto.form;

import br.com.coddingSchool.model.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UpdateCategoryForm {

    private Long id;
    @NotBlank(message = "{name.empty.null}")
    private String name;
    @Pattern(regexp = "[a-z0-9^-]+", message = "{code.invalid.pattern}")
    private String code;
    private int orderInSystem;
    @NotBlank(message = "{description.empty.null}")
    private String description;
    private boolean active;
    @NotBlank(message = "{icon.path.empty.null}")
    private String iconPath;
    @Pattern(regexp = "^#([a-fA-F0-9]){3}(([a-fA-F0-9]){3})?$", message = "{code.hexadecimal.pattern}")
    private String colorCode;
    private String studyGuide;

    public UpdateCategoryForm() {
    }

    public UpdateCategoryForm(Category category) {
        this.name = category.getName();
        this.code = category.getCode();
        this.active = category.isActive();
        this.description = category.getDescription();
        this.iconPath = category.getIconPath();
        this.colorCode = category.getColorCode();
        this.studyGuide = category.getStudyGuide();
    }

    public UpdateCategoryForm(String name, String code, int orderInSystem, String description, boolean active,
                              String iconPath, String colorCode, String studyGuide) {
        this.name = name;
        this.code = code;
        this.orderInSystem = orderInSystem;
        this.description = description;
        this.active = active;
        this.iconPath = iconPath;
        this.colorCode = colorCode;
        this.studyGuide = studyGuide;
    }

    public Category toEntity() {
        return new Category(name, code, orderInSystem, description, active, iconPath, colorCode, studyGuide);
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

    public int getOrderInSystem() {
        return orderInSystem;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setOrderInSystem(int orderInSystem) {
        this.orderInSystem = orderInSystem;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public void setStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
