package school;

import validations.CodeValidator;
import validations.ObjectValidator;
import validations.StringValidator;

public class Subcategory {

    private String name; // Obrigatório e não vazio
    private String code; // Obrigatório, não vazio e Regex
    private String description;
    private String studyGuide;
    private boolean active;
    private int order;
    private Category category; // Obrigatória

    public Subcategory(String name, String code, Category category) {

        StringValidator.cantBeEmpty(name, "The name can't be empty");
        this.name = name;

        CodeValidator.cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;

        ObjectValidator.cantBeNull(category, "The category can't be null");
        this.category = category;
    }

    public Subcategory(String name, String code, String description, String studyGuide, boolean active, int order, Category category) {

        StringValidator.cantBeEmpty(name, "The name can't be empty");
        this.name = name;

        CodeValidator.cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;

        ObjectValidator.cantBeNull(category, "The category can't be null");
        this.category = category;

        this.description = description;
        this.studyGuide = studyGuide;
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
                ", category=" + category +
                '}';
    }
}
