package br.com.coddingSchool.util.builder;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Subcategory;

public class SubcategoryBuilder {

    private String name;
    private String code;
    private int orderInSystem;
    private String description;
    private boolean active;
    private Category category;
    private String studyGuide;

    public SubcategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public SubcategoryBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public SubcategoryBuilder withOrderInSystem(int order) {
        this.orderInSystem = order;
        return this;
    }

    public SubcategoryBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public SubcategoryBuilder withActive(boolean active) {
        this.active = active;
        return this;
    }

    public SubcategoryBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public SubcategoryBuilder withStudyGuide(String studyGuide) {
        this.studyGuide = studyGuide;
        return this;
    }

    public Subcategory completeBuild() {
        return new Subcategory(name, code, orderInSystem, description, active, category, studyGuide);
    }

    public Subcategory build() {
        return new Subcategory(name, code, active, category);
    }
}
