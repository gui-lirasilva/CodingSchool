package school;

import validations.*;

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

        CodeValidator.cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");

        EstimatedTimeValidator.timeValidator(estimatedTime, "The estimated time can't be smaller 1 or bigger than 20");

        StringValidator.cantBeBlank(instructor, "The instructor name can't be null or empty");

        ObjectValidator.cantBeNull(subcategory, "The sub category can't be null");

        this.name = name;
        this.code = code;
        this.estimatedTime = estimatedTime;
        this.instructor = instructor;
        this.subcategory = subcategory;
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
