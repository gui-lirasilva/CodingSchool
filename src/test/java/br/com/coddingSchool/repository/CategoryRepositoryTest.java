package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.projections.CategoryProjection;
import br.com.coddingSchool.util.setup.GeneralSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    private void setup() {
        GeneralSetup generalSetup = new GeneralSetup(categoryRepository);
        generalSetup.setupCategories();
    }

    @AfterEach
    void cleanDatabase() {
        categoryRepository.removeAll();
    }

    @Test
    void findAllByOrderByName__shouldBeDevolveCorrectCategoriesAndCorrectOrder() {
        List<Category> categoryList = categoryRepository.findAllByOrderByName();
        assertEquals(3, categoryList.size());
        assertEquals("Business", categoryList.get(0).getName());
        assertEquals("DevOps", categoryList.get(1).getName());
        assertEquals("Programação", categoryList.get(2).getName());
    }

    @Test
    void findCategoryByActiveIsTrue__shouldBeDevolveOnlyActiveCategories() {
        List<Category> categoryList = categoryRepository.findCategoryByActiveIsTrue();
        assertEquals(2, categoryList.size());
        assertTrue(categoryList.get(0).isActive());
        assertTrue(categoryList.get(1).isActive());
    }

    @Test
    void findAllByOrder__shouldBeDevolveAllCategoriesOrdenedByOrder() {
        List<Category> categoryList = categoryRepository.findAllByOrder();
        assertEquals(3, categoryList.size());
        assertEquals("DevOps", categoryList.get(0).getName());
        assertEquals("Business", categoryList.get(1).getName());
        assertEquals("Programação", categoryList.get(2).getName());
    }

    @Test
    void findByCode__shouldBeNotThrowsExceptionIfRecievesValidCategoryCode() {
        assertDoesNotThrow(() -> categoryRepository.findByCode("programacao")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), "Category not found");
    }

    @Test
    void findByCode__shouldBeDevolveACorrectCategory() {
        Category category = categoryRepository.findByCode("programacao")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        assertEquals("Programação", category.getName());
    }

    @Test
    void findByCode__shouldBeThrowsExceptionIfRecievesInvalidCategoryCode() {
        assertThrows(ResponseStatusException.class, () -> categoryRepository.findByCode("invalid-code")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Test
    void findCategoryAndCourses__() {
        List<CategoryProjection> categoryAndCourses = categoryRepository.findCategoryAndCourses();
        assertEquals(3, categoryAndCourses.size());
    }

    @Test
    void categoriesProjectionLoginPage() {
    }

    @Test
    void findCategoryProjectionByCode() {
    }
}