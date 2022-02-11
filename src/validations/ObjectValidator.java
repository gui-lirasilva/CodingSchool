package validations;

public class ObjectValidator {

    public static void cantBeNull (Object object, String error) {
            if (object==null){
                throw new NullPointerException(error);
            }
    }
}
