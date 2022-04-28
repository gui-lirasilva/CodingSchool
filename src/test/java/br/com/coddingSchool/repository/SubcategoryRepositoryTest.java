package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.Subcategory;
import br.com.coddingSchool.util.setup.GeneralSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
class SubcategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @BeforeEach
    private void setup() {
        GeneralSetup generalSetup = new GeneralSetup(categoryRepository, subcategoryRepository, courseRepository);
        generalSetup.setupSubcategories();
    }

    @AfterEach
    void cleanDatabase() {
        subcategoryRepository.deleteAll();
        categoryRepository.deleteAll();
    }

    @Test //TODO: Renomear
    void findAllByOrderByName() {
        assertDoesNotThrow(() -> subcategoryRepository.findAllByOrderByName());
        List<Subcategory> subcategoryList = subcategoryRepository.findAllByOrderByName();
        assertEquals(5, subcategoryList.size());
        assertEquals("AWS", subcategoryList.get(0).getName());
        assertEquals("Git", subcategoryList.get(1).getName());
        assertEquals("Java", subcategoryList.get(2).getName());
        assertEquals("Kotlin", subcategoryList.get(3).getName());
        assertEquals("Sucesso profissional", subcategoryList.get(4).getName());
    }

    @Test //TODO: Renomear
    void findAllByCategory_CodeOrderByOrderInSystem() {
        assertDoesNotThrow(() -> subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem("programacao"));

        assertTrue(subcategoryRepository.findAllByCategory_CodeOrderByOrderInSystem("invalid-code").isEmpty());

        List<Subcategory> programacaoSubcategories = subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem("programacao");
        assertEquals(2, programacaoSubcategories.size());

        List<Subcategory> devopsSubcategories = subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem("devops");
        assertEquals(2, devopsSubcategories.size());

        List<Subcategory> businessSubcategories = subcategoryRepository
                .findAllByCategory_CodeOrderByOrderInSystem("business");
        assertEquals(1, businessSubcategories.size());
    }

    @Test //TODO: Renomear
    void findByCode() {

        assertThrows(ResponseStatusException.class, () -> subcategoryRepository.findByCode("invalid-code")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

        assertDoesNotThrow(() -> subcategoryRepository.findByCode("java")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

        Subcategory subcategory = subcategoryRepository.findByCode("java")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        assertEquals("Java", subcategory.getName());
    }
}