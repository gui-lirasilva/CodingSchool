package br.com.coddingSchool.dto;

import br.com.coddingSchool.model.Category;

public class CategoryFormDTO {

    private final String name;
    private final String code;
    private final int order;
    private final String description;
    private final boolean active;
    private final String iconPath;
    private final String colorCode;
    private final String studyGuide;

    public CategoryFormDTO(String name, String code, int order, String description, boolean active,
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
}
