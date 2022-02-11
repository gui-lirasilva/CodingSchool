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
        this.title = title;

        StringValidator.cantBeEmpty(code, "The code can't be empty");
        CodeValidator.cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;

        ObjectValidator.cantBeNull(section, "The section can't be null");
        this.section = section;
    }

    public Activity(String title, String code, boolean active, int order, Section section) {

        StringValidator.cantBeEmpty(title, "The title can't be empty");
        this.title = title;

        StringValidator.cantBeEmpty(code, "The code can't be empty");
        CodeValidator.cantBeOutPattern(code, "The code must obey the pattern: only lowercase letters and numbers");
        this.code = code;

        ObjectValidator.cantBeNull(section, "The section can't be null");
        this.section = section;

        this.active = active;
        this.order = order;

    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public boolean isActive() {
        return active;
    }

    public int getOrder() {
        return order;
    }

    public Section getSection() {
        return section;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", active=" + active +
                ", order=" + order +
                ", section=" + section +
                '}';
    }
}
