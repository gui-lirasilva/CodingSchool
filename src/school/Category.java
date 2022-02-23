package school;

import static validations.CodeValidator.cantBeOutPattern;
import static validations.CodeValidator.shouldBeHexadecimal;
import static validations.ObjectValidator.cantBeNull;
import static validations.StringValidator.cantBeBlank;

public class Category {

    private String name;
    private String code;
    private Integer order;
    private String description;
    private boolean active;
    private String iconPath;
    private String colorCode;
    private String studyGuide;

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, String code) {
        this(name);
        this.code = code;
    }

    public Category(String name, String code, Integer order, String description, boolean active, String iconPath, String colorCode) {

        cantBeBlank(name, "The name can't be empty or null");

        cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");

        cantBeNull(order, "The order cant't be null");

        cantBeBlank(description, "The category description can't be empty or null");

        cantBeBlank(iconPath, "The icon path can't be empty or null");

        shouldBeHexadecimal(colorCode, "The color code should be hexadecimal");

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
