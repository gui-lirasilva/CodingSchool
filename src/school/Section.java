package school;

import validations.CodeValidator;
import validations.ObjectValidator;
import validations.StringValidator;

public class Section {

    private String name;
    private String code;
    private int order;
    private boolean active;
    private boolean test;
    private Course course;

    public Section(String name, String code, Course course) {

        StringValidator.cantBeBlank(name, "The name can't be empty or null");
        this.name = name;

        CodeValidator.cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;

        ObjectValidator.cantBeNull(course, "The course can't be null");
        this.course = course;
    }

    public Section(String name, String code, int order, boolean active, boolean test, Course course) {

        StringValidator.cantBeBlank(name, "The name can't be empty or null");
        this.name = name;

        CodeValidator.cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;

        ObjectValidator.cantBeNull(course, "The course can't be null");
        this.course = course;

        this.order = order;
        this.active = active;
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getOrder() {
        return order;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isTest() {
        return test;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Section{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", order=" + order +
                ", active=" + active +
                ", test=" + test +
                ", course=" + course +
                '}';
    }
}
