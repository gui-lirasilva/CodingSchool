package validations;

public class BooleanValidator {

    public static boolean isActive(String isActive) {
        ObjectValidator.cantBeNull(isActive, "The field 'active' is null");
        return isActive.equals("ATIVA");
    }
}
