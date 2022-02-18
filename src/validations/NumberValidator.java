package validations;

public class NumberValidator {

    public static Integer transformOnInteger(String integer) {
        return integer.equals("") ? 0 : Integer.parseInt(integer);
    }
}
