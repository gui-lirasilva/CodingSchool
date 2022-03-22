package com.coddingSchool.dao;

import com.coddingSchool.model.Category;
import com.coddingSchool.model.Subcategory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubcategoryDaoTest {

    private EntityManager entityManager;
    private SubcategoryDao subcategoryDao;
    private CategoryDao categoryDao;

    @BeforeEach
    void setup() {
        entityManager = Persistence.createEntityManagerFactory("CoddingSchool_test")
                .createEntityManager();
        categoryDao = new CategoryDao(entityManager);
        subcategoryDao = new SubcategoryDao(entityManager);
    }

    @Test
    void listAllActiveSubcategories__devolveAEmptyListIfTheDatabaseIsEmpty() {
        List<Subcategory> subcategoryList = subcategoryDao.listAllActiveSubcategories();
        assertTrue(subcategoryList.isEmpty());
    }

    @Test
    void listAllActiveSubcategories__shouldBeDevolveACorrectNumberOfActivesSubcategories() {
        Category category = new Category(
                "First category", "category-code", 1,
                "Category description", true,
                "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png",
                "#00c86f", "");
        categoryDao.insertNewCategory(category);
        Subcategory subcategory1 = new Subcategory("First subcategory", "java", 1,
                "Subcategory description", true, category, "");
        Subcategory subcategory2 = new Subcategory("Second subcategory", "java", 2,
                "Subcategory description", false, category, "");
        subcategoryDao.insertNewSubcategory(subcategory1);
        subcategoryDao.insertNewSubcategory(subcategory2);
        List<Subcategory> subcategoryList = subcategoryDao.listAllActiveSubcategories();
        assertEquals(1, subcategoryList.size());
    }

    @Test
    void listAllActiveSubcategories__shouldBeDevolveACorrectSubcategory() {
        Category category = new Category(
                "First category", "category-code", 1,
                "Category description", true,
                "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png",
                "#00c86f", "");
        categoryDao.insertNewCategory(category);
        Subcategory subcategory = new Subcategory("First subcategory", "java", 1,
                "Subcategory description", true, category, "");
        subcategoryDao.insertNewSubcategory(subcategory);
        List<Subcategory> subcategoryList = subcategoryDao.listAllActiveSubcategories();
        assertEquals(subcategory, subcategoryList.get(0));
    }

    @Test
    void listAllSubcategoriesWithoutDescription__shouldBeDevolveOnlySubcategoriesWithoutDescription() {
        Category category = new Category(
                "First category", "category-code", 1,
                "Category description", true,
                "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png",
                "#00c86f", "");
        categoryDao.insertNewCategory(category);
        Subcategory subcategory1 = new Subcategory("First subcategory", "java", 1,
                "Subcategory description", true, category, "");
        Subcategory subcategory2 = new Subcategory("Second subcategory", "java", 2,
                "", false, category, "");
        subcategoryDao.insertNewSubcategory(subcategory1);
        subcategoryDao.insertNewSubcategory(subcategory2);
        List<Subcategory> subcategoryList = subcategoryDao.listAllSubcategoriesWithoutDescription();
        assertEquals(1, subcategoryList.size());
    }

    @Test
    void listAllSubcategoriesWithoutDescription__shouldBeDevolveACorrectSubcategoryWithoutDescription() {
        Category category = new Category(
                "First category", "category-code", 1,
                "Category description", true,
                "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png",
                "#00c86f", "");
        categoryDao.insertNewCategory(category);
        Subcategory subcategory = new Subcategory("Second subcategory", "java", 2,
                "", true, category, "");
        subcategoryDao.insertNewSubcategory(subcategory);
        List<Subcategory> subcategoryList = subcategoryDao.listAllSubcategoriesWithoutDescription();
        assertEquals(subcategory, subcategoryList.get(0));
    }

    @Test
    void listAllSubcategoriesWithoutDescription__shouldBeDevolveAEmptyListIfDontExistSubcategoriesWithoutDescription() {
        Category category = new Category(
                "First category", "category-code", 1,
                "Category description", true,
                "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png",
                "#00c86f", "");
        categoryDao.insertNewCategory(category);
        Subcategory subcategory = new Subcategory("Second subcategory", "java", 2,
                "description", true, category, "");
        subcategoryDao.insertNewSubcategory(subcategory);
        List<Subcategory> subcategoryList = subcategoryDao.listAllSubcategoriesWithoutDescription();
        assertTrue(subcategoryList.isEmpty());
    }

    @AfterEach
    void finish() {
        subcategoryDao.removeAll();
        categoryDao.removeAll();
    }
}