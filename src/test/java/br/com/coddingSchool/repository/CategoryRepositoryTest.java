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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    void findAllByOrderByName__should_be_devolve_correct_categories_number() {
        List<Category> categoryList = categoryRepository.findAllByOrderByName();
        assertEquals(3, categoryList.size());
    }

    @Test
    void findAllByOrderByName__should_be_devolve_correct_categories() {
        List<Category> categoryList = categoryRepository.findAllByOrderByName();
        assertAll("categoryList",
                () -> assertEquals("Business", categoryList.get(0).getName()),
                () -> assertEquals("DevOps", categoryList.get(1).getName()),
                () -> assertEquals("Programação", categoryList.get(2).getName())
        );
    }

    @Test
    void findCategoryByActiveIsTrue__should_be_devolve_only_active_categories() {
        List<Category> categoryList = categoryRepository.findCategoryByActiveIsTrue();
        assertAll("categoryList",
                () -> assertEquals(2, categoryList.size()),
                () -> assertTrue(categoryList.get(0).isActive()),
                () -> assertTrue(categoryList.get(1).isActive())
        );
    }

    @Test
    void findAllByOrder__should_be_devolve_all_categories_order_by_order_in_system() {
        List<Category> categoryList = categoryRepository.findAllByOrder();
        assertAll("categoryList",
                () -> assertEquals(3, categoryList.size()),
                () -> assertEquals("DevOps", categoryList.get(0).getName()),
                () -> assertEquals("Business", categoryList.get(1).getName()),
                () -> assertEquals("Programação", categoryList.get(2).getName())
        );
    }

    @Test
    void findByCode__should_be_return_nothing_if_receives_invalid_category_code() {
        Optional<Category> invalidCategory = categoryRepository.findByCode("invalid-code");
        assertFalse(invalidCategory.isPresent());
    }

    @Test
    void findByCode__should_be_devolve_correct_category() {
        Optional<Category> category = categoryRepository.findByCode("programacao");
        assertTrue(category.isPresent());
        assertEquals("Programação", category.get().getName());
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
        void findCategoryAndCourses__should_be_devolve_correct_categories_in_correct_order() {
            List<CategoryProjection> categoryAndCourses = categoryRepository.findCategoryAndCourses();
            assertAll("categoryAndCourses",
                    () -> assertEquals(3, categoryAndCourses.size()),
                    () -> assertEquals("Programação", categoryAndCourses.get(0).getName()),
                    () -> assertEquals("DevOps", categoryAndCourses.get(1).getName()),
                    () -> assertEquals("Business", categoryAndCourses.get(2).getName())
            );
        }

        @Test
        void findCategoryAndCourses__should_be_devolve_correct_courses_number() {
            List<CategoryProjection> categoryAndCourses = categoryRepository.findCategoryAndCourses();
            assertAll("categoryAndCourses",
                    () -> assertEquals(3, categoryAndCourses.get(0).getCoursesNumber()),
                    () -> assertEquals(2, categoryAndCourses.get(1).getCoursesNumber()),
                    () -> assertEquals(1, categoryAndCourses.get(2).getCoursesNumber())
            );
        }

        @Test
        void categoriesProjectionLoginPage__should_be_devolve_correct_categories() {
            List<CategoryProjectionLogin> categoryProjectionLogin = categoryRepository.categoriesProjectionLoginPage();
            assertAll("categoryProjectionLogin",
                    () -> assertEquals(2, categoryProjectionLogin.size()),
                    () -> assertEquals("Programação", categoryProjectionLogin.get(0).getName()),
                    () -> assertEquals("Business", categoryProjectionLogin.get(1).getName())
            );
        }

        @Test
        void categoriesProjectionLoginPage__should_be_devolve_correct_subcategories() {
            List<CategoryProjectionLogin> categoryProjectionLogin = categoryRepository.categoriesProjectionLoginPage();
            assertAll("categoryProjectionLogin",
                    () -> assertEquals(2, categoryProjectionLogin.get(0).getSubcategories().size()),
                    () -> assertEquals(1, categoryProjectionLogin.get(1).getSubcategories().size()),
                    () -> assertEquals("Java", categoryProjectionLogin.get(0).getSubcategories().get(0).getName()),
                    () -> assertEquals("Sucesso profissional", categoryProjectionLogin.get(1).getSubcategories()
                            .get(0).getName())
            );
        }

        @Test
        void categoriesProjectionLoginPage__should_be_devolve_onlyActiveCategories() {
            List<CategoryProjectionLogin> categoryProjectionLogin = categoryRepository.categoriesProjectionLoginPage();

            Optional<Category> category1 = categoryRepository.findByCode(categoryProjectionLogin.get(0).getCode());
            assertTrue(category1.isPresent());
            assertTrue(category1.get().isActive());

            Optional<Category> category2 = categoryRepository.findByCode(categoryProjectionLogin.get(1).getCode());
            assertTrue(category2.isPresent());
            assertTrue(category2.get().isActive());
        }

        @Test
        void findCategoryProjectionByCode__should_be_return_nothing_if_receives_invalid_categoryCode() {
            Optional<CategoryProjectionView> invalid = categoryRepository
                    .findCategoryProjectionByCode("inexist-code");
            assertFalse(invalid.isPresent());
        }

        @Test
        void findCategoryProjectionByCode__should_be_devolve_correct_category() {
            Optional<CategoryProjectionView> programacao = categoryRepository
                    .findCategoryProjectionByCode("programacao");
            assertTrue(programacao.isPresent());
            assertEquals("Programação", programacao.get().getName());

            Optional<CategoryProjectionView> business = categoryRepository.findCategoryProjectionByCode("business");
            assertTrue(business.isPresent());
            assertEquals("Business", business.get().getName());
        }

    }
}