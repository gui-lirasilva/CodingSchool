package school;

import validations.CodeValidator;
import validations.ObjectValidator;
import validations.StringValidator;

public class Subcategory {

    private String name;
    private String code;
    private String description;
    private String studyGuide;
    private boolean active;
    private int order;
    private Category category;

    public Subcategory(String name, String code, Category category) {

        StringValidator.cantBeBlank(name, "The name can't be empty or null");
        this.name = name;

        CodeValidator.cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;

        ObjectValidator.cantBeNull(category, "The category can't be null");
        this.category = category;
    }

    public Subcategory(String name, String code, String description, String studyGuide, boolean active, int order, Category category) {

        StringValidator.cantBeBlank(name, "The name can't be empty or null");
        this.name = name;

        CodeValidator.cantBeOutPattern(code,"The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;

        ObjectValidator.cantBeNull(category, "The category can't be null");
        this.category = category;

        StringValidator.cantBeNull(description, "The description can't be null");
        this.description = description;

        StringValidator.cantBeNull(studyGuide, "The study guide can't be null");
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
