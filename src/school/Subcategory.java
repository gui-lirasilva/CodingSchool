package school;

import static validations.CodeValidator.cantBeOutPattern;
import static validations.ObjectValidator.cantBeNull;
import static validations.StringValidator.cantBeBlank;

public class Subcategory {

    private String name;
    private String code;
    private Integer order;
    private String description;
    private boolean active;
    private Category category;
    private String studyGuide;

    public Subcategory(String name, String code, Integer order, String description, boolean active, Category category) {

        cantBeBlank(name, "The name can't be empty or null");

        cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");

        cantBeNull(order, "The order number can't be null");

        cantBeNull(description, "The subcategory description can't be null");

        cantBeNull(category, "The category can't be null");

        this.name = name;
        this.code = code;
        this.order = order;
        this.description = description;
        this.active = active;
        this.category = category;
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
                ", category=" + category +
                '}';
    }
}
