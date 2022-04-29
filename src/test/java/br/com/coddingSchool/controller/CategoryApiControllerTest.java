package br.com.coddingSchool.controller;

import br.com.coddingSchool.repository.CategoryRepository;
import br.com.coddingSchool.repository.CourseRepository;
import br.com.coddingSchool.repository.SubcategoryRepository;
import br.com.coddingSchool.util.setup.GeneralSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryApiControllerTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        GeneralSetup generalSetup = new GeneralSetup(categoryRepository, subcategoryRepository, courseRepository);
        generalSetup.setupCourses();
    }

    //TODO: Resolver problema da chave extrangeira que não permite deletar
//    @Transactional
//    @Modifying
//    @AfterEach
//    void cleanDatabase() {
//        categoryRepository.deleteAll();
//    }
    /**
     * You can also temporarily set “FOREIGN_KEY_CHECKS=0”, drop the table and put again “FOREIGN_KEY_CHECKS=1”,
     * but I don’t recommend using this method (especially in a production environment!)
     * */

    @Test // TODO: Renomear
    void categories() {
        assertDoesNotThrow(() -> mockMvc.perform(get("/api/categories").accept(MediaType.APPLICATION_JSON)));
        assertDoesNotThrow(() -> mockMvc.perform(get("/api/categories").accept(MediaType.APPLICATION_XML)));
    }

    @Test // TODO: Renomear
    @Transactional
    void categories__() {
        assertDoesNotThrow(() -> {
            mockMvc.perform(get("/api/categories").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Programação"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].code").value("programacao"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].activeSubcategories[0].name")
                            .value("Java"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].activeSubcategories[0].code")
                            .value("java"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].activeSubcategories[0].activeCourses[0].name")
                            .value("Java e POO"));
        });
    }

    @Test //TODO: Está voltando 302 em vez de 200 | Renomear
    void invalidateCaches() {
        assertDoesNotThrow(() -> {
            mockMvc.perform(get("/api/cache/bGltcGEtby1jYWNoZS1kYS1hcGktYWU").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
        });
    }
}