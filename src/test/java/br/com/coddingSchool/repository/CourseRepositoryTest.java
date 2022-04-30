package br.com.coddingSchool.repository;

import br.com.coddingSchool.DatabaseTestEnvironment;
import br.com.coddingSchool.dto.CourseDTO;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.projections.InstructorProjection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseRepositoryTest extends DatabaseTestEnvironment {

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
    void findInstructorWithMoreCourses() {
        assertDoesNotThrow(() -> courseRepository.findInstructorWithMoreCourses());
        InstructorProjection instructorWithMoreCourses = courseRepository.findInstructorWithMoreCourses();
        assertEquals("Rodrigo", instructorWithMoreCourses.getName());
        assertEquals(2, instructorWithMoreCourses.getCoursesNumber());
    }

    @Test
    void findAllBySubcategory_Code__shouldBeDevolveCorrectCoursesAndCorrectNumber() {
        Page<Course> javaCourses = courseRepository
                .findAllBySubcategory_Code("java", Pageable.unpaged());

        assertAll("javaCourses",
                () -> assertEquals(2, javaCourses.getNumberOfElements()),
                () -> assertEquals("java-poo", javaCourses.getContent().get(0).getCode()),
                () -> assertEquals("java-spring", javaCourses.getContent().get(1).getCode())
        );
    }

    @Test
    void findAllDtoBySubcategory_Code__shouldBeDevolveCorrectCoursesAndCorrectNumber() {
        Page<CourseDTO> javaCoursesDto = courseRepository
                .findAllDtoBySubcategory_Code("java", Pageable.unpaged());

        assertAll("javaCoursesDto",
                () -> assertEquals(2, javaCoursesDto.getNumberOfElements()),
                () -> assertEquals("java-poo", javaCoursesDto.getContent().get(0).getCode()),
                () -> assertEquals("java-spring", javaCoursesDto.getContent().get(1).getCode())
        );
    }

    @Test
    void findByCode() {
        assertDoesNotThrow(() -> courseRepository.findByCode("java-poo")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

        assertThrows(ResponseStatusException.class, () -> courseRepository.findByCode("invalid-code")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

        Course course = courseRepository.findByCode("java-poo")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        assertEquals("Java e POO", course.getName());
    }


}