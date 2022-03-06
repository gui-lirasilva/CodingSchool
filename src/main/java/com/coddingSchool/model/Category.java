package com.coddingSchool.model;

import com.coddingSchool.validations.CodeValidator;
import com.coddingSchool.validations.StringValidator;

public class Category {

    private String name;
    private String code;
    private int order;
    private String description;
    private boolean active;
    private String iconPath;
    private String colorCode;
    private String studyGuide;

    public Category(String name, String code, int order, String description, boolean active, String iconPath, String colorCode) {

        StringValidator.cantBeBlank(name, "The name can't be empty or null");

        CodeValidator.cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");

        StringValidator.cantBeBlank(description, "The category description can't be empty or null");

        StringValidator.cantBeBlank(iconPath, "The icon path can't be empty or null");

        CodeValidator.shouldBeHexadecimal(colorCode, "The color code should be hexadecimal");

        this.name = name;
        this.code = code;
        this.order = order;
        this.description = description;
        this.active = active;
        this.iconPath = iconPath;
        this.colorCode = colorCode;
    }
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Integer getOrder() {
        return order;
    }

    public String getDescription() {
        return description;
    }

    public boolean getActive() {
        return active;
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getColorCode() {
        return colorCode;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", studyGuide='" + studyGuide + '\'' +
                ", active=" + active +
                ", order=" + order +
                ", icon='" + iconPath + '\'' +
                ", color='" + colorCode + '\'' +
                '}';
    }
}
