package validations;

public class StringValidator {

    public static void cantBeNull(String field, String error) {
        if (field==null){
            throw new NullPointerException(error);
        }
    }

    public static void cantBeEmpty(String field, String error) {
        if(field.isEmpty()){
            throw new IllegalArgumentException(error);
        }
    }

   public static void cantBeBlank(String field, String error) {
        if(field.isBlank()) {
            throw new NullPointerException(error);
        }
   }
}
