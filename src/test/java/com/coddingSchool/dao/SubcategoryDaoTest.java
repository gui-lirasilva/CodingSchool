package com.coddingSchool.dao;

import com.coddingSchool.model.Category;
import com.coddingSchool.model.Subcategory;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubcategoryDaoTest {

    private EntityManager entityManager;
    private SubcategoryDao subcategoryDao;
    private CategoryDao categoryDao;
    private Category category;
    Subcategory subcategory;
    Subcategory subcategory2;

    @BeforeEach
    void setup() {
        entityManager = Persistence.createEntityManagerFactory("CoddingSchool_test")
                .createEntityManager();
        categoryDao = new CategoryDao(entityManager);
        subcategoryDao = new SubcategoryDao(entityManager);

        category = new Category(
                "First category", "category-code", 1,
                "Category description", true,
                "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png",
                "#00c86f", "");
        categoryDao.insertNewCategory(category);
    }

    @Test
    void listAllActiveSubcategories__devolveAEmptyListIfTheDatabaseIsEmpty() {
        List<Subcategory> subcategoryList = subcategoryDao.listAllActiveSubcategories();
        assertTrue(subcategoryList.isEmpty());
    }

    @Nested
    class TestsWithOneSubcategory {

        @BeforeEach
        void setup2() {
            subcategory = new Subcategory("First subcategory", "java", 1,
                    "", true, category, "");
            subcategoryDao.insertNewSubcategory(subcategory);
        }

        @Test
        void listAllActiveSubcategories__shouldBeDevolveACorrectSubcategory() {
            List<Subcategory> subcategoryList = subcategoryDao.listAllActiveSubcategories();
            assertEquals(subcategory, subcategoryList.get(0));
        }

        @Test
        void listAllSubcategoriesWithoutDescription__shouldBeDevolveAEmptyListIfDontExistSubcategoriesWithoutDescription() {
            subcategoryDao.removeAll();
            subcategoryDao.insertNewSubcategory(subcategory);
            List<Subcategory> subcategoryList = subcategoryDao.listAllSubcategoriesWithoutDescription();
            assertTrue(subcategoryList.isEmpty());
        }

        @Test
        void listAllSubcategoriesWithoutDescription__shouldBeDevolveACorrectSubcategoryWithoutDescription() {
            List<Subcategory> subcategoryList = subcategoryDao.listAllSubcategoriesWithoutDescription();
            assertEquals(subcategory, subcategoryList.get(0));
        }

    }

    @Nested
    class TestsWithTwoSubcategories {

        @BeforeEach
        void setup3() {
            subcategory = new Subcategory("First subcategory", "java", 1,
                    "", true, category, "");
            subcategory2 = new Subcategory("Second subcategory", "java", 2,
                    "Subcategory description", false, category, "");
        }

        @Test
        void listAllActiveSubcategories__shouldBeDevolveACorrectNumberOfActivesSubcategories() {
            subcategoryDao.insertNewSubcategory(subcategory);
            subcategoryDao.insertNewSubcategory(subcategory2);
            List<Subcategory> subcategoryList = subcategoryDao.listAllActiveSubcategories();
            assertEquals(1, subcategoryList.size());
        }

        @Test
        void listAllSubcategoriesWithoutDescription__shouldBeDevolveOnlySubcategoriesWithoutDescription() {
            subcategoryDao.insertNewSubcategory(subcategory);
            subcategoryDao.insertNewSubcategory(subcategory2);
            List<Subcategory> subcategoryList = subcategoryDao.listAllSubcategoriesWithoutDescription();
            assertEquals(1, subcategoryList.size());
        }
    }

    @AfterEach
    void finish() {
        subcategoryDao.removeAll();
        categoryDao.removeAll();
    }

}