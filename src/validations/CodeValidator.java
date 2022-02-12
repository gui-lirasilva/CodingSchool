package validations;

public class CodeValidator {

    public static void cantBeOutPattern(String code, String error) {

        ObjectValidator.cantBeNull(code, error);

        StringValidator.cantBeEmpty(code, error);

        if (!code.matches("[a-z0-9^-]+")){
            throw new IllegalArgumentException(error);
        }
    }
}
