package run;

import fileWriters.HtmlWriter;

public class HtmlTester {

    static String CATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/planilha-dados-escola - Categoria.csv";
    static String SUBCATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/planilha-dados-escola - Subcategoria.csv";
    static String COURSE_CSV_PATH = "/home/guilherme/Documentos/Level Up/planilha-dados-escola-curso(copia).csv";

    public static void main(String[] args) throws Exception {

        HtmlWriter.createFile(
                CATEGORY_CSV_PATH,
                SUBCATEGORY_CSV_PATH,
                COURSE_CSV_PATH
        );
    }
}
