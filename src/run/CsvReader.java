package run;

import static FileReaders.CategoryReader.listCategories;
import static FileReaders.SubcategoryReader.listSubcategories;

public class CsvReader {

    public static void main(String[] args) throws Exception{

        listCategories("/home/guilherme/Documentos/Level Up/planilha-dados-escola - Categoria.csv");

        listSubcategories("/home/guilherme/Documentos/Level Up/planilha-dados-escola - Subcategoria.csv");
    }
}