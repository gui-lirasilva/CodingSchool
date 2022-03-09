package com.coddingSchool.fileReaders;

import com.coddingSchool.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryReaderTest {

    private String VALID_CATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/" +
            "planilha-dados-escola - Categoria.csv";

    private String INVALID_CATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/" +
            "planilha-dados-escola - Categoria invalida.csv";

    private String INATIVE_CATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/" +
            "planilha-dados-escola - Categoria inativa.csv";

    private List<Category> categoryList;
    private List<Category> activeCategoryList;
    private List<Category> inativeCategoryList;

    @BeforeEach
    void setup()  throws Exception {
        categoryList = CategoryReader.csvReader(VALID_CATEGORY_CSV_PATH);
        activeCategoryList = categoryList.stream().filter(Category::getActive).toList();
        inativeCategoryList = CategoryReader.csvReader(INATIVE_CATEGORY_CSV_PATH);
    }

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