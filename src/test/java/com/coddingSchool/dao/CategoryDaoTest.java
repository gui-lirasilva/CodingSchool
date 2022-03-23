package com.coddingSchool.dao;

import com.coddingSchool.builders.CategoryBuilder;
import com.coddingSchool.model.Category;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        Category category1 = new CategoryBuilder()
                .withName("First category")
                .withCode("category-code")
                .withOrder(1)
                .withDescription("Category description")
                .withActive(true)
                .withIconpath("https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png")
                .withColorCode("#00c86f")
                .withStudyGuide("")
                .buildComplete();
        categoryDao.insertNewCategory(category1);

        Category category2 = new CategoryBuilder()
                .withName("Second category")
                .withCode("category-code")
                .withOrder(2)
                .withDescription("Category description")
                .withActive(false)
                .withIconpath("https://www.alura.com.br/assets/api/formacoes/categorias/512/programacao-transparent.png")
                .withColorCode("#00c86f")
                .withStudyGuide("")
                .buildComplete();
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