package school;

import static validations.CodeValidator.cantBeOutPattern;
import static validations.ObjectValidator.cantBeNull;
import static validations.StringValidator.cantBeBlank;

public class Subcategory {

    private String name;
    private String code;
    private String description;
    private String studyGuide;
    private boolean active;
    private int order;
    private Category category;

    public Subcategory(String name, String code, Category category) {

        cantBeBlank(name, "The name can't be empty or null");

        cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");

        cantBeNull(category, "The category can't be null");

        this.name = name;
        this.code = code;
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
