package run;

import FileReaders.CategoryReader;

public class CsvReader {

    public static void main(String[] args) throws Exception{

        CategoryReader.listCategories("/home/guilherme/Documentos/Level Up/planilha-dados-escola - Categoria.csv");

    }
}