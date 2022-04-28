package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.projections.InstructorProjection;
import br.com.coddingSchool.util.setup.GeneralSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.PageFormat;
import java.awt.print.Printable;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class CourseRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    private void setup() {
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
    void findInstructorWithMoreCourses() {
        assertDoesNotThrow(() -> courseRepository.findInstructorWithMoreCourses());
        InstructorProjection instructorWithMoreCourses = courseRepository.findInstructorWithMoreCourses();
        assertEquals("Rodrigo", instructorWithMoreCourses.getName());
        assertEquals(2, instructorWithMoreCourses.getCoursesNumber());
    }

    @Test // TODO: Entender como testar com o Pageable
    void findAllBySubcategory_Code() {

    }

    @Test // TODO: Entender como testar com o Pageable
    void findAllDtoBySubcategory_Code() {

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