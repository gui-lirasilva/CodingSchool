package br.com.coddingSchool.helpers;

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

    public static Integer transformToInteger(String integer) {
        return integer.equals("") ? 0 : Integer.parseInt(integer);
    }
}
