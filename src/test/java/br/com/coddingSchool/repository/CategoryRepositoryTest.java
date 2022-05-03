package br.com.coddingSchool.repository;

import br.com.coddingSchool.DatabaseTestEnvironment;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.projections.CategoryProjection;
import br.com.coddingSchool.projections.login.CategoryProjectionLogin;
import br.com.coddingSchool.projections.publicView.CategoryProjectionView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest extends DatabaseTestEnvironment {

    @BeforeEach
    void setup() {
        newCategoryDevops();
        newCategoryBusiness();
        newCategoryProgramming();
    }
    @Test
    void findAllByOrderByName__shouldBeDevolveCorrectCategoriesNumber() {
        List<Category> categoryList = categoryRepository.findAllByOrderByName();
        assertEquals(3, categoryList.size());
    }

    @Test
    void findAllByOrderByName__shouldBeDevolveCorrectCategories() {
        List<Category> categoryList = categoryRepository.findAllByOrderByName();
        assertAll("categoryList",
                () -> assertEquals("Business", categoryList.get(0).getName()),
                () -> assertEquals("DevOps", categoryList.get(1).getName()),
                () -> assertEquals("Programação", categoryList.get(2).getName())
        );
    }

    @Test
    void findCategoryByActiveIsTrue__shouldBeDevolveCorrectCategoriesNumber() {
        List<Category> categoryList = categoryRepository.findCategoryByActiveIsTrue();
        assertEquals(2, categoryList.size());
    }

    @Test
    void findCategoryByActiveIsTrue__shouldBeDevolveOnlyActiveCategories() {
        List<Category> categoryList = categoryRepository.findCategoryByActiveIsTrue();
        assertTrue(categoryList.get(0).isActive());
        assertTrue(categoryList.get(1).isActive());
    }

    @Test
    void findAllByOrder__shouldBeDevolveCorrectCategoriesNumberAndNotThrowsException() {
        assertDoesNotThrow(() -> categoryRepository.findAllByOrder(), "Throw exception");
        List<Category> categoryList = categoryRepository.findAllByOrder();
        assertEquals(3, categoryList.size());
    }

    @Test
    void findAllByOrder__shouldBeDevolveAllCategoriesOrderByOrerInSystem() {
        List<Category> categoryList = categoryRepository.findAllByOrder();
        assertAll("categoryList",
                () -> assertEquals("DevOps", categoryList.get(0).getName()),
                () -> assertEquals("Business", categoryList.get(1).getName()),
                () -> assertEquals("Programação", categoryList.get(2).getName())
        );
    }

    @Test
    void findByCode__shouldBeNotThrowsExceptionIfRecievesValidCategoryCodeAndThrowsIfReceiveInvalidCode() {
        assertDoesNotThrow(() -> categoryRepository.findByCode("programacao")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)), "Category not found");

        assertThrows(ResponseStatusException.class, () -> categoryRepository.findByCode("invalid-code")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Test
    void findByCode__shouldBeDevolveCorrectCategory() {
        Category category = categoryRepository.findByCode("programacao")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        assertEquals("Programação", category.getName());
    }

    @Transactional
    @Nested
    class categoriesAndCourses {

        @BeforeEach
        void setup() {

            categoryRepository.deleteAll();

            Category devops = newCategoryDevops();
            Category business = newCategoryBusiness();
            Category programming = newCategoryProgramming();

            Subcategory java = newSubcategoryJava(programming);
            Subcategory kotlin = newSubcategoryKotlin(programming);
            Subcategory git = newSubcategoryGit(devops);
            Subcategory aws = newSubcategoryAws(devops);
            Subcategory success = newSubcategorySucesso(business);

            devops.setSubcategories(List.of(git, aws));
            business.setSubcategories(List.of(success));
            programming.setSubcategories(List.of(java, kotlin));

            Course javaPoo = newCourseJava(java);
            Course javaAndSpring = newCourseJavaAndSpringBoot(java);
            Course kotlinInitial = newCourseKotlinInitial(kotlin);
            Course awsEc2 = newCourseAws(aws);
            Course gitGithub = newCourseGitAndGithub(git);
            Course entrepreneur = newCourseEntrepreneur(success);

            java.setCourses(List.of(javaPoo, javaAndSpring));
            kotlin.setCourses(List.of(kotlinInitial));
            git.setCourses(List.of(gitGithub));
            aws.setCourses(List.of(awsEc2));
            success.setCourses(List.of(entrepreneur));
        }

        @Test
        void findCategoryAndCourses__shouldBeDevolveCorrectCategoriesInCorrectOrder() {
            List<CategoryProjection> categoryAndCourses = categoryRepository.findCategoryAndCourses();
            assertAll("categoryAndCourses",
                    () -> assertEquals(3, categoryAndCourses.size()),
                    () -> assertEquals("Programação", categoryAndCourses.get(0).getName()),
                    () -> assertEquals("DevOps", categoryAndCourses.get(1).getName()),
                    () -> assertEquals("Business", categoryAndCourses.get(2).getName())
            );
        }

        @Test
        void findCategoryAndCourses__shouldBeDevolveCorrectCoursesNumber() {
            List<CategoryProjection> categoryAndCourses = categoryRepository.findCategoryAndCourses();
            assertAll("categoryAndCourses",
                    () -> assertEquals(3, categoryAndCourses.get(0).getCoursesNumber()),
                    () -> assertEquals(2, categoryAndCourses.get(1).getCoursesNumber()),
                    () -> assertEquals(1, categoryAndCourses.get(2).getCoursesNumber())
            );
        }

        @Test
        void categoriesProjectionLoginPage__shouldBeDevolveCorrectCategoriesNumber() {
            List<CategoryProjectionLogin> categoryProjectionLogin = categoryRepository.categoriesProjectionLoginPage();
            assertEquals(2, categoryProjectionLogin.size());
        }

        @Test
        void categoriesProjectionLoginPage__shouldBeDevolveOnlyActiveCategories() {
            List<CategoryProjectionLogin> categoryProjectionLogin = categoryRepository.categoriesProjectionLoginPage();

            Category category1 = categoryRepository.findByCode(categoryProjectionLogin.get(0).getCode())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            assertTrue(category1.isActive());

            Category category2 = categoryRepository.findByCode(categoryProjectionLogin.get(1).getCode())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            assertTrue(category2.isActive());
        }

        @Test
        void categoriesProjectionLoginPage__shouldBeDevolveCorrectSubcategoriesNumber() {
            List<CategoryProjectionLogin> categoryProjectionLogin = categoryRepository.categoriesProjectionLoginPage();
            assertEquals(2, categoryProjectionLogin.get(0).getSubcategories().size());
            assertEquals(1, categoryProjectionLogin.get(1).getSubcategories().size());
        }

        @Test
        void categoriesProjectionLoginPage__shouldBeDevolveCorrectCategories() {
            List<CategoryProjectionLogin> categoryProjectionLogin = categoryRepository.categoriesProjectionLoginPage();
            assertEquals("Programação", categoryProjectionLogin.get(0).getName());
            assertEquals("Business", categoryProjectionLogin.get(1).getName());
        }

        @Test
        void categoriesProjectionLoginPage__shouldBeDevolveCorrectSubcategories() {
            List<CategoryProjectionLogin> categoryProjectionLogin = categoryRepository.categoriesProjectionLoginPage();
            assertAll("categoryProjectionLogin",
                () -> assertEquals("Java", categoryProjectionLogin.get(0).getSubcategories().get(0).getName()),
                () -> assertEquals("Sucesso profissional", categoryProjectionLogin.get(1).getSubcategories()
                        .get(0).getName())
            );
        }

        @Test
        void findCategoryProjectionByCode__shouldBeNotThrowAnyExceptionIfRecievesValidCategoryCode() {
            assertDoesNotThrow(() -> categoryRepository.findCategoryProjectionByCode("programacao")
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        }

        @Test
        void findCategoryProjectionByCode__shouldBeThrowExceptionIfRecievesInvalidCategoryCode() {
            assertThrows(ResponseStatusException.class, () -> categoryRepository
                    .findCategoryProjectionByCode("inexistent")
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        }

        @Test
        void findCategoryProjectionByCode__shouldBeDevolveCorrectCategory() {
            CategoryProjectionView programacao = categoryRepository.findCategoryProjectionByCode("programacao")
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            assertEquals("Programação", programacao.getName());

            CategoryProjectionView devops = categoryRepository.findCategoryProjectionByCode("business")
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            assertEquals("Business", devops.getName());
        }

    }
}