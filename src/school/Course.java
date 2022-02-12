package school;

import validations.CodeValidator;
import validations.EstimatedTimeValidator;
import validations.ObjectValidator;
import validations.StringValidator;

public class Course {

    private String name;
    private String code;
    private int estimatedTime;
    private String target;
    private String instructor;
    private String description;
    private String developedSkills;
    private boolean visible;
    private Subcategory subcategory;

    public Course(String name, String code, int estimatedTime, String instructor, Subcategory subcategory) {

        StringValidator.cantBeBlank(name, "The name can't be null or empty");
        this.name = name;

        CodeValidator.cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;

        EstimatedTimeValidator.TimeValidator(estimatedTime, "The estimated time can't be smaller 1 or bigger than 20");
        this.estimatedTime = estimatedTime;

        StringValidator.cantBeBlank(instructor, "The instructor name can't be null or empty");
        this.instructor = instructor;

        ObjectValidator.cantBeNull(subcategory, "The sub category can't be null");
        this.subcategory = subcategory;
    }

    public Course(String name, String code, int estimatedTime, String target, String instructor, String description, String developedSkills, boolean visible, Subcategory subcategory) {

        StringValidator.cantBeBlank(name, "The name can't be null or empty");
        this.name = name;

        CodeValidator.cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;

        EstimatedTimeValidator.TimeValidator(estimatedTime, "The estimated time can't be smaller 1 or bigger than 20");
        this.estimatedTime = estimatedTime;

        StringValidator.cantBeBlank(instructor, "The instructor name can't be null or empty");
        this.instructor = instructor;

        ObjectValidator.cantBeNull(subcategory, "The sub category can't be null");
        this.subcategory = subcategory;

        StringValidator.cantBeNull(target, "The target can't be null");
        this.target = target;

        StringValidator.cantBeNull(description, "The description can't be null");
        this.description = description;

        StringValidator.cantBeNull(developedSkills, "The developed skills can't be null");
        this.developedSkills = developedSkills;

        this.visible = visible;
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

    public boolean isVisible() {
        return visible;
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
