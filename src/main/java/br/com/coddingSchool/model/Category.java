package br.com.coddingSchool.model;

import br.com.coddingSchool.validations.CodeValidator;
import br.com.coddingSchool.validations.StringValidator;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    @Column(name = "`order`")
    private int order;
    @Column(columnDefinition = "text")
    private String description;
    private boolean active;
    @Column(name = "icon_path")
    private String iconPath;
    @Column(name = "color_code")
    private String colorCode;
    @Column(name = "study_guide", columnDefinition = "text")
    private String studyGuide;

    public Category(String name, String code) {

        StringValidator.cantBeBlank(name, "The name can't be empty or null");

        CodeValidator.cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");

        this.name = name;
        this.code = code;
    }

    public Category(String name, String code, int order, String description, boolean active, String iconPath, String colorCode, String studyGuide) {

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
        this.studyGuide = studyGuide;
    }

    public Category() {}

    public void toggleVisibility() {
        this.active = !isActive();
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
