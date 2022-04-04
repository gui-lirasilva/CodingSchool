package br.com.coddingSchool.dto.form;

import br.com.coddingSchool.model.Category;

public class UpdateCategoryForm {

    private Long id;
    private String name;
    private String code;
    private int order;
    private String description;
    private boolean active;
    private String iconPath;
    private String colorCode;
    private String studyGuide;

    public UpdateCategoryForm() {
    }

    public UpdateCategoryForm(Category category) {
//        this.id = category.getId();
        this.name = category.getName();
        this.code = category.getCode();
        this.active = category.getActive();
        this.description = category.getDescription();
        this.iconPath = category.getIconPath();
        this.colorCode = category.getColorCode();
        this.studyGuide = category.getStudyGuide();
    }

    public UpdateCategoryForm(String name, String code, int order, String description, boolean active,
                           String iconPath, String colorCode, String studyGuide) {
        this.name = name;
        this.code = code;
        this.order = order;
        this.description = description;
        this.active = active;
        this.iconPath = iconPath;
        this.colorCode = colorCode;
        this.studyGuide = studyGuide;
    }

    public Category toEntity() {
        return new Category(name, code, order, description, active, iconPath, colorCode, studyGuide);
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setOrder(int order) {
        this.order = order;
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
}
