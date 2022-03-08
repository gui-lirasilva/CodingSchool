package com.coddingSchool.fileReaders;

import com.coddingSchool.model.Category;
import com.coddingSchool.model.Subcategory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubcategoryReaderTest {

    SubcategoryReaderTest() throws Exception {
    }

    static String SUBCATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/planilha-dados-escola - Subcategoria.csv";
    static String INVALID_SUBCATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/planilha-dados-escola - Subcategoria invalida.csv";
    static String SUBCATEGORIES_WITH_DESCRIPTION_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/planilha-dados-escola - Subcategoria com descricao.csv";
    static String INATIVE_SUBCATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/planilha-dados-escola - Subcategoria inativa.csv";
    static String CATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/planilha-dados-escola - Categoria.csv";

    List<Category> categoryList = CategoryReader.csvReader(CATEGORY_CSV_PATH);
    List<Subcategory> subcategories = SubcategoryReader.csvReader(categoryList, SUBCATEGORY_CSV_PATH);
    List<Subcategory> subcategoriesWithDescription = SubcategoryReader.csvReader(categoryList, SUBCATEGORIES_WITH_DESCRIPTION_CSV_PATH);
    List<Subcategory> inativeSubcategories = SubcategoryReader.csvReader(categoryList, INATIVE_SUBCATEGORY_CSV_PATH);

    @Test
    void csvReader_dontThrowExceptionIfRecieveAValidCsvFile() {
        assertDoesNotThrow(() -> {
            SubcategoryReader.csvReader(categoryList, SUBCATEGORY_CSV_PATH);
        },"Throw exception");
    }

    @Test
    void csvReader_ThrowExceptionIfRecieveAInvalidCsvFile() {
        assertThrows(IllegalArgumentException.class, () -> {
            SubcategoryReader.csvReader(categoryList, INVALID_SUBCATEGORY_CSV_PATH);
        });
    }

    @Test
    void getSubcategoriesWithoutDescription_shouldReturnAListWithOnlySubcategoriesWithoutDescription() {
        assertEquals(2, SubcategoryReader.getSubcategoriesWithoutDescription(subcategories).size());
    }

    @Test
    void getSubcategoriesWithoutDescription_shouldReturnAEmptyListWithRecieveOnlySubcategoriesWithDescription() {
        assertTrue(SubcategoryReader.getSubcategoriesWithoutDescription(subcategoriesWithDescription).isEmpty());
    }

    @Test
    void activeSubcategoriesWithDescription_ShouldReturnZeroWithRecieveOnlyInactivesSubcategories() {
        assertEquals(0, SubcategoryReader.activeSubcategoriesWithDescription(inativeSubcategories));
    }

    @Test
    void activeSubcategoriesWithDescription_ShouldReturnANumberOfActivesSubcategoriesWithDescription() {
        assertEquals(3, SubcategoryReader.activeSubcategoriesWithDescription(subcategories));
    }
}