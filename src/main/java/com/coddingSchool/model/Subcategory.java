package com.coddingSchool.model;

import com.coddingSchool.validations.ObjectValidator;
import com.coddingSchool.validations.StringValidator;

import static com.coddingSchool.validations.CodeValidator.cantBeOutPattern;

public class Subcategory {

    private Long id;
    private String name;
    private String code;
    private int order;
    private String description;
    private boolean active;
    private Category category;
    private String studyGuide;

    public Subcategory() {

    }

    public Subcategory(String name, String code, int order, String description, boolean active, Category category) {

        StringValidator.cantBeBlank(name, "The name can't be empty or null");

        cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");

        ObjectValidator.cantBeNull(description, "The subcategory description can't be null");

        ObjectValidator.cantBeNull(category, "The category can't be null");

        this.name = name;
        this.code = code;
        this.order = order;
        this.description = description;
        this.active = active;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public String getStudyGuide() {
        return studyGuide;
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

    public boolean getActive() {
        return active;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", studyGuide='" + studyGuide + '\'' +
                ", active=" + active +
                ", order=" + order +
                ", category=" + category.getName() +
                '}';
    }
}
