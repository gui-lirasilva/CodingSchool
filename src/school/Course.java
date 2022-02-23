package school;

import static validations.CodeValidator.cantBeOutPattern;
import static validations.EstimatedTimeValidator.timeValidator;
import static validations.ObjectValidator.cantBeNull;
import static validations.StringValidator.cantBeBlank;

public class Course {

    private String name;
    private String code;
    private int estimatedTime;
    private boolean visible;
    private String target;
    private String instructor;
    private String description;
    private String developedSkills;
    private Subcategory subcategory;

    public Course(String name, String code, int estimatedTime, boolean visible, String target, String instructor, String description, String developedSkills, Subcategory subcategory) {

        cantBeBlank(name, "The name can't be null or empty");

        cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");

        timeValidator(estimatedTime, "The estimated time can't be smaller 1 or bigger than 20");

        cantBeBlank(instructor, "The instructor name can't be null or empty");

        cantBeNull(subcategory, "The sub category can't be null");

        this.name = name;
        this.code = code;
        this.estimatedTime = estimatedTime;
        this.visible = visible;
        this.target = target;
        this.instructor = instructor;
        this.description = description;
        this.developedSkills = developedSkills;
        this.subcategory = subcategory;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public boolean isVisible() {
        return visible;
    }

    public String getTarget() {
        return target;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getDescription() {
        return description;
    }

    public String getDevelopedSkills() {
        return developedSkills;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", estimatedTime=" + estimatedTime +
                ", target='" + target + '\'' +
                ", instructor='" + instructor + '\'' +
                ", description='" + description + '\'' +
                ", developedSkills='" + developedSkills + '\'' +
                ", visible=" + visible +
                ", subcategory=" + subcategory +
                '}';
    }
}
