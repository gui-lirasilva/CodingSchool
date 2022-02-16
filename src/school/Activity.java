package school;

import validations.CodeValidator;
import validations.ObjectValidator;
import validations.StringValidator;

public abstract class Activity {

    private String title;
    private String code;
    private boolean active;
    private int order;
    private Section section;

    public Activity(String title, String code, Section section) {

        StringValidator.cantBeEmpty(title, "The title can't be empty");

        CodeValidator.cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");

        ObjectValidator.cantBeNull(section, "The section can't be null");

        this.title = title;
        this.code = code;
        this.section = section;
    }
}
