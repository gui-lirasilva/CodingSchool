package br.com.coddingSchool.repository;

import br.com.coddingSchool.DatabaseTestEnvironment;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

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
    void findAllByOrderByName__should_be_devolve_correct_subcategories() {
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
    void findAllByCategory_CodeOrderByOrderInSystem__should_be_devolve_empty_list_if_receives_invalid_code() {
        List<Subcategory> subcategoryList = subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem("invalid-code");
        assertTrue(subcategoryList.isEmpty());
    }

    @Test
    void findAllByCategory_CodeOrderByOrderInSystem__should_be_devolve_correct_subcategories_and_courses_number() {

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
    void findAllByCategory_CodeOrderByOrderInSystem__should_be_devolve_correct_subcategories_and_courses() {

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
    void findByCode__should_be_return_nothing_if_receives_invalid_subcategory_code() {
        Optional<Subcategory> subcategory = subcategoryRepository.findByCode("invalid-code");
        assertFalse(subcategory.isPresent());
    }

    @Test
    void findByCode__should_be_devolve_correct_subcategory() {
        Optional<Subcategory> subcategory = subcategoryRepository.findByCode("java");
        assertTrue(subcategory.isPresent());
        assertEquals("Java", subcategory.get().getName());
    }
}