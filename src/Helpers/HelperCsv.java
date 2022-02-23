package Helpers;

public class HelperCsv {

    public static boolean isActive(String isActive) {
        return isActive.equals("ATIVA");
    }

    public static boolean isVisible(String isVisible) {
        return isVisible.equals("PÚBLICA");
    }

    public static String isPublic(boolean isPublic) {
        return isPublic ? "PÚBLICO" : "PRIVADO";
    }

    public static String isActive(boolean isActive) {
        return isActive ? "ATIVA" : "INATIVA";
    }

    public static String makeEmpty(String text) {
        return text == null ? text = "" : text;
    }

    public static Integer transformToInteger(String integer) {
        return integer.equals("") ? 0 : Integer.parseInt(integer);
    }
}
