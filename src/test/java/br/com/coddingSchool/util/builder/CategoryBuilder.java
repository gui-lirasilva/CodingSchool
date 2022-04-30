package br.com.coddingSchool.util.builder;

import br.com.coddingSchool.model.Category;

public class CategoryBuilder {

    private String name;
    private String code;
    private int orderInSystem;
    private String description;
    private boolean active;
    private String iconPath;
    private String colorCode;
    private String studyGuide;

    public CategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CategoryBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public CategoryBuilder withOrderInSystem(int order) {
        this.orderInSystem = order;
        return this;
    }

    public CategoryBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryBuilder withActive(boolean active) {
        this.active = active;
        return this;
    }

    public CategoryBuilder withIconpath(String iconPath) {
        this.iconPath = iconPath;
        return this;
    }

    public CategoryBuilder withColorCode(String colorCode) {
        this.colorCode = colorCode;
        return this;
    }

    public CategoryBuilder withStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
        return this;
    }

    public Category buildComplete() {
        return new Category(name, code, orderInSystem, description, active, iconPath, colorCode, studyGuide);
    }

    public Category build() {
        return new Category(name, code, orderInSystem, colorCode, studyGuide);
    }
}
