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

        StringValidator.cantBeBlank(name, "The name can't be null or empty");

        CodeValidator.cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");

        ObjectValidator.cantBeNull(course, "The course can't be null");

        this.name = name;
        this.code = code;
        this.course = course;
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
