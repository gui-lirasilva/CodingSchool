package school;

import validations.CodeValidator;
import validations.ObjectValidator;
import validations.StringValidator;

public class Category {

    private  String name;
    private String code;
    private String description;
    private String studyGuide;
    private boolean active;
    private int order;
    private String icon;
    private String color;

    public Category(String name, String code) {

        StringValidator.cantBeBlank(name, "The name can't be empty or null");
        this.name = name;

        CodeValidator.cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;
    }

    public Category(String name, String code, String description, String studyGuide, boolean active, int order, String icon, String color) {

        StringValidator.cantBeBlank(name, "The name can't be empty or null");
        this.name = name;

        CodeValidator.cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;

        ObjectValidator.cantBeNull(description, "The description can't be null");
        this.description = description;

        ObjectValidator.cantBeNull(studyGuide, "The study guide can't be null");
        this.studyGuide = studyGuide;

        StringValidator.cantBeBlank(icon, "The path to the icon can't be null");
        this.icon = icon;

        ObjectValidator.cantBeNull(icon, "The hexadecimal code for color can't be null");
        this.color = color;

        this.active = active;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getStudyGuide() {
        return studyGuide;
    }

    public boolean isActive() {
        return active;
    }

    public int getOrder() {
        return order;
    }

    public String getIcon() {
        return icon;
    }

    public String getColor() {
        return color;
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
                ", icon='" + icon + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
