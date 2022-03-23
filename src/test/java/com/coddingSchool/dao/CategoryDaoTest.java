package com.coddingSchool.dao;

import com.coddingSchool.model.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDaoTest {

    private EntityManager entityManager;
    private CategoryDao categoryDao;

    @BeforeEach
    void setup() {
        entityManager = Persistence.createEntityManagerFactory("CoddingSchool_test")
                .createEntityManager();
        categoryDao = new CategoryDao(entityManager);
    }

    @Test
    void listAllActiveCategories__devolveAEmptyListIfTheDatabaseIsEmpty() {
        List<Category> categoryList = categoryDao.listAllActiveCategories();
        assertTrue(categoryList.isEmpty());
    }

    @Test
    void listAllActiveCategories__shouldBeDevolveACorrectNumberOfActivesCategories() {
        Category category1 = new Category(
                "First category", "category-code", 1,
                "Category description", true,
                "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png",
                "#00c86f", "");
        Category category2 = new Category(
                "Second category", "category-code", 1,
                "Category description", false,
                "https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png",
                "#00c86f", "");
        categoryDao.insertNewCategory(category1);
        categoryDao.insertNewCategory(category2);
        List<Category> categoryList = categoryDao.listAllActiveCategories();
        assertEquals(1, categoryList.size());
        assertEquals(category1, categoryList.get(0));
    }

    @AfterEach
    void finish() {
        categoryDao.removeAll();
    }

}