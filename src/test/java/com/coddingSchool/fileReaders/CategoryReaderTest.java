package com.coddingSchool.fileReaders;

import com.coddingSchool.model.Category;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryReaderTest {

    CategoryReaderTest() throws Exception {
    }

    static String VALID_CATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/planilha-dados-escola - Categoria.csv";
    static String INVALID_CATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/planilha-dados-escola - Categoria invalida.csv";
    static String INATIVE_CATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/planilha-dados-escola - Categoria inativa.csv";

    List<Category> categoryList = CategoryReader.csvReader(VALID_CATEGORY_CSV_PATH);
    List<Category> activeCategoryList = categoryList.stream().filter(Category::getActive).toList();
    List<Category> inativeCategoryList = CategoryReader.csvReader(INATIVE_CATEGORY_CSV_PATH);

    @Test
    void csvReader_dontThowExceptionIfRecieveAValidCsvFile() {
        assertDoesNotThrow(() -> {
            CategoryReader.csvReader(VALID_CATEGORY_CSV_PATH);
        });
    }

    @Test
    void csvReader_ThowExceptionIfRecieveAInvalidCsvFile() {
        assertThrows(IllegalArgumentException.class, () -> {
            CategoryReader.csvReader(INVALID_CATEGORY_CSV_PATH);
        });
    }

    @Test
    void getActiveCategories_obtainsOnlyActiveCategories() {
        assertEquals(activeCategoryList, CategoryReader.getActiveCategories(categoryList));
    }

    @Test
    void getActiveCategories_souldDevolveAEmptyListIfRecieveAInativeCategoryList() {
        assertTrue(CategoryReader.getActiveCategories(inativeCategoryList).isEmpty());
    }
}