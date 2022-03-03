package school;

import static validations.CodeValidator.cantBeOutPattern;
import static validations.ObjectValidator.cantBeNull;
import static validations.StringValidator.cantBeEmpty;

public abstract class Activity {

    private String title;
    private String code;
    private boolean active;
    private int order;
    private Section section;

    public Activity(String title, String code, Section section) {

        cantBeEmpty(title, "The title can't be empty");

        cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");

        cantBeNull(section, "The section can't be null");

        this.title = title;
        this.code = code;
        this.section = section;
    }
}
