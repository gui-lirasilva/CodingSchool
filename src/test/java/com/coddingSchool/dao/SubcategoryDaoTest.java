package com.coddingSchool.dao;

import com.coddingSchool.builders.CategoryBuilder;
import com.coddingSchool.builders.SubcategoryBuilder;
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

        category = new CategoryBuilder()
                .withName("First category")
                .withCode("category-code")
                .build();
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
            subcategory = new SubcategoryBuilder()
                    .withName("First subcategory")
                    .withCode("java")
                    .withOrder(1)
                    .withDescription("")
                    .withActive(true)
                    .withCategory(category)
                    .withStudyGuide("")
                    .completeBuild();
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
            subcategory = new SubcategoryBuilder()
                    .withName("First subcategory")
                    .withCode("java")
                    .withOrder(1)
                    .withDescription("")
                    .withActive(true)
                    .withCategory(category)
                    .withStudyGuide("")
                    .completeBuild();

            subcategory2 = new SubcategoryBuilder()
                    .withName("First subcategory")
                    .withCode("java")
                    .withOrder(2)
                    .withDescription("Subcategory description")
                    .withActive(false)
                    .withCategory(category)
                    .withStudyGuide("")
                    .completeBuild();
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