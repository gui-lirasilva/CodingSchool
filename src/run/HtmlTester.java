package run;

import FileWriters.HtmlWriter;

public class HtmlTester {
    public static void main(String[] args) throws Exception {

        HtmlWriter.createFile(
                "/home/guilherme/Documentos/Level Up/planilha-dados-escola - Categoria.csv",
                "/home/guilherme/Documentos/Level Up/planilha-dados-escola - Subcategoria.csv",
                "/home/guilherme/Documentos/Level Up/planilha-dados-escola-curso(copia).csv"
        );
    }
}
