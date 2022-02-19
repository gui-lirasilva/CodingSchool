package validations;

import static validations.ObjectValidator.cantBeNull;

public class NumberValidator {

    public static Integer transformOnInteger(String integer) {
        cantBeNull(integer, "The order number is null");
        return integer.equals("") ? 0 : Integer.parseInt(integer);
    }
}
