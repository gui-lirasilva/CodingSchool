package school;

import static validations.CodeValidator.cantBeOutPattern;
import static validations.StringValidator.cantBeBlank;

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

        cantBeBlank(name, "The name can't be empty or null");

        cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");

        this.name = name;
        this.code = code;
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
