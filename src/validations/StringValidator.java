package validations;

import static validations.ObjectValidator.cantBeNull;

public class StringValidator {

    public static void cantBeEmpty(String field, String error) {
        cantBeNull(field, error);
        if(field.isEmpty()) {
            throw new IllegalArgumentException(error);
        }
    }

   public static void cantBeBlank(String field, String error) {
        cantBeNull(field, error);
        if(field.isBlank()) {
            throw new IllegalArgumentException(error);
        }
   }

   public static String makeEmpty(String text) {
        return text == null ? text = "" : text;
   }

}
