package com.coddingSchool.fileReaders;

import com.coddingSchool.model.Category;
import com.coddingSchool.model.Subcategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubcategoryReaderTest {

    private String SUBCATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/" +
            "planilha-dados-escola - Subcategoria.csv";

    private String INVALID_SUBCATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/" +
            "planilha-dados-escola - Subcategoria invalida.csv";

    private String SUBCATEGORIES_WITH_DESCRIPTION_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/" +
            "planilha-dados-escola - Subcategoria com descricao.csv";

    private String INATIVE_SUBCATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/" +
            "planilha-dados-escola - Subcategoria inativa.csv";

    private String CATEGORY_CSV_PATH = "/home/guilherme/Documentos/Level Up/csvParaTestes/" +
            "planilha-dados-escola - Categoria.csv";

    private List<Category> categoryList;
    private List<Subcategory> subcategories;
    private List<Subcategory> subcategoriesWithDescription;
    private List<Subcategory> inativeSubcategories;

    @BeforeEach
    void setup() throws Exception {
        categoryList = CategoryReader.csvReader(CATEGORY_CSV_PATH);
        subcategories = SubcategoryReader.csvReader(categoryList, SUBCATEGORY_CSV_PATH);
        subcategoriesWithDescription = SubcategoryReader.csvReader(categoryList, SUBCATEGORIES_WITH_DESCRIPTION_CSV_PATH);
        inativeSubcategories = SubcategoryReader.csvReader(categoryList, INATIVE_SUBCATEGORY_CSV_PATH);
    }

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