package validations;

import static validations.ObjectValidator.cantBeNull;

public class BooleanValidator {

    public static boolean isActive(String isActive) {
        cantBeNull(isActive, "The field 'active' is null");
        return isActive.equals("ATIVA");
    }
}
