package validations;

public class EstimatedTimeValidator {

    public static void TimeValidator (int time, String error) {
        if (time < 1 || time > 20){
            throw new IllegalArgumentException(error);
        }
    }
}
