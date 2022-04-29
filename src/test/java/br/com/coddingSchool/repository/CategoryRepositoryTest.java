package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.projections.CategoryProjection;
import br.com.coddingSchool.projections.login.CategoryProjectionLogin;
import br.com.coddingSchool.projections.login.SubcategoryProjectionLogin;
import br.com.coddingSchool.projections.publicView.CategoryProjectionView;
import br.com.coddingSchool.util.setup.GeneralSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    private void setup() {
        GeneralSetup generalSetup = new GeneralSetup(categoryRepository);
        generalSetup.setupCategories();
    }

    @AfterEach
    void cleanDatabase() {
        categoryRepository.deleteAll();
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
        assertDoesNotThrow(() -> categoryRepository.findAllByOrder(), "Throw exception");
        List<Category> categoryList = categoryRepository.findAllByOrder();
        assertEquals(3, categoryList.size());
        assertEquals("DevOps", categoryList.get(0).getName());
        assertEquals("Business", categoryList.get(1).getName());
        assertEquals("Programação", categoryList.get(2).getName());
    }

    @Test // TODO: renomear
    void findByCode__shouldBeNotThrowsExceptionIfRecievesValidCategoryCode() {
        assertDoesNotThrow(() -> categoryRepository.findByCode("programacao")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), "Category not found");

        assertThrows(ResponseStatusException.class, () -> categoryRepository.findByCode("invalid-code")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

        Category category = categoryRepository.findByCode("programacao")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        assertEquals("Programação", category.getName());
    }

    @Nested
    class categoriesAndCourses {

        @Autowired
        private CategoryRepository categoryRepository;

        @Autowired
        private SubcategoryRepository subcategoryRepository;

        @Autowired
        private CourseRepository courseRepository;

        @BeforeEach
        private void setup() {
            categoryRepository.deleteAll();
            GeneralSetup generalSetup = new GeneralSetup(categoryRepository, subcategoryRepository, courseRepository);
            generalSetup.setupCourses();
        }

        @AfterEach
        void cleanDatabase() {
            courseRepository.deleteAll();
            subcategoryRepository.deleteAll();
            categoryRepository.deleteAll();
        }

        @Test
        void findCategoryAndCourses__shouldBeDevolveCorrectNumberOfCoursesAndCorrectCategories() {
            List<CategoryProjection> categoryAndCourses = categoryRepository.findCategoryAndCourses();
            assertEquals(3, categoryAndCourses.size());
            assertThrows(IndexOutOfBoundsException.class, () -> categoryAndCourses.get(3));
            assertEquals("Programação", categoryAndCourses.get(0).getName());
            assertEquals("DevOps", categoryAndCourses.get(1).getName());
            assertEquals("Business", categoryAndCourses.get(2).getName());
            assertEquals(3, categoryAndCourses.get(0).getCoursesNumber());
            assertEquals(2, categoryAndCourses.get(1).getCoursesNumber());
            assertEquals(1, categoryAndCourses.get(2).getCoursesNumber());
        }

        @Test //TODO: Entender porque não está vindo com as subcategorias e completar o nome
        void categoriesProjectionLoginPage__shouldBeDevolveCorrectNumberOfCategoriesAndOnlyActiveCategories() {
            List<CategoryProjectionLogin> categoryProjectionLogin = categoryRepository.categoriesProjectionLoginPage();

            assertEquals(2, categoryProjectionLogin.size());
            assertEquals("Programação", categoryProjectionLogin.get(0).getName());
            assertEquals("Business", categoryProjectionLogin.get(1).getName());

            List<SubcategoryProjectionLogin> subcategories = categoryProjectionLogin.get(0).getSubcategories();
            System.out.println("======================" + subcategories + "======================");

            Category category1 = categoryRepository.findByCode(categoryProjectionLogin.get(0).getCode())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            assertTrue(category1.isActive());

            Category category2 = categoryRepository.findByCode(categoryProjectionLogin.get(1).getCode())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            assertTrue(category2.isActive());
        }

        @Test //TODO: Entender porque não está vindo com as subcategorias e completar o nome
        void findCategoryProjectionByCode() {
            assertDoesNotThrow(() -> categoryRepository.findCategoryProjectionByCode("programacao")
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

            assertThrows(ResponseStatusException.class, () -> categoryRepository
                    .findCategoryProjectionByCode("inexistent")
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

            CategoryProjectionView programacao = categoryRepository.findCategoryProjectionByCode("programacao")
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            assertEquals("Programação", programacao.getName());
        }

    }
}