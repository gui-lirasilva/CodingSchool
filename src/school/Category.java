package school;

import validations.CodeValidator;
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

        StringValidator.cantBeEmpty(name, "The name can't be empty");
        this.name = name;

        CodeValidator.cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;
    }

    public Category(String name, String code, String description, String studyGuide, boolean active, int order, String icon, String color) {

        StringValidator.cantBeEmpty(name, "The name can't be empty");
        this.name = name;

        CodeValidator.cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;

        this.description = description;
        this.studyGuide = studyGuide;
        this.active = active;
        this.order = order;
        this.icon = icon;
        this.color = color;
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
