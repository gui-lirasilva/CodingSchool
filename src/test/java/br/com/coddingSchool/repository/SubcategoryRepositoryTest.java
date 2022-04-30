package br.com.coddingSchool.repository;

import br.com.coddingSchool.DatabaseTestEnvironment;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SubcategoryRepositoryTest extends DatabaseTestEnvironment {

    @BeforeEach
    private void setup() {
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
    void findAllByOrderByName__shouldBeDevolveCorrectSubcategories() {
        assertDoesNotThrow(() -> subcategoryRepository.findAllByOrderByName());
        List<Subcategory> subcategoryList = subcategoryRepository.findAllByOrderByName();
        assertAll("subcategoryList",
                () -> assertEquals(5, subcategoryList.size()),
                () -> assertEquals("AWS", subcategoryList.get(0).getName()),
                () -> assertEquals("Git", subcategoryList.get(1).getName()),
                () -> assertEquals("Java", subcategoryList.get(2).getName()),
                () -> assertEquals("Kotlin", subcategoryList.get(3).getName()),
                () -> assertEquals("Sucesso profissional", subcategoryList.get(4).getName())
        );
    }

    @Test
    void findAllByCategory_CodeOrderByOrderInSystem__shouldBeDevolveCorrectSubcategoriesAndcoursesNumber() {
        assertDoesNotThrow(() -> subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem("programacao"));

        assertTrue(subcategoryRepository.findAllByCategory_CodeOrderByOrderInSystem("invalid-code").isEmpty());

        List<Subcategory> programacaoSubcategories = subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem("programacao");
        assertAll("programacaoSubcategories",
                () -> assertEquals(2, programacaoSubcategories.size()),
                () -> assertEquals(2, programacaoSubcategories.get(0).getCourses().size()),
                () -> assertEquals(1, programacaoSubcategories.get(1).getCourses().size())
        );

        List<Subcategory> devopsSubcategories = subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem("devops");
        assertAll("devopsSubcategories",
                () -> assertEquals(2, devopsSubcategories.size()),
                () -> assertEquals(1, devopsSubcategories.get(0).getCourses().size()),
                () -> assertEquals(1, devopsSubcategories.get(1).getCourses().size())
        );

        List<Subcategory> businessSubcategories = subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem("business");
        assertAll("businessSubcategories",
                () -> assertEquals(1, businessSubcategories.size()),
                () -> assertEquals(1, businessSubcategories.get(0).getCourses().size())
        );
    }

    @Test
    void findAllByCategory_CodeOrderByOrderInSystem__shouldBeDevolveCorrectSubcategoriesAndCourses() {

        List<Subcategory> programacaoSubcategories = subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem("programacao");
        assertAll("programacaoSubcategories",
                () -> assertEquals("Java", programacaoSubcategories.get(0).getName()),
                () -> assertEquals("Kotlin", programacaoSubcategories.get(1).getName())
        );

        List<Subcategory> devopsSubcategories = subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem("devops");
        assertAll("devopsSubcategories",
                () -> assertEquals("Git", devopsSubcategories.get(0).getName()),
                () -> assertEquals("AWS", devopsSubcategories.get(1).getName())
        );

        List<Subcategory> businessSubcategories = subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem("business");
        assertAll("businessSubcategories",
                () -> assertEquals("Sucesso profissional", businessSubcategories.get(0).getName())
        );
    }

    @Test
    void findByCode__shouldBeThrowExceptionIfRecieveInvalidCodeAndNotThrowIfRecieveValidCode() {

        assertThrows(ResponseStatusException.class, () -> subcategoryRepository.findByCode("invalid-code")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

        assertDoesNotThrow(() -> subcategoryRepository.findByCode("java")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

        Subcategory subcategory = subcategoryRepository.findByCode("java")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        assertEquals("Java", subcategory.getName());
    }
}