package br.com.coddingSchool.controller;

import br.com.coddingSchool.ControllerTestEnvironment;
import br.com.coddingSchool.model.Category;
import br.com.coddingSchool.model.Course;
import br.com.coddingSchool.model.Subcategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryApiControllerTest extends ControllerTestEnvironment {

    @BeforeEach
    void setup() {
        Category programming = newCategoryProgramming();
        Subcategory kotlin = newSubcategoryKotlin(programming);
        programming.setSubcategories(List.of(kotlin));
        Course kotlinInitial = newCourseKotlinInitial(kotlin);
        kotlin.setCourses(List.of(kotlinInitial));
    }

    @Test
    void categories__should_be_return_correct_data_of_categories() throws Exception {
        mockMvc.perform(get("/api/categories").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Programação"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].code").value("programacao"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].activeSubcategories[0].name")
                        .value("Kotlin"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].activeSubcategories[0].activeCourses[0].name")
                        .value("Iniciando com Kotlin"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1]").doesNotExist());
    }

    @Test
    void invalidateCaches__should_be_devolve_correct_http_status() throws Exception {
            mockMvc.perform(get("/api/cache/bGltcGEtby1jYWNoZS1kYS1hcGktYWU")
            .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}