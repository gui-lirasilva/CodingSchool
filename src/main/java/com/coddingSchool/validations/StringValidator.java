package com.coddingSchool.validations;

public class StringValidator {

    public static void cantBeEmpty(String field, String error) {
        ObjectValidator.cantBeNull(field, error);
        if(field.isEmpty()) {
            throw new IllegalArgumentException(error);
        }
    }

   public static void cantBeBlank(String field, String error) {
        ObjectValidator.cantBeNull(field, error);
        if(field.isBlank()) {
            throw new IllegalArgumentException(error);
        }
   }

}
